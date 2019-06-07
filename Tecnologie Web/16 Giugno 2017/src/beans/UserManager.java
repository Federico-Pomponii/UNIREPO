package beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class UserManager {

	private List<User> users;
	private Map<Long, List<HttpServletRequest>> sessions;

	public UserManager() {
		super();
		// Initialize users
		users = new ArrayList<User>();
		users.add(new User(1L, "user1", "prova", 1L));
		users.add(new User(2L, "user2", "prova", 2L));
		users.add(new User(3L, "user3", "prova", 2L));
		sessions = new HashMap<Long, List<HttpServletRequest>>();
	}

	public User loginUtente(String username, String password) {
		for (User u : users)
			if (u.getUsername().toLowerCase().equals(username) && u.getPassword().equals(password))
				return u;

		return null;
	}

	public boolean checkUserFinalized(long idUser) {
		System.out.println(this.getClass().getName() + " - finalizeUser " + idUser);
		for (User u : users)
			if (u.getUserId() == idUser)
				return u.isFinalized();

		return false;

	}

	public void finalizeUser(long idUser) {
		System.out.println(this.getClass().getName() + " - finalizeUser " + idUser);
		for (User u : users)
			if (u.getUserId() == idUser)
				u.setFinalized(true);
	}

	public synchronized void resetAllGroup(long idGroup) {
		System.out.println(this.getClass().getName() + " - resetAllGroup " + idGroup);
		for (User u : users)
			if (u.getGroupId() == idGroup)
				u.setFinalized(false);
	}

	public void addUserSession(Long groupId, HttpServletRequest request) {
		// TODO Auto-generated method stub
		if (null == this.sessions.get(groupId))
			this.sessions.get(groupId).add(request);
	}

	public synchronized boolean checkFinalizedGroup(long idGroup) {
		for (HttpServletRequest req : sessions.get(idGroup))
			if(null != req.getSession(false))
				if(!checkUserFinalized(((User) req.getAttribute("user")).getUserId()))
						return false;
				
			return true;
	}

}

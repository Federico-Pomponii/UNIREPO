package beans;

public class User {

	private Long userId;
	private String username;
	private String password;
	private Long groupId; // USING ID OF TYPE LONG FOR DB PURPOUSE
	private boolean finalized;

	public User(Long userId, String username, String password, Long groupId) {
		super();
		this.username = username;
		this.password = password;
		this.groupId = groupId;
		this.userId = userId;
		this.finalized = false;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getUserId() {
		return userId;
	}

	public boolean isFinalized() {
		return finalized;
	}

	public void setFinalized(boolean finalized) {
		this.finalized = finalized;
	}

}

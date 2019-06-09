package servlets;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Catalogo;
import beans.User;
import beans.UserManager;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginServlet() {
		// TODO Auto-generated constructor stub
		System.out.println(getClass().getName());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// The service is called when the servlet is created
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserManager userManager = (UserManager) getServletContext().getAttribute("userManager");

		if (null == userManager)
			request.getSession().setAttribute("applicationError", "Application error!");
		else {
			User user = userManager.loginUtente(username, password);
			request.getSession().setAttribute("login", null != user);
			request.getSession().setAttribute("user", user);
			userManager.addUserSession(user.getGroupId(),request);
		}
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		System.out.println(this.getClass().getName() + " - init()");

		ServletContext ctxApplication = config.getServletContext();
		synchronized (ctxApplication) {
			UserManager userManager = (UserManager) ctxApplication.getAttribute("userManager");
			if (null == userManager) {
				userManager = new UserManager();
				ctxApplication.setAttribute("userManager", userManager);
			}

			Catalogo catalogo = (Catalogo) ctxApplication.getAttribute("catalogo");
			if (null == catalogo) {
				catalogo = new Catalogo();
				ctxApplication.setAttribute("catalogo", catalogo);
			}
		}
	}

}

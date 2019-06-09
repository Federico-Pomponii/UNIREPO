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
 * Servlet implementation class CatalogoServlet
 */
@WebServlet("/CatalogoServlet")
public class CatalogoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CatalogoServlet() {
		super();
		// TODO Auto-generated constructor stub
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

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.service(request, response);
		User user = (User) request.getSession().getAttribute("user");
		if (null == user) {
			request.setAttribute("loginError", "Non sei autenticato"); // Handle user not logged in
			getServletContext().getRequestDispatcher("/checkout.jsp").forward(request, response);
		} else {
			try {
				long idItem = Long.valueOf(request.getParameter("idItem")); // throws NumberFormatException
				int quantity = Integer.valueOf(request.getParameter("quantity")); // throws NumberFormatException
				((Catalogo) getServletContext().getAttribute("catalogo")).addProductToCart(user.getGroupId(), idItem,
						quantity);
			} catch (NumberFormatException e) {
				// TODO: handle exception
				// HANDLE BAD REQUEST
			} catch (NullPointerException e) {
				// HANDLE ERROR
			}
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

package webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.services.UserValidationService;

@WebServlet(urlPatterns = "/login.action")
public class LoginServlet extends HttpServlet {

	final UserValidationService validationService = UserValidationService.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
		String password = request.getParameter("password");

		boolean isUserAllowed = validationService.isUserAllowed(name, password);

		if (!isUserAllowed) {
			request.setAttribute("errorMessage", "Credentials are invalid !!!");
			request.getRequestDispatcher("/WEB-INF/views/Login.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("userName", name);
			response.sendRedirect("/listItem.action");
		}
	}
}

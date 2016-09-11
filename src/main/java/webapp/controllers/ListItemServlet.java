package webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.services.ItemService;

@WebServlet(urlPatterns = "/listItem.action")
public class ListItemServlet extends HttpServlet {
	
	ItemService itemService = ItemService.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userName = (String) request.getSession().getAttribute("userName");
		
		request.setAttribute("userName", userName);
		request.setAttribute("items", itemService.getAll());
		
		request.getRequestDispatcher("/WEB-INF/views/ListItem.jsp").forward(request, response);
	}
}

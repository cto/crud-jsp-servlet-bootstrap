package webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.model.Item;
import webapp.services.ItemService;

@WebServlet(urlPatterns = "/addItem.action")
public class AddItemServlet extends HttpServlet {

	ItemService itemService = ItemService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/AddItem.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPostWithSendRedirect(request, response);
	}
	
	protected void doPostWithRequestDispatcher(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addToService(request);
		
		request.setAttribute("items", itemService.getAll()); //<---- Tai sao lai can cai nay ?
		request.getRequestDispatcher("/WEB-INF/views/ListItem.jsp").forward(request, response);
	}

	private void addToService(HttpServletRequest request) {
		String oneMoreItemName = request.getParameter("nameOfOneMoreItem");
		String oneMoreItemCategory = request.getParameter("categoryOfOneMoreItem");

		if ("".equals(oneMoreItemName)){
			request.setAttribute("errorMessage", "Please enter a valid item");
		} else {
			itemService.addOneItem(new Item(oneMoreItemName, oneMoreItemCategory));
		}
	}

	protected void doPostWithSendRedirect(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addToService(request);
		response.sendRedirect("/listItem.action");
	}

}

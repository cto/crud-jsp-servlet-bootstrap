package webapp.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webapp.model.Item;
import webapp.services.ItemService;

@WebServlet(urlPatterns = "/deleteItem.action")
public class DeleteItemServlet extends HttpServlet {

	ItemService itemService = ItemService.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String itemName = request.getParameter("itemName");
		String itemCategory = request.getParameter("itemCategory");

		itemService.removeOneItem(new Item(itemName, itemCategory));
		response.sendRedirect("/listItem.action");
	}
}

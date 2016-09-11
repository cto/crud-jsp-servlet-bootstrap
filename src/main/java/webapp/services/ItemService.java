package webapp.services;
import java.util.ArrayList;
import java.util.List;

import webapp.model.Item;

public class ItemService {

	private List<Item> items;
	
	private static ItemService instance;
	
	public static ItemService getInstance(){
		if (null == instance){
			instance = new ItemService();
		}
		return instance;
	}
	
	private ItemService(){
		items = new ArrayList<>();
		items.add(new Item("History of the ABC", "Book"));
		items.add(new Item("How to do XYZ", "Book"));
		items.add(new Item("Xiaomi Redmi Note 3", "Mobile phone"));
		items.add(new Item("Body Opponent Bag", "Sport"));
	}
	
	public List<Item> getAll(){
		return items;
	}
	
	public void addOneItem(Item item){
		items.add(item);
	}
	
	public void removeOneItem(Item item){
		items.remove(item);
	}
}

package com.koushik.supermarket;


import java.util.ArrayList;
import java.util.List;

public class ProductStorage {
	
	List<Product> items = new ArrayList<Product>();


	public ProductStorage() {
		super();
		
		items.add(new Product("SODA",2.3,10));
		items.add(new Product("BREAD",1.1,10));
		items.add(new Product("WINE",2.7,10));
	}


	public void updateProductStorage(String itemSelected) {
		
		for(Product temp : items)
		{
			if(temp.getItemName().equals(itemSelected))
			{
				temp.updateItemCount();
			}
		}
		
	}
	
	
}

package com.koushik.supermarket;

public class Product {
	
	private String itemName;
	private double itemPrice;
	private int itemCount = 10;
	
	
	public Product(String itemName, double d, int itemCount) {
		super();
		this.itemName = itemName;
		this.itemPrice = d;
		this.itemCount = itemCount;
	}
	
	public String getItemName() {
		return itemName;
	}
	
	public double getItemPrice() {
		return itemPrice;
	}
	
	public int getItemCount() {
		return itemCount;
	}

	public void updateItemCount() {
		itemCount = itemCount-1;
		
	}
	
	

}

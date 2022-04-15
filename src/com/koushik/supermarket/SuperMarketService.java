package com.koushik.supermarket;

public interface SuperMarketService {

	ProductStorage ps = new ProductStorage();
	CashRegister cr = new CashRegister();
	
	default public void displayProductInventory() {
		for(Product temp : ps.items)
		{
			System.out.println(temp.getItemName() + "  Quantity: " + temp.getItemCount());
		}
	}
	
	default public void displayCashInventory() {
		for(int i=0;i<cr.getAcceptedValues().length;i++)
		{
			System.out.println("Value: " + cr.getAcceptedValues()[i] +", Quantity: " + cr.getavailableCount()[i]);
		}
	}

	default public void displayItems() {

		for (Product temp : ps.items) {
			System.out.print(temp.getItemName() + "( Price: " + temp.getItemPrice() + ")    ");
		}

	}

	default public boolean checkItem(String item) {

		boolean found = false;

		try {

			for (Product temp : ps.items) {
				if (temp.getItemName().equals(item) && temp.getItemCount() > 0) {
					found = true;
				}

			}
			if (found == false) {
				throw new Exception();
			}

		} catch (Exception e) {

			System.out.println("Item not found/Item SoldOut");
		}

		return found;

	}

	default public double getPrice(String item) {
		double price = 0.0;
		for (Product temp : ps.items) {
			if (temp.getItemName().equals(item)) {
				price = temp.getItemPrice();
			}
		}
		return price;
	}

	default public void sellItem(String itemSelected, double value) {
		cr.valuesInserted.add(value);

	}

	default public boolean checkBill(double valueInserted) {
		boolean validBill = false;
		CashRegister cr = new CashRegister();

		try {
			for (int i = 0; i < cr.getAcceptedValues().length; i++) {
				if (cr.getAcceptedValues()[i] == valueInserted)
					validBill = true;
			}
			if (validBill == false)
				throw new Exception();
		} catch (Exception e) {
			System.out.println("Invalid Bill");
		}

		return validBill;
	}

	
}

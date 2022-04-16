package com.koushik.supermarket;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Scanner;

public class SuperMarketServiceImpl implements SuperMarketService {

	private static SuperMarketServiceImpl instance = new SuperMarketServiceImpl();

	private SuperMarketServiceImpl()

	{

	}

	public static void main(String[] args) {
		// SuperMarketService service = new SuperMarketServiceImpl();
		DecimalFormat df = new DecimalFormat("#.#");
		System.out.println("------------------------------------");
		System.out.println("Initial Product Inventory");
		instance.displayProductInventory();
		System.out.println("Initial Cash Inventory");
		instance.displayCashInventory();
		System.out.println("------------------------------------");
		while (true) {
			System.out.println("What would you like to buy? Type in the name of the desired product.");
			instance.displayItems();
			Scanner sc = new Scanner(System.in);

			String itemSelected = sc.nextLine();
			itemSelected = itemSelected.toUpperCase();

			if (instance.checkItem(itemSelected)) {
				System.out.println("You are trying to buy " + itemSelected + " you need to pay: "
						+ instance.getPrice(itemSelected));
				System.out.println("Provide bill or coin (Accepted values: 0.1, 0.5, 1, 2)");
				double valueInserted = sc.nextDouble();
				cr.valuesInserted.add(valueInserted);
				// service.sellItem(itemSelected,service.getPrice(itemSelected));
				if (instance.checkBill(valueInserted)) {
					while (true) {
						if (cr.totalValueInserted() < instance.getPrice(itemSelected)) {

							System.out
									.println("You paid " + cr.totalValueInserted() + " in total. You still need to pay "
											+ df.format(cr.diffAmount(instance.getPrice(itemSelected))));
							cr.valuesInserted.add(sc.nextDouble());
							if (cr.totalValueInserted() < instance.getPrice(itemSelected))
								break;

						} else
							break;
					}

					if (cr.totalValueInserted() > instance.getPrice(itemSelected)) {

						System.out.println("You paid " + cr.totalValueInserted() + " in total. Your change will be: "
								+ df.format(cr.diffAmount(instance.getPrice(itemSelected))));
						System.out.println("Here is your Change: ");

						List<Double> change = cr
								.generateChange(df.format(cr.diffAmount(instance.getPrice(itemSelected))));
						cr.displayChange(change);
					}

					System.out.println("Here is your product: " + itemSelected);
					System.out.println("-------------------------------------");
					cr.updateCashBalance();
					ps.updateProductStorage(itemSelected);
					System.out.println("Updated Product Inventory");
					instance.displayProductInventory();
					System.out.println("Updated cash Balance");
					instance.displayCashInventory();
					cr.valuesInserted.clear();
					cr.change.clear();
				}
			}

		}
	}

}

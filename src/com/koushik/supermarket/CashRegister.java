package com.koushik.supermarket;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CashRegister {

	private double[] acceptedValues = { 0.1, 0.5, 1, 2 };
	private int[] availableCount = { 2, 50, 50, 50 };

	List<Double> valuesInserted = new ArrayList<>();
	List<Double> change = new ArrayList<>();
	DecimalFormat df = new DecimalFormat("#.#");

	public double[] getAcceptedValues() {
		return acceptedValues;
	}

	public int[] getavailableCount() {
		return availableCount;
	}

	public double totalValueInserted() {
		double total = 0.0;
		for (int i = 0; i < valuesInserted.size(); i++) {
			total = total + valuesInserted.get(i);
		}
		total = Math.round(total * 10.0) / 10.0;
		return total;
	}

	public double diffAmount(double d) {
		double diff = 0.0;
		diff = d - totalValueInserted();
		if (diff < 0)
			diff = diff * -1;
		diff = Math.round(diff * 10.0) / 10.0;
		return diff;
	}

	public void updateCashBalance() {

		for (double temp : valuesInserted) {

			for (int i = 0; i < acceptedValues.length; i++) {
				if (acceptedValues[i] == temp) {
					availableCount[i] += 1;
				}
			}

		}

	}

	public List<Double> generateChange(String diff) {

		double difference = Double.parseDouble(diff);
		try {
			while (difference > 0) {
				for (int i = 0; i < availableCount.length; i++) {
					if (availableCount[i] <= 0) {
						throw new Exception();
					}
				}
				if (difference >= 2) {
					difference = difference - 2;

					updateCashBalance(2);
					change.add((double) 2);
				} else if (difference >= 1 && difference < 2) {
					difference = difference - 1;
					updateCashBalance(1);
					change.add((double) 1);
				} else if (difference >= 0.5 && difference < 1) {
					difference = difference - 0.5;
					updateCashBalance(0.5);
					change.add(0.5);
				} else if (difference < 0.5) {
					difference = difference - 0.1;
					updateCashBalance(0.1);
					change.add(0.1);
				}

				difference = Math.round(difference * 10.0) / 10.0;

			}
		} catch (Exception e) {
			System.out.println("Not enough Change");
			System.exit(0);
		}

		return change;

	}

	private void updateCashBalance(double value) {
		for (int i = 0; i < acceptedValues.length; i++) {
			if (acceptedValues[i] == value) {
				availableCount[i] -= 1;
			}
		}

	}

	public void displayChange(List<Double> change) {
		for (int i = 0; i < acceptedValues.length; i++) {
			if (Collections.frequency(change, acceptedValues[i]) != 0) {
				System.out.println("Value: " + acceptedValues[i] + "  Quantity: "
						+ Collections.frequency(change, acceptedValues[i]));
			}
		}
	}

}

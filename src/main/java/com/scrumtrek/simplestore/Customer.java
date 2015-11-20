package com.scrumtrek.simplestore;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	private String m_Name;
	private List<Rental> m_Rentals = new ArrayList<Rental>();

	public Customer(String name) {
		m_Name = name;
	}

	public String getName() {
		return m_Name;
	}

	public void addRental(Rental arg) {
		m_Rentals.add(arg);
	}

	public String generateStatement()
	{
		StatementFormatter formatter = new StatementFormatter(this);

		double totalAmount = 0;
		int frequentRenterPoints = 0;
		
		for(Rental each: m_Rentals) {
			frequentRenterPoints++;

			if (each.getIsBonusRental())
			{
				frequentRenterPoints++;
			}

			double thisAmount = each.calculateAmount();
			formatter.appendRental(each, thisAmount);

			totalAmount += thisAmount;
		}

		formatter.appendTotalAmount(totalAmount);
		formatter.appendRenterPoints(frequentRenterPoints);

		return formatter.getFormattedStatement();
	}
}


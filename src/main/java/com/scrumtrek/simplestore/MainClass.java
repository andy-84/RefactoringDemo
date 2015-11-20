package com.scrumtrek.simplestore;

import java.util.logging.Level;
import java.util.logging.Logger;

class MainClass {
	private MainClass() {
	}

	 static void Main() {
		// Create movies
		Movie movCinderella = new Movie("Cinderella", PriceCodes.Childrens);
		Movie movStarWars = new Movie("Star Wars", PriceCodes.Regular);
		Movie movGladiator = new Movie("Gladiator", PriceCodes.NewRelease);

		// Create customers
		Customer custMickeyMouse = new Customer("Mickey Mouse");

		// Create rentals
		Rental rental1 = new Rental(movCinderella, 5);
		Rental rental2 = new Rental(movStarWars, 5);
		Rental rental3 = new Rental(movGladiator, 5);

		// Assign rentals to customers
		custMickeyMouse.addRental(rental1);
		custMickeyMouse.addRental(rental2);
		custMickeyMouse.addRental(rental3);

		// Generate invoice
		String statement = custMickeyMouse.generateStatement();

		// Print the statement
		 Logger.getGlobal().log(Level.INFO, statement);
	}
}


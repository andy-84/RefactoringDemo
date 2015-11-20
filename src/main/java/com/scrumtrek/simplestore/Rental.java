package com.scrumtrek.simplestore;

public class Rental {
	private Movie m_Movie;
	private int m_DaysRented;

	public Rental(Movie movie, int daysRented) {
		m_Movie = movie;
		m_DaysRented = daysRented;
	}

	public int getDaysRented() {
		return m_DaysRented;
	}

	public Movie getMovie() {
		return m_Movie;
	}

	public double calculateAmount()
	{
		double resultAmount = 0;
		switch(m_Movie.getPriceCode()) {
			case Regular:
				resultAmount += 2;
				if (m_DaysRented > 2)
				{
					resultAmount += (m_DaysRented - 2) * 1.5;
				}
				break;

			case NewRelease:
				resultAmount += m_DaysRented * 3;
				break;

			case Childrens:
				resultAmount += 1.5;
				if (m_DaysRented > 3)
				{
					resultAmount = (m_DaysRented - 3) * 1.5;
				}
				break;
		}
		return resultAmount;
	}
}


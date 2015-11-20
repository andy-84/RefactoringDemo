package com.scrumtrek.simplestore;

public class Rental {
	private Movie m_Movie;
	private int m_DaysRented;
	private boolean m_isBonusRental;

	public Rental(Movie movie, int daysRented) {
		m_Movie = movie;
		m_DaysRented = daysRented;
		m_isBonusRental = (m_Movie.getPriceCode() == PriceCodes.NewRelease) && (m_DaysRented > 1);
	}

	public int getDaysRented() {
		return m_DaysRented;
	}

	public Movie getMovie() {
		return m_Movie;
	}

	public boolean getIsBonusRental()
	{
		return m_isBonusRental;
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

	private double getMinDayConstrainedAmountWithMultiplier(int minDayConstraint, double dayMultiplier)
	{
		// todo if real bug for PriceCodes.Childrens
		return 0;
	}
}


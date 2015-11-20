package com.scrumtrek.simplestore;

/**
 * Created by user on 20.11.2015.
 */
public class StatementFormatter {
    private String m_Statement;

    public StatementFormatter(Customer customer)
    {
        m_Statement += "Rental record for " + customer.getName() + "\n";
    }

    public void appendRental(Rental rental, double amount)
    {
        m_Statement += "\t" + rental.getMovie().getTitle() + "\t" + amount + "\n";
    }

    public void appendTotalAmount(double totalAmount){
        m_Statement += "Amount owed is " + totalAmount + "\n";
    }

    public void appendRenterPoints(int frequentRenterPoints){
        m_Statement += "You earned " + frequentRenterPoints + " frequent renter points.";
    }

    public String getFormattedStatement() {
        return m_Statement;
    }
}

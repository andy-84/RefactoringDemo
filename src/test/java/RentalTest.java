import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {

    private Rental createRentalTestee(PriceCodes priceCode, int daysRented)
    {
        Movie dummyMovie = new Movie("TestMovie", priceCode);
        return new Rental(dummyMovie, daysRented);
    }

    @Test
    public void ShouldReturnValidRentalDays() {
        int daysRented = 3;
        Rental testee = createRentalTestee(PriceCodes.Regular, daysRented);

        assertEquals(daysRented, testee.getDaysRented());
    }

    @Test
    public void ShouldReturnValidMovie() {
        Movie movie = new Movie("TestMovie", PriceCodes.Regular);
        int dummyDaysRented = 3;
        Rental testee = new Rental(movie, dummyDaysRented);

        assertEquals(movie, testee.getMovie());
    }

    @Test
    public void ShouldBeBonusRental()
    {
        Rental testee = createRentalTestee(PriceCodes.NewRelease, 10);
        assertTrue(testee.getIsBonusRental());
    }

    @Test
    public void ShouldNotBeBonusRentalForNonNewReleasePriceCode()
    {
        {
            Rental testee = createRentalTestee(PriceCodes.Regular, 10);
            assertFalse(testee.getIsBonusRental());
        }

        {
            Rental testee = createRentalTestee(PriceCodes.Childrens, 10);
            assertFalse(testee.getIsBonusRental());
        }
    }

    @Test
    public void ShouldNotBeBonusRentalForMinDays()
    {
        int minDaysForNotBonus = 1;

        Rental testee = createRentalTestee(PriceCodes.Regular, minDaysForNotBonus);
        assertFalse(testee.getIsBonusRental());
    }

    @Test
    public void ShouldReturnValidAmountForRegularPriceCodeWithoutDayMultiplier() {
        Rental testee = createRentalTestee(PriceCodes.Regular, 2);

        double expectedAmount = 2;
        assertEquals(expectedAmount, testee.calculateAmount(), 0.1);
    }

    @Test
    public void ShouldReturnValidAmountForRegularPriceCodeWithDayMultiplier() {
        Rental testee = createRentalTestee(PriceCodes.Regular, 10);

        double expectedAmount = 14;
        assertEquals(expectedAmount, testee.calculateAmount(), 0.1);
    }

    @Test
    public void ShouldReturnValidAmountForNewReleasePriceCode() {
        Rental testee = createRentalTestee(PriceCodes.NewRelease, 2);

        double expectedAmount = 6;
        assertEquals(expectedAmount, testee.calculateAmount(), 0.1);
    }

    @Test
    public void ShouldReturnValidAmountForChildrensPriceCodeWithoutDayMultiplier() {
        Rental testee = createRentalTestee(PriceCodes.Childrens, 2);

        double expectedAmount = 1.5;
        assertEquals(expectedAmount, testee.calculateAmount(), 0.1);
    }

    @Test
    public void ShouldReturnValidAmountForChildrensPriceCodeWithDayMultiplier() {
        Rental testee = createRentalTestee(PriceCodes.Childrens, 10);

        double expectedAmount = 10.5;
        assertEquals(expectedAmount, testee.calculateAmount(), 0.1);
    }
}


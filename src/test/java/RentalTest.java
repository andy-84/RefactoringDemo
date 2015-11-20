import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Test;
import static org.junit.Assert.*;

public class RentalTest {
    @Test
    public void ShouldReturnValidRentalDays() {
        Movie dummyMovie = new Movie("dummyMovie", PriceCodes.Regular);
        int daysRented = 3;
        Rental testee = new Rental(dummyMovie, daysRented);

        assertEquals(daysRented, testee.getDaysRented());
    }

    @Test
    public void ShouldReturnValidMovie() {
        Movie movie = new Movie("TestMovie", PriceCodes.Regular);
        int dummyDaysRented = 3;
        Rental testee = new Rental(movie, dummyDaysRented);

        assertEquals(movie, testee.getMovie());
    }
}


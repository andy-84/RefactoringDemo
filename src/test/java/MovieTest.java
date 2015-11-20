import com.scrumtrek.simplestore.Movie;
import com.scrumtrek.simplestore.PriceCodes;
import com.scrumtrek.simplestore.Rental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {
    @Test
    public void ShouldReturnValidName() {
        String testTitle = "TestMovieName";
        PriceCodes testPriceCode = PriceCodes.Regular;
        Movie testee = new Movie(testTitle, testPriceCode);

        assertEquals(testTitle, testee.getTitle());
    }

    @Test
    public void ShouldReturnValidPriceCode() {
        String testTitle = "TestMovieName";
        PriceCodes testPriceCode = PriceCodes.Regular;
        Movie testee = new Movie(testTitle, testPriceCode);

        assertEquals(testPriceCode, testee.getPriceCode());
    }
}
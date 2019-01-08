import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    private Book book;

    @Before
    public void before(){
        book = new Book("High Fidelity","Nick Hornby","Romantic Comedy");
    }

    @Test
    public void canGetGenre(){
        assertEquals("Romantic Comedy", book.getGenre());
    }
}

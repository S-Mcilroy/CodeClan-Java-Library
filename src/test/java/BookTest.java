import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {

    private Book book;

    @Before
    public void before(){
        book = new Book("Random Title", "Random Author", "Adventure");
    }

    @Test
    public void hasTitle(){
        assertEquals("Random Title", book.getTitle());
    }

    @Test
    public void hasAuthor(){
        assertEquals("Random Author", book.getAuthor());
    }

    @Test
    public void hasGenre(){
        assertEquals("Adventure", book.getGenre());
    }

}

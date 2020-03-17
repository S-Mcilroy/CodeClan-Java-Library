import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BorrowerTest {

    private Borrower borrower;
    private Book book;
    private Book bookTwo;
    private Library library;

    @Before
    public void before(){
        borrower = new Borrower();
        bookTwo = new Book("Random TitleTwo", "Random AuthorTwo", "Fantasy");
        book = new Book("Random Title", "Random Author", "Adventure");
        library = new Library(5);
        library.addBook(book);
        library.addBook(bookTwo);
    }

    @Test
    public void borrowerHasNoBooksAtStart(){
        assertEquals(0, borrower.getBookCount());
    }

    @Test
    public void canAddBook(){
        borrower.addBook(book);
        assertEquals(1, borrower.getBookCount());
    }

    @Test
    public void canTakeBookFromLibrary(){
        borrower.borrowBook(library, book);
        assertEquals(1, borrower.getBookCount());
        assertEquals(1, library.stockCount());
    }

}

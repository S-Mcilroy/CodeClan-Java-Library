import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {

    private Library library;
    private Book book;
    private Book bookTwo;
    private Book bookThree;

    @Before
    public void before(){
        library = new Library(5);
        book = new Book("Randon Title", "Random Author", "Adventure");
        bookTwo = new Book("Random Title2", "Random Author2", "Fantasy");
        bookThree = new Book ("Random Title3", "Random Author3", "Adventure");
    }

    @Test
    public void libraryHasCapacity(){
        assertEquals(5, library.getCapacity());
    }

    @Test
    public void libraryStartsZeroStock(){
        assertEquals(0, library.stockCount());
    }

    @Test
    public void canAddBookToStock(){
        library.addBook(book);
        assertEquals(1, library.stockCount());
    }

    @Test
    public void unableToAddOverCapacity(){
        Library smallLibrary = new Library(1);
        smallLibrary.addBook(book);
        smallLibrary.addBook(book);
        assertEquals(1, smallLibrary.stockCount());
    }

    @Test
    public void canRemoveBooks(){
        library.addBook(book);
        library.addBook(bookTwo);
        library.removeBook(book);
        assertEquals(1, library.stockCount());
    }

    @Test
    public void canTrackGenres(){
        library.addBook(book);
        library.addBook(bookTwo);
        assertEquals(1, library.genreCount("Adventure"));
    }

    @Test
    public void canTrackMoreThanOneGenre(){
        library.addBook(book);
        library.addBook(bookTwo);
        library.addBook(bookThree);
        assertEquals(2, library.genreCount("Adventure"));
        assertEquals(1, library.genreCount("Fantasy"));
        library.removeBook(bookThree);
        assertEquals(1, library.genreCount("Adventure"));
    }

}

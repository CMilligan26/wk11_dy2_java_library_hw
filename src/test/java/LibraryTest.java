import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private Library library;
    private Book book;
    private Member member;

    @Before
    public void before(){
        library = new Library(2);
        book = new Book("High Fidelity","Nick Hornby","Romantic Comedy");
        member = new Member();
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canAddBook(){
        library.addBook(book);
        assertEquals(1, library.countBooks());
    }

    @Test
    public void canRemoveBook(){
        library.addBook(book);
        assertEquals(1, library.countBooks());
        assertEquals(book, library.removeBook());
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canCheckCapacity(){
        assertEquals(2, library.checkCapacity());
    }

    @Test
    public void canCheckRemainingCapicity(){
        assertEquals(2, library.checkRemainingCapacity());
    }

    @Test
    public void canCheckCapacityAndAddBook(){
        assertEquals(2, library.checkRemainingCapacity());
        library.addBook(book);
        assertEquals(1, library.checkRemainingCapacity());
    }

    @Test
    public void canCheckCapacityAndCannotAddBook(){
        library.addBook(book);
        assertEquals(1, library.checkRemainingCapacity());
        library.addBook(book);
        assertEquals(0, library.checkRemainingCapacity());
        library.addBook(book);
        assertEquals(0, library.checkRemainingCapacity());
        assertEquals(2, library.countBooks());
    }

    @Test
    public void canCheckOutBookToMember(){
        library.addBook(book);
        assertEquals(1, library.countBooks());
        library.checkOutBookToMember(member);
        assertEquals(0, library.countBooks());
    }

    @Test
    public void canRecordGenreOfAddedBookAndNumberOfBooksForOneBook(){
        library.addBook(book);
        assertEquals(1, library.getNumberOfBooksInGenre(book.getGenre()));
    }

    @Test
    public void canRecordGenreOfAddedBookAndNumberOfBooksForSeveralBooks(){
        Library libraryBiggerCapacity = new Library(5);
        libraryBiggerCapacity.addBook(book);
        libraryBiggerCapacity.addBook(book);
        libraryBiggerCapacity.addBook(book);
        assertEquals(3, libraryBiggerCapacity.getNumberOfBooksInGenre(book.getGenre()));
    }
}

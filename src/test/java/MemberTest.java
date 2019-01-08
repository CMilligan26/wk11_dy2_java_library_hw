import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MemberTest {
    private Member member;
    private Book book;

    @Before
    public void before(){
        member = new Member();
        book = new Book("High Fidelity","Nick Hornby","Romantic Comedy");
    }

    @Test
    public void canCountBooks(){
        assertEquals(0, member.countBooks());
    }

    @Test
    public void canAddBook(){
        member.addBook(book);
        assertEquals(1, member.countBooks());
    }

}

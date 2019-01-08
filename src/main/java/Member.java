import java.util.ArrayList;

public class Member {
    private ArrayList<Book> checkedOutBooks;

    public Member(){
        this.checkedOutBooks = new ArrayList<Book>();
    }

    public int countBooks() {
        return this.checkedOutBooks.size();
    }

    public void addBook(Book bookToAdd) {
        this.checkedOutBooks.add(bookToAdd);
    }
}

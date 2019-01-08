import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private int capacity;

    public Library(int capacity){
        this.books = new ArrayList<Book>();
        this.capacity = capacity;
    }

    public int countBooks() {
       return this.books.size();
    }

    public void addBook(Book bookToAdd) {
        if (this.checkRemainingCapacity() > 0) {
            this.books.add(bookToAdd);
        }
    }

    public int checkCapacity() {
        return this.capacity;
    }

    public int checkRemainingCapacity() {
        return this.capacity - this.books.size();
    }

    public void checkOutBookToMember(Member memberToCheckOutBookTo) {
        Book bookToCheckOut = this.books.get(0);
        memberToCheckOutBookTo.addBook(bookToCheckOut);
    }
}

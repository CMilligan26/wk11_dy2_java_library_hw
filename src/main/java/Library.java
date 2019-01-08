import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> books;
    private int capacity;
    private HashMap<String,Integer> genres;

    public Library(int capacity){
        this.books = new ArrayList<Book>();
        this.capacity = capacity;
        this.genres = new HashMap<String,Integer>();
    }

    public int countBooks() {
       return this.books.size();
    }

    public void addBook(Book bookToAdd) {
        if (this.checkRemainingCapacity() > 0) {
            this.books.add(bookToAdd);
            this.addGenreOrIncreaseNumberOfBooksForGenre(bookToAdd);
        }
    }

    public void addGenreOrIncreaseNumberOfBooksForGenre(Book bookToAdd){
        String genre = bookToAdd.getGenre();
        if (!this.genres.containsKey(genre)) {
            this.genres.put(genre, 1);
        }
        else {
            int currentNumberOfBooksInGenre = this.genres.get(genre);
            int newNumberOfBooksInGenre = currentNumberOfBooksInGenre+1;
           this.genres.replace(genre, currentNumberOfBooksInGenre, newNumberOfBooksInGenre);
        }
    }

    public Book removeBook() {
        return this.books.remove(0);
    }

    public int checkCapacity() {
        return this.capacity;
    }

    public int checkRemainingCapacity() {
        return this.capacity - this.books.size();
    }

    public void checkOutBookToMember(Member memberToCheckOutBookTo) {
        Book bookToCheckOut = this.removeBook();
        memberToCheckOutBookTo.addBook(bookToCheckOut);
    }

    public Object getNumberOfBooksInGenre(String genreToGetNumberOfBooksFor) {
        return this.genres.get(genreToGetNumberOfBooksFor);
    }
}

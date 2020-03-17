import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private ArrayList<Book> stock;
    private int capacity;
    private HashMap<String, Integer> genreTotals;

    public Library(int capacity){
        this.capacity = capacity;
        this.stock = new ArrayList<Book>();
        this.genreTotals = new HashMap<String, Integer>();
    }

    public int stockCount(){
        return this.stock.size();
    }

    public int getCapacity(){
        return this.capacity;
    }

    public void addBook(Book book){
        if (stockCount() < getCapacity()){
            this.stock.add(book);
            if (this.genreTotals.containsKey(book.getGenre())){
                this.genreTotals.put(book.getGenre(), genreTotals.get(book.getGenre())+ 1);
            } else {
                this.genreTotals.put(book.getGenre(), 1);
            }
        }
    }

    public Book removeBook(Book book){
        this.genreTotals.put(book.getGenre(), genreTotals.get(book.getGenre())- 1);
        if (genreTotals.get(book.getGenre()) <= 0){
            this.genreTotals.remove((book.getGenre()));
        }
        return this.stock.remove(stock.indexOf(book));
    }

    public int genreCount(String genre){
        return this.genreTotals.get(genre);
    }

}

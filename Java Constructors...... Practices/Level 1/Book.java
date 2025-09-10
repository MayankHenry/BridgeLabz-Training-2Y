public class Book {
    String title;
    String author;
    double price;
    
    public Book() {
        title = "Unknown";
        author = "Unknown";
        price = 0.0;
    }
    
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    public static void main(String[] args) {
        Book defaultBook = new Book();
        Book customBook = new Book("Java Programming", "John Doe", 29.99);
        
        System.out.println("Default Book: " + defaultBook.title + " by " + defaultBook.author + ", $" + defaultBook.price);
        System.out.println("Custom Book: " + customBook.title + " by " + customBook.author + ", $" + customBook.price);
    }
}
public class LibraryBook {
    String title;
    String author;
    double price;
    boolean availability;
    
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true;
    }
    
    public boolean borrowBook() {
        if (availability) {
            availability = false;
            return true;
        }
        return false;
    }
    
    public void returnBook() {
        availability = true;
    }
    
    public static void main(String[] args) {
        LibraryBook book = new LibraryBook("Java Programming", "John Doe", 29.99);
        
        System.out.println("Book: " + book.title + " by " + book.author);
        System.out.println("Initial availability: " + (book.availability ? "Available" : "Not Available"));
        
        boolean borrowed = book.borrowBook();
        System.out.println("Borrow attempt: " + (borrowed ? "Successful" : "Failed"));
        System.out.println("Availability after borrowing: " + (book.availability ? "Available" : "Not Available"));
        
        boolean secondBorrow = book.borrowBook();
        System.out.println("Second borrow attempt: " + (secondBorrow ? "Successful" : "Failed"));
        
        book.returnBook();
        System.out.println("Availability after returning: " + (book.availability ? "Available" : "Not Available"));
    }
}
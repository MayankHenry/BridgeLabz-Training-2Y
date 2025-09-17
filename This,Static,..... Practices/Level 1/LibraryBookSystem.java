public class LibraryBookSystem {
    public static void main(String[] args) {
        Book.libraryName = "City Library";
        Book b1 = new Book("Clean Code", "Robert Martin", "ISBN-001");
        Object ref = b1;
        if (ref instanceof Book) {
            ((Book) ref).display();
        }
        Book.displayLibraryName();
    }
}

class Book {
    static String libraryName;
    final String isbn;
    String title;
    String author;

    Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void display() {
        System.out.println("Library: " + libraryName + ", Title: " + title + ", Author: " + author + ", ISBN: " + isbn);
    }
}



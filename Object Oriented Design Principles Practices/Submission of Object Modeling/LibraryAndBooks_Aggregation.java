import java.util.*;

class Book {
	private String title;
	private String author;

	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}
}

class Library {
	private String name;
	private List<Book> books = new ArrayList<>();

	public Library(String name) {
		this.name = name;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public void listBooks() {
		System.out.println("Library: " + name);
		for (Book b : books) {
			System.out.println(b.getTitle() + " by " + b.getAuthor());
		}
	}
}

public class LibraryAndBooks_Aggregation {
	public static void main(String[] args) {
		Book b1 = new Book("Clean Code", "Robert C. Martin");
		Book b2 = new Book("Effective Java", "Joshua Bloch");
		Library l1 = new Library("City Library");
		Library l2 = new Library("College Library");
		l1.addBook(b1);
		l1.addBook(b2);
		l2.addBook(b2);
		l1.listBooks();
		System.out.println("---");
		l2.listBooks();
	}
}

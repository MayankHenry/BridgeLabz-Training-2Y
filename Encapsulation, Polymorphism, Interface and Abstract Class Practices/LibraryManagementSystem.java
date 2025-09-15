import java.util.*;

interface Reservable {
	boolean reserveItem(String userId);
	boolean checkAvailability();
}

abstract class LibraryItem {
	private String itemId;
	private String title;
	private String author;

	public LibraryItem(String itemId, String title, String author) {
		this.itemId = itemId;
		this.title = title;
		this.author = author;
	}

	public String getItemId() {
		return itemId;
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getItemDetails() {
		return itemId + " - " + title + " by " + author;
	}

	public abstract int getLoanDuration();
}

class BookItem extends LibraryItem implements Reservable {
	private boolean reserved;

	public BookItem(String itemId, String title, String author) {
		super(itemId, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 14;
	}

	@Override
	public boolean reserveItem(String userId) {
		if (reserved) return false;
		reserved = true;
		return true;
	}

	@Override
	public boolean checkAvailability() {
		return !reserved;
	}
}

class MagazineItem extends LibraryItem implements Reservable {
	private boolean reserved;

	public MagazineItem(String itemId, String title, String author) {
		super(itemId, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 7;
	}

	@Override
	public boolean reserveItem(String userId) {
		if (reserved) return false;
		reserved = true;
		return true;
	}

	@Override
	public boolean checkAvailability() {
		return !reserved;
	}
}

class DVDItem extends LibraryItem implements Reservable {
	private boolean reserved;

	public DVDItem(String itemId, String title, String author) {
		super(itemId, title, author);
	}

	@Override
	public int getLoanDuration() {
		return 3;
	}

	@Override
	public boolean reserveItem(String userId) {
		if (reserved) return false;
		reserved = true;
		return true;
	}

	@Override
	public boolean checkAvailability() {
		return !reserved;
	}
}

public class LibraryManagementSystem {
	public static void main(String[] args) {
		List<LibraryItem> items = new ArrayList<>();
		items.add(new BookItem("B001", "Clean Code", "Robert C. Martin"));
		items.add(new MagazineItem("M001", "Science Weekly", "Editors"));
		items.add(new DVDItem("D001", "Algorithms", "Tech Films"));

		for (LibraryItem it : items) {
			System.out.println(it.getItemDetails());
			System.out.println("Loan days: " + it.getLoanDuration());
			if (it instanceof Reservable) {
				Reservable r = (Reservable) it;
				System.out.println("Available: " + r.checkAvailability());
				System.out.println("Reserve: " + r.reserveItem("U100"));
				System.out.println("Available: " + r.checkAvailability());
			}
			System.out.println("---");
		}
	}
}

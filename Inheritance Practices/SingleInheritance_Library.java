public class SingleInheritance_Library {
	public static void main(String[] args) {
		AuthorBook ab = new AuthorBook("Clean Code", 2008, "Robert C. Martin", "Software craftsmanship");
		ab.displayInfo();
	}
}

class Book {
	String title;
	int publicationYear;

	Book(String title, int publicationYear) {
		this.title = title;
		this.publicationYear = publicationYear;
	}
}

class AuthorBook extends Book {
	String name;
	String bio;

	AuthorBook(String title, int publicationYear, String name, String bio) {
		super(title, publicationYear);
		this.name = name;
		this.bio = bio;
	}

	void displayInfo() {
		System.out.println("Title: " + title);
		System.out.println("Year: " + publicationYear);
		System.out.println("Author: " + name);
		System.out.println("Bio: " + bio);
	}
}

class BookNode {
    String title;
    String author;
    String genre;
    int id;
    boolean isAvailable;
    BookNode prev;
    BookNode next;

    public BookNode(String title, String author, String genre, int id, boolean isAvailable) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.isAvailable = isAvailable;
    }
}

public class LibraryManager {
    private BookNode head;
    private BookNode tail;
    private int count = 0;

    public void add(String title, String author, String genre, int id, boolean isAvailable, int pos) {
        BookNode newNode = new BookNode(title, author, genre, id, isAvailable);
        count++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (pos == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        BookNode current = head;
        for (int i = 0; i < pos - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) current.next.prev = newNode;
        else tail = newNode;
        current.next = newNode;
    }

    public void remove(int id) {
        BookNode current = head;
        while (current != null) {
            if (current.id == id) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                count--;
                return;
            }
            current = current.next;
        }
    }

    public BookNode search(String query) {
        BookNode current = head;
        while (current != null) {
            if (current.title.equals(query) || current.author.equals(query)) return current;
            current = current.next;
        }
        return null;
    }

    public void updateStatus(int id, boolean status) {
        BookNode current = head;
        while (current != null) {
            if (current.id == id) {
                current.isAvailable = status;
                return;
            }
            current = current.next;
        }
    }

    public void displayForward() {
        BookNode current = head;
        while (current != null) {
            System.out.println(current.title);
            current = current.next;
        }
    }

    public void displayReverse() {
        BookNode current = tail;
        while (current != null) {
            System.out.println(current.title);
            current = current.prev;
        }
    }

    public int countBooks() {
        return count;
    }
}
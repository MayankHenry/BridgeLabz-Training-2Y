class MovieNode {
    String title;
    String director;
    int year;
    double rating;
    MovieNode prev;
    MovieNode next;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
    }
}

public class MovieManager {
    private MovieNode head;
    private MovieNode tail;

    public void add(String title, String director, int year, double rating, int position) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        if (position == 0) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return;
        }
        MovieNode current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
    }

    public void remove(String title) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                if (current.prev != null) current.prev.next = current.next;
                else head = current.next;
                
                if (current.next != null) current.next.prev = current.prev;
                else tail = current.prev;
                return;
            }
            current = current.next;
        }
    }

    public MovieNode search(String query, boolean isDirector) {
        MovieNode current = head;
        while (current != null) {
            if (isDirector && current.director.equals(query)) return current;
            if (!isDirector && String.valueOf(current.rating).equals(query)) return current;
            current = current.next;
        }
        return null;
    }

    public void displayForward() {
        MovieNode current = head;
        while (current != null) {
            System.out.println(current.title);
            current = current.next;
        }
    }

    public void displayReverse() {
        MovieNode current = tail;
        while (current != null) {
            System.out.println(current.title);
            current = current.prev;
        }
    }

    public void updateRating(String title, double newRating) {
        MovieNode current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                return;
            }
            current = current.next;
        }
    }
}
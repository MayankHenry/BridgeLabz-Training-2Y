public class MovieTicket {
    private String movieName;
    private String seatNumber;
    private double price;

    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "";
        this.price = 0.0;
    }

    public void bookTicket(String seatNumber) {
        this.seatNumber = seatNumber;
        updatePrice();
        System.out.println("Ticket booked successfully for " + movieName + ", Seat: " + seatNumber);
    }

    private void updatePrice() {
        // Price calculation based on seat number
        // Assuming seats starting with A are premium, B are standard, and others are economy
        if (seatNumber.startsWith("A")) {
            price = 15.0; // Premium seats
        } else if (seatNumber.startsWith("B")) {
            price = 12.0; // Standard seats
        } else {
            price = 10.0; // Economy seats
        }
    }

    public void displayTicketDetails() {
        System.out.println("Ticket Details:");
        System.out.println("Movie: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: $" + price);
    }

    public static void main(String[] args) {
        MovieTicket ticket = new MovieTicket("Avengers: Endgame");
        ticket.bookTicket("A12");
        ticket.displayTicketDetails();
        
        MovieTicket ticket2 = new MovieTicket("Spider-Man: No Way Home");
        ticket2.bookTicket("C5");
        ticket2.displayTicketDetails();
    }
}
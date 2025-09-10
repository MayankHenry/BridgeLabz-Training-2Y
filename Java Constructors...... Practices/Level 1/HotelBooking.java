public class HotelBooking {
    String guestName;
    String roomType;
    int nights;
    
    public HotelBooking() {
        guestName = "Guest";
        roomType = "Standard";
        nights = 1;
    }
    
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }
    
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }
    
    public static void main(String[] args) {
        HotelBooking defaultBooking = new HotelBooking();
        HotelBooking customBooking = new HotelBooking("John Smith", "Deluxe", 3);
        HotelBooking copiedBooking = new HotelBooking(customBooking);
        
        System.out.println("Default Booking: " + defaultBooking.guestName + ", " + defaultBooking.roomType + ", " + defaultBooking.nights + " nights");
        System.out.println("Custom Booking: " + customBooking.guestName + ", " + customBooking.roomType + ", " + customBooking.nights + " nights");
        System.out.println("Copied Booking: " + copiedBooking.guestName + ", " + copiedBooking.roomType + ", " + copiedBooking.nights + " nights");
    }
}
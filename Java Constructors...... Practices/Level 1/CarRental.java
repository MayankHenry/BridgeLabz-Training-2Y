public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private static final double DAILY_RATE = 50.0;
    
    public CarRental() {
        this.customerName = "";
        this.carModel = "";
        this.rentalDays = 0;
    }
    
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }
    
    public double calculateTotalCost() {
        return rentalDays * DAILY_RATE;
    }
    
    public String getCustomerName() {
        return customerName;
    }
    
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    
    public String getCarModel() {
        return carModel;
    }
    
    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }
    
    public int getRentalDays() {
        return rentalDays;
    }
    
    public void setRentalDays(int rentalDays) {
        this.rentalDays = rentalDays;
    }
    
    public void displayRentalDetails() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
    
    public static void main(String[] args) {
        CarRental rental1 = new CarRental();
        rental1.setCustomerName("John Smith");
        rental1.setCarModel("Toyota Camry");
        rental1.setRentalDays(5);
        
        CarRental rental2 = new CarRental("Jane Doe", "Honda Civic", 7);
        
        rental1.displayRentalDetails();
        System.out.println();
        rental2.displayRentalDetails();
    }
}

public class VehicleRegistrationSystem {
    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(2500.0);
        Vehicle v1 = new Vehicle("Raj", "Car", "REG-9001");
        Object ref = v1;
        if (ref instanceof Vehicle) {
            ((Vehicle) ref).display();
        }
        Vehicle.updateRegistrationFee(2700.0);
        v1.display();
    }
}

class Vehicle {
    static double registrationFee;
    final String registrationNumber;
    String ownerName;
    String vehicleType;

    Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    static void updateRegistrationFee(double fee) {
        registrationFee = fee;
    }

    void display() {
        System.out.println("Owner: " + ownerName + ", Type: " + vehicleType + ", Reg#: " + registrationNumber + ", Fee: " + registrationFee);
    }
}



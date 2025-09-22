interface IPayable {
    double calculateCharges(int hours);
}

class ParkingSlot {
    private int slotId;
    private boolean isOccupied=false;
    private String vehicleTypeAllowed;

    ParkingSlot(int id, String type){ slotId=id; vehicleTypeAllowed=type; }

    public boolean occupySlot(){ 
        if(!isOccupied){ isOccupied=true; return true; } 
        return false; 
    }
    public void freeSlot(){ isOccupied=false; }
    public boolean isAvailable(){ return !isOccupied; }
    public String getVehicleTypeAllowed(){ return vehicleTypeAllowed; }
}

abstract class Vehicle implements IPayable {
    protected String number;
    protected double baseRate;

    Vehicle(String num, double rate){ number=num; baseRate=rate; }
    public abstract double calculateCharges(int hours);
}

class Car extends Vehicle {
    Car(String num){ super(num,20); }
    public double calculateCharges(int hours){ return baseRate*hours; }
}

class Bike extends Vehicle {
    Bike(String num){ super(num,10); }
    public double calculateCharges(int hours){ return baseRate*hours*0.9; } // 10% discount
}

class Truck extends Vehicle {
    Truck(String num){ super(num,30); }
    public double calculateCharges(int hours){ return baseRate*hours+50; } // penalty added
}

public class ParkEaseApp {
    public static void main(String[] args){
        ParkingSlot s1=new ParkingSlot(1,"Car");
        ParkingSlot s2=new ParkingSlot(2,"Bike");

        Vehicle v1=new Car("CAR123");
        Vehicle v2=new Bike("BIKE456");

        if(s1.occupySlot()) System.out.println(v1.number+" parked in slot "+s1.getVehicleTypeAllowed());
        System.out.println("Charges: "+v1.calculateCharges(5));

        if(s2.occupySlot()) System.out.println(v2.number+" parked in slot "+s2.getVehicleTypeAllowed());
        System.out.println("Charges: "+v2.calculateCharges(3));

        s1.freeSlot();
        System.out.println("Slot 1 available: "+s1.isAvailable());
    }
}

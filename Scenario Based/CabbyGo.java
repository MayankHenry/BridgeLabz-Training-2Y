interface IRideService {
    void bookRide(double distance);
    void endRide();
}

abstract class Vehicle {
    private String vehicleNumber;
    private int capacity;
    private String type;
    protected double baseFare;
    protected double rate;

    Vehicle(String num,int cap,String t,double base,double r){
        vehicleNumber=num; capacity=cap; type=t; baseFare=base; rate=r;
    }
    public String getType(){ return type; }
}

class Mini extends Vehicle {
    Mini(String num){ super(num,4,"Mini",50,10); }
}
class Sedan extends Vehicle {
    Sedan(String num){ super(num,4,"Sedan",100,15); }
}
class SUV extends Vehicle {
    SUV(String num){ super(num,6,"SUV",150,20); }
}

class Driver {
    private String name;
    private String licenseNumber;
    private double rating;

    Driver(String n,String lic,double r){ name=n; licenseNumber=lic; rating=r; }
    public String getName(){ return name; }
    public double getRating(){ return rating; }
}

class Ride implements IRideService {
    private Vehicle vehicle;
    private Driver driver;
    private double fare; 
    private boolean ongoing=false;

    Ride(Vehicle v,Driver d){ vehicle=v; driver=d; }

    public void bookRide(double distance){
        ongoing=true;
        fare=vehicle.baseFare+distance*vehicle.rate; 
        System.out.println("Ride started with "+driver.getName()+" in "+vehicle.getType());
    }
    public void endRide(){
        if(ongoing){
            ongoing=false;
            System.out.println("Ride ended. Fare: "+fare);
        } else System.out.println("No ride in progress");
    }
    public double getFare(){ return fare; } 
}

public class CabbyGo {
    public static void main(String[] args){
        Vehicle v1=new Mini("MH12AB1234");
        Driver d1=new Driver("Amit","LIC123",4.8);
        Ride r1=new Ride(v1,d1);

        r1.bookRide(12);
        r1.endRide();

        Vehicle v2=new SUV("DL09XY9999");
        Driver d2=new Driver("Riya","LIC456",4.5);
        Ride r2=new Ride(v2,d2);

        r2.bookRide(20);
        r2.endRide();
    }
}

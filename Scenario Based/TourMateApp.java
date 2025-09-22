interface IBookable {
    void book();
    void cancel();
}

class Transport implements IBookable {
    private String mode;
    private double cost;
    Transport(String m,double c){ mode=m; cost=c; }
    public double getCost(){ return cost; }
    public void book(){ System.out.println("Transport booked: "+mode); }
    public void cancel(){ System.out.println("Transport cancelled: "+mode); }
}

class Hotel implements IBookable {
    private String name;
    private double cost;
    Hotel(String n,double c){ name=n; cost=c; }
    public double getCost(){ return cost; }
    public void book(){ System.out.println("Hotel booked: "+name); }
    public void cancel(){ System.out.println("Hotel cancelled: "+name); }
}

class Activity implements IBookable {
    private String name;
    private double cost;
    Activity(String n,double c){ name=n; cost=c; }
    public double getCost(){ return cost; }
    public void book(){ System.out.println("Activity booked: "+name); }
    public void cancel(){ System.out.println("Activity cancelled: "+name); }
}

abstract class Trip {
    protected String destination;
    protected double budget;
    protected int duration;
    protected Transport transport;
    protected Hotel hotel;
    protected Activity[] activities;
    protected int activityCount=0;

    Trip(String dest,double b,int d,Transport t,Hotel h){
        destination=dest; budget=b; duration=d;
        transport=t; hotel=h;
        activities=new Activity[10];
    }

    public void addActivity(Activity a){ if(activityCount<10) activities[activityCount++]=a; }

    protected double totalCost(){
        double total=transport.getCost()+hotel.getCost();
        for(int i=0;i<activityCount;i++) total+=activities[i].getCost();
        return total;
    }

    public abstract void book();
    public abstract void cancel();
}

class InternationalTrip extends Trip {
    InternationalTrip(String dest,double b,int d,Transport t,Hotel h){ super(dest,b,d,t,h); }

    public void book(){
        System.out.println("Booking International Trip to "+destination);
        transport.book(); hotel.book();
        for(int i=0;i<activityCount;i++) activities[i].book();
        System.out.println("Total cost: "+totalCost());
    }

    public void cancel(){
        System.out.println("Cancelling International Trip to "+destination);
        transport.cancel(); hotel.cancel();
        for(int i=0;i<activityCount;i++) activities[i].cancel();
    }
}

class DomesticTrip extends Trip {
    DomesticTrip(String dest,double b,int d,Transport t,Hotel h){ super(dest,b,d,t,h); }

    public void book(){
        System.out.println("Booking Domestic Trip to "+destination);
        transport.book(); hotel.book();
        for(int i=0;i<activityCount;i++) activities[i].book();
        System.out.println("Total cost: "+totalCost());
    }

    public void cancel(){
        System.out.println("Cancelling Domestic Trip to "+destination);
        transport.cancel(); hotel.cancel();
        for(int i=0;i<activityCount;i++) activities[i].cancel();
    }
}

public class TourMateApp {
    public static void main(String[] args){
        Transport t1=new Transport("Flight",500);
        Hotel h1=new Hotel("Hilton",300);
        Activity a1=new Activity("City Tour",100);
        Activity a2=new Activity("Museum Visit",50);

        Trip trip=new InternationalTrip("Paris",2000,5,t1,h1);
        trip.addActivity(a1); trip.addActivity(a2);

        trip.book();
        System.out.println();
        trip.cancel();
    }
}

interface ISchedulable {
    void schedule();
    void reschedule(String newDate);
    void cancel();
}

class User {
    private String name, email;
    User(String n,String e){ name=n; email=e; }
    public String getName(){ return name; }
}

abstract class Event implements ISchedulable {
    protected String eventName, location, date;
    protected int attendees;
    private int eventId; // cannot be edited once assigned
    protected double venueCost;
    protected double serviceCost;
    protected double discount;

    private static int nextId=1;

    Event(String name,String loc,String d,int att,double venue,double service,double disc){
        eventName=name; location=loc; date=d; attendees=att;
        venueCost=venue; serviceCost=service; discount=disc;
        eventId=nextId++;
    }

    protected double calculateTotalCost(){ return venueCost+serviceCost-discount; }

    public int getEventId(){ return eventId; }
    public void showEventInfo(){ System.out.println(eventName+" at "+location+" on "+date+" Total Cost:"+calculateTotalCost()); }
}

class BirthdayEvent extends Event {
    BirthdayEvent(String n,String loc,String d,int att,double venue,double service,double disc){
        super(n,loc,d,att,venue,service,disc);
    }
    public void schedule(){ System.out.println("Birthday Event Scheduled: "+eventName+" on "+date); }
    public void reschedule(String newDate){ date=newDate; System.out.println("Birthday Event Rescheduled to "+date); }
    public void cancel(){ System.out.println("Birthday Event Cancelled: "+eventName); }
}

class ConferenceEvent extends Event {
    ConferenceEvent(String n,String loc,String d,int att,double venue,double service,double disc){
        super(n,loc,d,att,venue,service,disc);
    }
    public void schedule(){ System.out.println("Conference Scheduled: "+eventName+" on "+date); }
    public void reschedule(String newDate){ date=newDate; System.out.println("Conference Rescheduled to "+date); }
    public void cancel(){ System.out.println("Conference Cancelled: "+eventName); }
}

public class EventEaseApp {
    public static void main(String[] args){
        User u=new User("Amit","amit@mail.com");

        Event e1=new BirthdayEvent("Amit's Birthday","City Hall","2025-10-01",50,5000,2000,500);
        Event e2=new ConferenceEvent("Tech Conference","Expo Center","2025-11-15",200,20000,5000,1000);

        e1.schedule();
        e2.schedule();

        e1.reschedule("2025-10-05");
        e2.cancel();

        e1.showEventInfo();
        e2.showEventInfo();
    }
}

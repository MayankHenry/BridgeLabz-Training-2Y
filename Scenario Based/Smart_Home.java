interface Controllable {
    void turnOn();
    void turnOff();
}

abstract class Appliance implements Controllable {
    private boolean state;
    private int power;

    Appliance(int p){ power=p; }
    public int getPower(){ return power; }
    public boolean isOn(){ return state; }
    protected void setState(boolean s){ state=s; }

    public int comparePower(Appliance other){
        if(this.power>other.power) return 1;
        if(this.power<other.power) return -1;
        return 0;
    }
}

class Light extends Appliance {
    Light(int p){ super(p); }
    public void turnOn(){ setState(true); System.out.println("Light On with "+getPower()+"W"); }
    public void turnOff(){ setState(false); System.out.println("Light Off"); }
}

class Fan extends Appliance {
    Fan(int p){ super(p); }
    public void turnOn(){ setState(true); System.out.println("Fan Spinning at "+getPower()+"W"); }
    public void turnOff(){ setState(false); System.out.println("Fan Off"); }
}

class AC extends Appliance {
    AC(int p){ super(p); }
    public void turnOn(){ setState(true); System.out.println("AC Cooling at "+getPower()+"W"); }
    public void turnOff(){ setState(false); System.out.println("AC Off"); }
}

class UserController {
    void control(Appliance a,boolean on){
        if(on) a.turnOn(); else a.turnOff();
    }
}

public class Smart_Home {
    public static void main(String[] args){
        Appliance l=new Light(60);
        Appliance f=new Fan(120);
        Appliance ac=new AC(1500);
        UserController u=new UserController();

        u.control(l,true);
        u.control(f,true);
        u.control(ac,true);

        System.out.println("Compare Fan vs AC: "+f.comparePower(ac)); // -1
        System.out.println("Compare Light vs Fan: "+l.comparePower(f)); // -1

        u.control(ac,false);
        u.control(f,false);
        u.control(l,false);
    }
}

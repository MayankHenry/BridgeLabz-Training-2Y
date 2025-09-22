interface ITrackable {
    void startWorkout();
    void stopWorkout();
}

class UserProfile {
    private String name;
    private int age;
    private double weight;
    private double goal; // daily calorie target

    UserProfile(String n, int a, double w){ name=n; age=a; weight=w; goal=500; } // default goal
    UserProfile(String n, int a, double w, double g){ name=n; age=a; weight=w; goal=g; }

    public double getGoal(){ return goal; }
    public double getWeight(){ return weight; }
}

abstract class Workout implements ITrackable {
    protected String type;
    protected double duration; // in minutes
    protected double caloriesBurned;

    Workout(String t, double dur){ type=t; duration=dur; }

    public abstract void calculateCalories();

    public void startWorkout(){ System.out.println(type+" workout started."); }
    public void stopWorkout(){ System.out.println(type+" workout stopped. Calories burned: "+caloriesBurned); }
}

class CardioWorkout extends Workout {
    CardioWorkout(double dur){ super("Cardio",dur); }
    public void calculateCalories(){ caloriesBurned=duration*8; } // simple formula
}

class StrengthWorkout extends Workout {
    StrengthWorkout(double dur){ super("Strength",dur); }
    public void calculateCalories(){ caloriesBurned=duration*6; } // simple formula
}

public class FitTrackApp {
    public static void main(String[] args){
        UserProfile user=new UserProfile("Amit",25,70);

        Workout w1=new CardioWorkout(30);
        w1.startWorkout();
        w1.calculateCalories();
        w1.stopWorkout();

        Workout w2=new StrengthWorkout(20);
        w2.startWorkout();
        w2.calculateCalories();
        w2.stopWorkout();

        double progress=user.getGoal()-(w1.caloriesBurned+w2.caloriesBurned);
        System.out.println("Calories remaining to reach daily goal: "+progress);
    }
}

import java.util.Scanner;

public class TriangleParkRun {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the length of first side (in meters): ");
        double side1 = sc.nextDouble();
        
        System.out.print("Enter the length of second side (in meters): ");
        double side2 = sc.nextDouble();
        
        System.out.print("Enter the length of third side (in meters): ");
        double side3 = sc.nextDouble();
        
        int rounds = calculateRounds(side1, side2, side3);
        
        System.out.println("To complete a 5 km run, the athlete needs to complete " + rounds + " rounds.");
        
        sc.close();
    }
    
    static int calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double distance = 5000; // 5 km in meters
        
        return (int) Math.ceil(distance / perimeter);
    }
}
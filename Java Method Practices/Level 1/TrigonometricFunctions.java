import java.util.Scanner;

public class TrigonometricFunctions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter angle in degrees: ");
        double angle = sc.nextDouble();
        
        double[] result = calculateTrigonometricFunctions(angle);
        
        System.out.println("Sine value: " + result[0]);
        System.out.println("Cosine value: " + result[1]);
        System.out.println("Tangent value: " + result[2]);
        
        sc.close();
    }
    
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        
        double sine = Math.sin(radians);
        double cosine = Math.cos(radians);
        double tangent = Math.tan(radians);
        
        return new double[] {sine, cosine, tangent};
    }
}
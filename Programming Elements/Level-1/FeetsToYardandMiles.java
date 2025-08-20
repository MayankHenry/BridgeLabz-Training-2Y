import java.util.Scanner;

public class FeetsToYardandMiles {
        public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");   
        double feet = scanner.nextDouble();
        double yards = feet / 3;
        double miles = feet / 5280;
        System.out.println(feet + " feet is equal to " + yards + " yards and " + miles + " miles.");
        scanner.close();
        }
}

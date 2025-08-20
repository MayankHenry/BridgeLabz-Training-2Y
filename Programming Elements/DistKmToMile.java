
import java.util.Scanner;

public class DistKmToMile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter distance in kilometers: ");
        double kilometers = scanner.nextDouble();
        double miles = kilometers / 1.60934;
        System.out.println(kilometers + " kilometers is equal to " + miles + " miles.");
        scanner.close();

    }
}

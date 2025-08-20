import java.util.Scanner;

public class CmToFeetInches {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter height in centimeters: ");
        double centimeters = scanner.nextDouble();
        double totalInches = centimeters / 2.54;
        int feet = (int) (totalInches / 12);
        int inches = (int) (totalInches % 12);
        
        System.out.println(centimeters + " centimeters is equal to " + feet + " feet and " + inches + " inches.");
        scanner.close();
    }
}

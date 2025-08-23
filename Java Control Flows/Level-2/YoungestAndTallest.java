
import java.util.Scanner;

public class YoungestAndTallest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Amar's Age:- ");
        int amarAge = scanner.nextInt();
        System.out.println("Enter Akbar's Age:- ");
        int akbarAge = scanner.nextInt();
        System.out.println("Enter Anthony's Age:- ");
        int anthonyAge = scanner.nextInt();
        System.out.println("Enter Amar's Height in cm:- ");
        int amarHeight = scanner.nextInt();
        System.out.println("Enter Akbar's Height in cm:- ");
        int akbarHeight = scanner.nextInt();
        System.out.println("Enter Anthony's Height in cm:- ");
        int anthonyHeight = scanner.nextInt();
        String youngest = "";
        String tallest = "";
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Youngest is Amar");
        } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Youngest is Akbar");
        } else if (anthonyAge < amarAge && anthonyAge < akbarAge) {
            System.out.println("Youngest is Anthony");
        } else {
            System.out.println("There is a tie for the youngest age.");
        }
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Tallest is Amar");
        } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Tallest is Akbar");
        } else if (anthonyHeight > amarHeight && anthonyHeight > akbarHeight) {
            System.out.println("Tallest is Anthony");
        } else {
            System.out.println("There is a tie for the tallest height.");
        }
    }
}

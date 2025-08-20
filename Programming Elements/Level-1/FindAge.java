
import java.util.Scanner;

public class FindAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Your Name: ");
        String name = scanner.nextLine();
        System.out.println("Enter Your Birth Year: ");
        int birthYear = scanner.nextInt();
        int age = 2024 - birthYear;
        System.out.println("Harry's age in 2024 is " + age );

    }
}

import java.util.Scanner;

public class SpringSeason {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the month (1-12): ");
        int month = scanner.nextInt();
        System.out.print("Enter the day (1-31): ");
        int day = scanner.nextInt();
        boolean isSpring = false;
        if (month == 3 && day >= 20 || month == 4 || month == 5 || month == 6 && day < 21) {
            isSpring = true;
        }
        if (isSpring) {
            System.out.println("The date " + month + "/" + day + " is in the Spring season.");
        } else {
            System.out.println("The date " + month + "/" + day + " is not in the Spring season.");
        }
    }
}

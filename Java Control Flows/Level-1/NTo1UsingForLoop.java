
import java.util.Scanner;

public class NTo1UsingForLoop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            System.out.println("Counting down from " + n + " to 1:");
            for (int i = n; i >= 1; i--) {
                System.out.println(i);
            }
        }
        scanner.close();
    }
}

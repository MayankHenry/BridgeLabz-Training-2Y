import java.util.Scanner;

public class MaximumHandshakeOfNstudents {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int n = scanner.nextInt();
        int maxHandshakes = n * (n - 1) / 2;
        System.out.println("The maximum number of handshakes possible is: " + maxHandshakes);
        scanner.close();

    }
}

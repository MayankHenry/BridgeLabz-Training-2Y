import java.util.Scanner;

public class NTo1CountUsingWhile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        if (n < 1) {
            System.out.println("Please enter a natural number greater than 0.");
        } else {
            int count = n;
            System.out.println("Counting down from " + n + " to 1:");
            while (count >= 1) {
                System.out.println(count);
                count--;
            }
        }
        scanner.close();
    }
}

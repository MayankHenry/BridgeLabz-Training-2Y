
import java.util.Scanner;

public class BridgeLabQ9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number 1: ");
        int a = sc.nextInt();
        System.out.println("Enter Number 2: ");
        int b = sc.nextInt();
        System.out.println("Enter Number 3: ");
        int c = sc.nextInt();
        int average = (a + b + c) / 3;
        System.out.println("Average: " + average);
        sc.close();

    }
}

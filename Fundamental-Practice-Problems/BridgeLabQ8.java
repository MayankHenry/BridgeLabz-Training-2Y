
import java.util.Scanner;

public class BridgeLabQ8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        int n = sc.nextInt();
        System.out.print("Enter exponent: ");
        int p = sc.nextInt();
        int result = 1;
        for (int i = 0; i < p; i++) {
            result *= n;
        }
        System.out.println("Result: " + result);
        sc.close();

    }
}

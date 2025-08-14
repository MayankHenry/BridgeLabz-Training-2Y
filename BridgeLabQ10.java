
import java.util.Scanner;

public class BridgeLabQ10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Kilometers: ");
        float km = sc.nextFloat();
        float miles = km * 0.621371f;
        System.out.println("Miles: " + miles);
        sc.close();
    }
}

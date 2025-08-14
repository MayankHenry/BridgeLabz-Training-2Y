
import java.util.Scanner;

public class BridgeLabQ5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the cylinder: ");
        float r = sc.nextFloat();
        System.out.print("Enter height of the cylinder: ");
        float h = sc.nextFloat();
        double volume = Math.PI * r * r * h;
        System.out.println("Volume of the cylinder: " + volume);
        sc.close();

}
}
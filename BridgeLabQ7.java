
import java.util.Scanner;

public class BridgeLabQ7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Length of the rectangle: ");
        float length = sc.nextFloat();
        System.out.print("Enter Width of the rectangle: ");
        float width = sc.nextFloat();
        float area = length * width;
        System.out.println("Area of the rectangle: " + area);
        sc.close();
}
}
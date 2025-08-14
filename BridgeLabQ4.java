import java.util.Scanner;

public class BridgeLabQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter radius of the circle: ");
        float r = sc.nextFloat();
        double area = Math.PI * r * r;
        System.out.println("Area of the circle: " + area);
        sc.close();
}
}

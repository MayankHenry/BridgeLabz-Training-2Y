import java.util.Scanner;

public class Volume {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Earth's Radius: ");
        double radius = sc.nextDouble();
        double volume = (4.0/3) * Math.PI * Math.pow(radius, 3);
        double volumeMiles = volume * 0.239913;
        sc.close();
        System.out.println("Volume of the Earth in cubic kilometer is " + volume + " and cubic miles is " + volumeMiles + ".");
    }
}

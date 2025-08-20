public class AreaOfTriangle {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.print("Enter the base of the triangle: ");
        double base = scanner.nextDouble();
        System.out.print("Enter the height of the triangle: ");
        double height = scanner.nextDouble();
        
        double area = 0.5 * base * height;
        
        System.out.println("The area of the triangle is: " + area);
        scanner.close();
    }
}

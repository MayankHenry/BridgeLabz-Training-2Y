public class GeometryCalculator {

    public static void main(String[] args) {
        double x1 = 3, y1 = 4;
        double x2 = 7, y2 = 7;
        
        System.out.println("Points are (" + x1 + "," + y1 + ") and (" + x2 + "," + y2 + ")");

        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.printf("Euclidean Distance: %.2f\n", distance);

        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;

        System.out.printf("Equation of the line: y = %.2fx + %.2f\n", slope, yIntercept);
    }
}
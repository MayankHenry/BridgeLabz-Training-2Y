public class CollinearPointsChecker {

    public static void main(String[] args) {
        int x1 = 2, y1 = 4;
        int x2 = 4, y2 = 6;
        int x3 = 6, y3 = 8;
        
        System.out.println("Checking points: ("+x1+","+y1+"), ("+x2+","+y2+"), ("+x3+","+y3+")");

        boolean isCollinearBySlope = checkSlope(x1, y1, x2, y2, x3, y3);
        System.out.println("Are points collinear (by slope)? " + isCollinearBySlope);

        boolean isCollinearByArea = checkArea(x1, y1, x2, y2, x3, y3);
        System.out.println("Are points collinear (by area)? " + isCollinearByArea);
    }

    public static boolean checkSlope(int x1, int y1, int x2, int y2, int x3, int y3) {
        return (y2 - y1) * (x3 - x2) == (y3 - y2) * (x2 - x1);
    }

    public static boolean checkArea(int x1, int y1, int x2, int y2, int x3, int y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return area == 0;
    }
}
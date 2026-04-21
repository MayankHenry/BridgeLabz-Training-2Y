import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;

public class CircularTourProblem {

    public static int findStartingPump(int[] petrol, int[] distance) {
        int n = petrol.length;
        int totalSurplus = 0;
        int currentSurplus = 0;
        int startIndex = 0;

        for (int i = 0; i < n; i++) {
            int diff = petrol[i] - distance[i];
            totalSurplus += diff;
            currentSurplus += diff;

            if (currentSurplus < 0) {
                startIndex = i + 1;
                currentSurplus = 0;
            }
        }

        if (totalSurplus < 0) {
            return -1;
        }
        return startIndex;
    }

    public static void simulateTour(int[] petrol, int[] distance, int start) {
        int n = petrol.length;
        Queue<String> visitOrder = new LinkedList<>();
        int fuel = 0;

        System.out.println("\nSimulating tour starting from pump " + start + ":");
        for (int i = 0; i < n; i++) {
            int current = (start + i) % n;
            fuel += petrol[current];
            String step = "Pump " + current + " -> fuel: " + fuel + " -> travel cost: " + distance[current] + " -> remaining: " + (fuel - distance[current]);
            visitOrder.add(step);
            fuel -= distance[current];
        }

        while (!visitOrder.isEmpty()) {
            System.out.println(visitOrder.poll());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Circular Tour Problem ===");
        System.out.print("Enter number of petrol pumps: ");
        int n = sc.nextInt();

        int[] petrol = new int[n];
        int[] distance = new int[n];

        System.out.println("Enter petrol available at each pump:");
        for (int i = 0; i < n; i++) {
            petrol[i] = sc.nextInt();
        }

        System.out.println("Enter distance to next pump from each pump:");
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }

        int startPump = findStartingPump(petrol, distance);

        if (startPump == -1) {
            System.out.println("\nNo valid starting point exists to complete the tour.");
        } else {
            System.out.println("\nStarting pump to complete the circular tour: " + startPump);
            simulateTour(petrol, distance, startPump);
        }

        sc.close();
    }
}

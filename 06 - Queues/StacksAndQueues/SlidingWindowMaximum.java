import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class SlidingWindowMaximum {

    public static int[] findMaxInWindows(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Sliding Window Maximum ===");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter window size (k): ");
        int k = sc.nextInt();

        if (k > n || k <= 0) {
            System.out.println("Invalid window size");
            sc.close();
            return;
        }

        int[] maxValues = findMaxInWindows(arr, k);

        System.out.println("\nWindow\t\t\tMax");
        System.out.println("------\t\t\t---");
        for (int i = 0; i < maxValues.length; i++) {
            System.out.print("[");
            for (int j = i; j < i + k; j++) {
                System.out.print(arr[j]);
                if (j < i + k - 1) System.out.print(", ");
            }
            System.out.println("]\t\t" + maxValues[i]);
        }

        sc.close();
    }
}

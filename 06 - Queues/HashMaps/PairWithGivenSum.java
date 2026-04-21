import java.util.HashSet;
import java.util.Scanner;

public class PairWithGivenSum {

    public static boolean findPair(int[] arr, int targetSum) {
        HashSet<Integer> visited = new HashSet<>();

        for (int num : arr) {
            int complement = targetSum - num;

            if (visited.contains(complement)) {
                System.out.println("Pair found: (" + complement + ", " + num + ")");
                return true;
            }
            visited.add(num);
        }

        return false;
    }

    public static void findAllPairs(int[] arr, int targetSum) {
        HashSet<Integer> visited = new HashSet<>();
        HashSet<String> printedPairs = new HashSet<>();
        boolean found = false;

        for (int num : arr) {
            int complement = targetSum - num;

            if (visited.contains(complement)) {
                int smaller = Math.min(num, complement);
                int larger = Math.max(num, complement);
                String pairKey = smaller + "," + larger;

                if (!printedPairs.contains(pairKey)) {
                    System.out.println("Pair: (" + smaller + ", " + larger + ")");
                    printedPairs.add(pairKey);
                    found = true;
                }
            }
            visited.add(num);
        }

        if (!found) {
            System.out.println("No pairs found with the given sum.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Check for Pair with Given Sum ===");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        System.out.println("\nAll pairs with sum " + target + ":");
        findAllPairs(arr, target);

        sc.close();
    }
}

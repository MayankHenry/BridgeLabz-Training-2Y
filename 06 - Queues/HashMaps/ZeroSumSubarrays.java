import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeroSumSubarrays {

    public static List<int[]> findAllZeroSumSubarrays(int[] arr) {
        List<int[]> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> sumIndexMap = new HashMap<>();

        int cumulativeSum = 0;
        List<Integer> initialList = new ArrayList<>();
        initialList.add(-1);
        sumIndexMap.put(0, initialList);

        for (int i = 0; i < arr.length; i++) {
            cumulativeSum += arr[i];

            if (sumIndexMap.containsKey(cumulativeSum)) {
                List<Integer> indices = sumIndexMap.get(cumulativeSum);
                for (int startIdx : indices) {
                    result.add(new int[]{startIdx + 1, i});
                }
            }

            sumIndexMap.computeIfAbsent(cumulativeSum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Find All Subarrays with Zero Sum ===");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<int[]> subarrays = findAllZeroSumSubarrays(arr);

        if (subarrays.isEmpty()) {
            System.out.println("\nNo zero-sum subarrays found.");
        } else {
            System.out.println("\nZero-sum subarrays found:");
            for (int[] pair : subarrays) {
                System.out.print("Indices [" + pair[0] + " to " + pair[1] + "] -> {");
                for (int i = pair[0]; i <= pair[1]; i++) {
                    System.out.print(arr[i]);
                    if (i < pair[1]) System.out.print(", ");
                }
                System.out.println("}");
            }
            System.out.println("Total: " + subarrays.size() + " subarray(s)");
        }

        sc.close();
    }
}

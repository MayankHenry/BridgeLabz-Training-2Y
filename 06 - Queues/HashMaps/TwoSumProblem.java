import java.util.HashMap;
import java.util.Scanner;

public class TwoSumProblem {

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int needed = target - nums[i];

            if (indexMap.containsKey(needed)) {
                return new int[]{indexMap.get(needed), i};
            }

            indexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Two Sum Problem ===");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.print("Enter target sum: ");
        int target = sc.nextInt();

        int[] result = twoSum(nums, target);

        if (result[0] == -1) {
            System.out.println("\nNo two elements add up to " + target);
        } else {
            System.out.println("\nIndices: [" + result[0] + ", " + result[1] + "]");
            System.out.println("Values: " + nums[result[0]] + " + " + nums[result[1]] + " = " + target);
        }

        sc.close();
    }
}

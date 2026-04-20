import java.util.HashSet;
import java.util.Scanner;

public class LongestConsecutiveSequence {

    public static int findLongestConsecutive(int[] arr) {
        if (arr.length == 0) return 0;

        HashSet<Integer> numSet = new HashSet<>();
        for (int num : arr) {
            numSet.add(num);
        }

        int longestStreak = 0;
        int bestStart = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    bestStart = num;
                }
            }
        }

        System.out.print("Longest consecutive sequence: ");
        for (int i = 0; i < longestStreak; i++) {
            System.out.print(bestStart + i);
            if (i < longestStreak - 1) System.out.print(" -> ");
        }
        System.out.println();

        return longestStreak;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Longest Consecutive Sequence ===");
        System.out.print("Enter array size: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int length = findLongestConsecutive(arr);
        System.out.println("Length: " + length);

        sc.close();
    }
}

import java.util.Set;

public class Problem2_TimeComplexityAnalysis {

    public static boolean algorithmA_LinearSearch(String[] userList, String targetUsername) {
        for (int i = 0; i < userList.length; i++) {
            if (userList[i].equals(targetUsername)) {
                return true;
            }
        }
        return false;
    }

    public static boolean algorithmB_BinarySearch(String[] sortedUserList, String targetUsername) {
        int left = 0, right = sortedUserList.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int comparison = sortedUserList[mid].compareTo(targetUsername);
            if (comparison == 0) {
                return true;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static boolean algorithmC_HashTableLookup(Set<String> hashTable, String targetUsername) {
        return hashTable.contains(targetUsername);
    }

    public static void questionA() {
        System.out.println("\nQUESTION A: Operations (n = 10,000,000)\n");
        
        long n = 10_000_000;
        int binaryOps = (int) (Math.log(n) / Math.log(2)) + 1;
        
        System.out.println("Algorithm A - Linear: " + String.format("%,d", n) + " comparisons");
        System.out.println("Algorithm B - Binary: " + binaryOps + " comparisons");
        System.out.println("Algorithm C - Hash: 1 comparison\n");
    }

    public static void questionB() {
        System.out.println("\nQUESTION B: Time Complexity\n");
        System.out.println("Algorithm A - Linear Search: O(n)");
        System.out.println("Algorithm B - Binary Search: O(log n)");
        System.out.println("Algorithm C - Hash Table: O(1)\n");
    }

    public static void questionC() {
        System.out.println("\nQUESTION C: Operations Comparison\n");
        
        int[] sizes = {100, 1_000, 10_000, 100_000, 1_000_000, 10_000_000};
        System.out.println("n\t\tLinear\t\tBinary\t\tHash");
        System.out.println("----------------------------------------------------------");
        
        for (int n : sizes) {
            int logN = (int) (Math.log(n) / Math.log(2)) + 1;
            System.out.printf("%,d\t\t%,d\t\t%d\t\t1\n", n, n, logN);
        }
        System.out.println("\nLinear grows as n | Binary grows as log(n) | Hash stays at 1\n");
    }

    public static void questionD() {
        System.out.println("\nQUESTION D: Peak Load (50,000 checks/second)\n");
        
        int checksPerSecond = 50_000;
        long n = 10_000_000;
        int logN = (int) (Math.log(n) / Math.log(2)) + 1;
        
        double timeA = (checksPerSecond * n) / 1_000_000_000.0;
        double timeB = (checksPerSecond * logN) / 1_000_000.0;
        double timeC = (checksPerSecond) / 1_000.0;
        
        System.out.println("A-Linear: " + String.format("%.2f", timeA) + " sec/sec - NO");
        System.out.println("B-Binary: " + String.format("%.4f", timeB) + " ms/sec - YES");
        System.out.println("C-Hash: " + String.format("%.2f", timeC) + " µs/sec - YES (BEST)\n");
    }

    public static void questionE() {
        System.out.println("\n QUESTION E: Break-even Analysis (Sort then Binary Search)\n");
        
        long n = 10_000_000;
        int logN = (int) (Math.log(n) / Math.log(2)) + 1;
        
        System.out.println("Cost Analysis:\n");
        
        System.out.println("Approach 1 - Repeated Linear Search:");
        System.out.println("  Cost = k × n");
        System.out.println("  where k = number of searches\n");
        
        System.out.println("Approach 2 - Sort Once + Repeated Binary Search:");
        System.out.println("  Cost = n·log(n) + k·log(n)");
        System.out.println("  Cost = (n + k)·log(n)\n");
        
        System.out.println("Break-even Point:");
        System.out.println("  k·n = (n + k)·log(n)");
        System.out.println("  k·n = n·log(n) + k·log(n)");
        System.out.println("  k·n - k·log(n) = n·log(n)");
        System.out.println("  k·(n - log(n)) = n·log(n)");
        System.out.println("  k = n·log(n) / (n - log(n))\n");
        
        double breakEven = (n * logN) / (double)(n - logN);
        
        System.out.println("For n = 10,000,000:");
        System.out.printf("  k ≈ %.0f\n", breakEven);
        System.out.println("  (approximately " + (int)breakEven + " searches)\n");
        
        System.out.println("Practical Threshold:");
        System.out.println("  If k > 24: Use Binary Search (after sorting once)");
        System.out.println("  If k < 24: Use Linear Search (no sorting overhead)");
        System.out.println("  At k ≈ 24: Both approaches have similar cost\n");
        
        System.out.println("FORMULA:");
        System.out.println("  k_breakeven = n·log(n) / (n - log(n))");
        System.out.println("  For large n: k_breakeven ≈ log(n)\n");
    }

    public static void main(String[] args) {
        questionA();
        questionB();
        questionC();
        questionD();
        questionE();
    }
}

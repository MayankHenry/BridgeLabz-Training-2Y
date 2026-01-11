public class Problem4_AsymptoticNotationApplications {

    public static void questionA() {
        System.out.println("\nQUESTION A: Big-O Proofs\n");
        
        System.out.println("Big-O DEFINITION:");
        System.out.println("f(n) = O(g(n)) if there exist positive constants c and n₀");
        System.out.println("such that f(n) ≤ c·g(n) for all n ≥ n₀\n");
        
        System.out.println("ALGORITHM 1: Bubble Sort - Worst Case O(n²)\n");
        System.out.println("Bubble Sort pseudocode:");
        System.out.println("  for i = 0 to n-1:");
        System.out.println("    for j = 0 to n-i-2:");
        System.out.println("      if arr[j] > arr[j+1]:");
        System.out.println("        swap(arr[j], arr[j+1])\n");
        
        System.out.println("Analysis:");
        System.out.println("  Outer loop: n iterations");
        System.out.println("  Inner loop: (n-1) + (n-2) + ... + 1");
        System.out.println("  Total comparisons: Σ(i=1 to n-1) i = n(n-1)/2 = (n² - n)/2\n");
        
        System.out.println("Proof of O(n²):");
        System.out.println("  T(n) = (n² - n)/2");
        System.out.println("  We need: T(n) ≤ c·n² for some c and all large n");
        System.out.println("  (n² - n)/2 ≤ c·n²");
        System.out.println("  (1 - 1/n)/2 ≤ c");
        System.out.println("  Choose c = 1, n₀ = 2");
        System.out.println("  For n ≥ 2: (n² - n)/2 ≤ 1·n²");
        System.out.println("  Verification: (n² - n)/2 ≤ n² ✓ (always true)");
        System.out.println("  Therefore: Bubble Sort is O(n²)\n");
        
        System.out.println("ALGORITHM 2: Insertion Sort - Worst Case O(n²)\n");
        System.out.println("Insertion Sort pseudocode:");
        System.out.println("  for i = 1 to n-1:");
        System.out.println("    key = arr[i]");
        System.out.println("    j = i - 1");
        System.out.println("    while j ≥ 0 and arr[j] > key:");
        System.out.println("      arr[j+1] = arr[j]");
        System.out.println("      j = j - 1\n");
        
        System.out.println("Analysis:");
        System.out.println("  Outer loop: n iterations");
        System.out.println("  Inner while (worst case): 1 + 2 + 3 + ... + (n-1)");
        System.out.println("  Total comparisons: n(n-1)/2 = (n² - n)/2\n");
        
        System.out.println("Proof of O(n²):");
        System.out.println("  T(n) = (n² - n)/2");
        System.out.println("  Choose c = 1, n₀ = 2");
        System.out.println("  For n ≥ 2: (n² - n)/2 ≤ 1·n²");
        System.out.println("  Since n² - n < n² for all positive n");
        System.out.println("  (n² - n)/2 < n²/2 < n²");
        System.out.println("  Therefore: Insertion Sort is O(n²) ✓\n");
    }

    public static void questionB() {
        System.out.println("\nQUESTION B: Algorithm Selection by Data Type\n");
        
        System.out.println("TYPE A: Nearly Sorted Data (90% in order)\n");
        System.out.println("Best Algorithm: INSERTION SORT");
        System.out.println("Justification:");
        System.out.println("  - Best case: O(n) when nearly sorted");
        System.out.println("  - Data is mostly in order");
        System.out.println("  - Minimum comparisons needed");
        System.out.println("  - Adaptive algorithm (works well with partially sorted input)");
        System.out.println("  - Better than merge sort (always O(n log n))");
        System.out.println("  - Better than quick sort (might encounter bad pivot selection)\n");
        
        System.out.println("TYPE B: Completely Random Data\n");
        System.out.println("Best Algorithm: QUICK SORT (Average Case)");
        System.out.println("Justification:");
        System.out.println("  - Average case: O(n log n)");
        System.out.println("  - Random pivot selection works well");
        System.out.println("  - In-place sorting (space efficient)");
        System.out.println("  - Cache-friendly (good practical performance)");
        System.out.println("  - Beats merge sort in practice (no extra space)");
        System.out.println("  - Beats bubble/insertion sort (O(n²) worst case)\n");
        
        System.out.println("TYPE C: Reverse Sorted Data (Worst Possible)\n");
        System.out.println("Best Algorithm: MERGE SORT");
        System.out.println("Justification:");
        System.out.println("  - Guaranteed O(n log n) regardless of input");
        System.out.println("  - Reverse sorted is worst case for bubble/insertion (O(n²))");
        System.out.println("  - Quick sort worst case also O(n²) with bad pivot");
        System.out.println("  - Merge sort has no worst case");
        System.out.println("  - Predictable, stable performance\n");
    }

    public static void questionC() {
        System.out.println("\nQUESTION C: O(n log n) vs Θ(n log n)\n");
        
        System.out.println("NOTATION DEFINITIONS:\n");
        
        System.out.println("Big-O (Upper Bound):");
        System.out.println("  f(n) = O(g(n))");
        System.out.println("  Means: f(n) grows at most as fast as g(n)");
        System.out.println("  Provides upper bound on growth");
        System.out.println("  f(n) <= c*g(n) for some constant c\n");
        
        System.out.println("Theta (Tight Bound):");
        System.out.println("  f(n) = Theta(g(n))");
        System.out.println("  Means: f(n) grows exactly as fast as g(n)");
        System.out.println("  Provides both upper AND lower bounds");
        System.out.println("  c1*g(n) <= f(n) <= c2*g(n) for constants c1, c2\n");
        
        System.out.println("MERGE SORT: Θ(n log n)\n");
        System.out.println("  Best case: n log n");
        System.out.println("  Average case: n log n");
        System.out.println("  Worst case: n log n");
        System.out.println("  All cases are n log n → Tight bound = Θ(n log n)");
        System.out.println("  Cannot be expressed with weaker upper bound\n");
        
        System.out.println("QUICK SORT: O(n log n) for Average Case\n");
        System.out.println("  Best case: n log n");
        System.out.println("  Average case: n log n");
        System.out.println("  Worst case: n²");
        System.out.println("  Worst case is n² (not n log n)");
        System.out.println("  Cannot guarantee Θ(n log n) → Use O(n log n)");
        System.out.println("  O(n log n) means 'at most n log n' in average case\n");
        
        System.out.println("KEY DIFFERENCE:");
        System.out.println("  Merge Sort: Θ(n log n) - Always this complexity");
        System.out.println("  Quick Sort: O(n log n) - At most this complexity (average)");
        System.out.println("            Can be Ω(n²) in worst case");
        System.out.println("\n  Θ is more precise; O is more conservative\n");
    }

    public static void questionD() {
        System.out.println("\nQUESTION D: Algorithm Selection Decision Tree\n");
        
        System.out.println("DECISION TREE:\n");
        System.out.println("Is data sorted?");
        System.out.println("├─ YES (already sorted)");
        System.out.println("│  └─ Return (already done)");
        System.out.println("│\n");
        System.out.println("└─ NO - Check data size");
        System.out.println("   ├─ SMALL (n < 50)");
        System.out.println("   │  ├─ Nearly sorted? → INSERTION SORT [Best: O(n), Worst: O(n²)]");
        System.out.println("   │  ├─ Random data? → INSERTION SORT [Simple, lower constants]");
        System.out.println("   │  └─ Reverse sorted? → INSERTION SORT [Acceptable for small n]");
        System.out.println("   │\n");
        System.out.println("   ├─ MEDIUM (50 ≤ n < 10,000)");
        System.out.println("   │  ├─ Nearly sorted? → INSERTION SORT [O(n) best case]");
        System.out.println("   │  ├─ Random data? → QUICK SORT [Average O(n log n), in-place]");
        System.out.println("   │  └─ Reverse sorted? → MERGE SORT [Guaranteed O(n log n)]");
        System.out.println("   │\n");
        System.out.println("   └─ LARGE (n ≥ 10,000)");
        System.out.println("      ├─ Nearly sorted? → INSERTION SORT [Adaptive, efficient]");
        System.out.println("      ├─ Random data? → QUICK SORT [Average O(n log n), cache-friendly]");
        System.out.println("      └─ Reverse sorted? → MERGE SORT [Guaranteed O(n log n), stable]\n");
        
        System.out.println("JUSTIFICATION:\n");
        System.out.println("INSERTION SORT:");
        System.out.println("  - Small n: overhead negligible, code simplicity");
        System.out.println("  - Nearly sorted: Θ(n) best case is superior");
        System.out.println("  - Asymptotic analysis: O(n²) acceptable for n < 50\n");
        
        System.out.println("QUICK SORT:");
        System.out.println("  - Random data: Average O(n log n) performance");
        System.out.println("  - In-place: O(log n) space for recursion");
        System.out.println("  - Cache-locality: Practical performance better than merge sort");
        System.out.println("  - Medium/Large: Good balance of speed and space\n");
        
        System.out.println("MERGE SORT:");
        System.out.println("  - Reverse sorted: Worst case O(n²) unacceptable for other algorithms");
        System.out.println("  - Guaranteed: O(n log n) regardless of input");
        System.out.println("  - Stable: Preserves relative order of equal elements");
        System.out.println("  - Predictable: Important for real-time systems\n");
    }

    public static void questionE() {
        System.out.println("\nQUESTION E: Mystery Sort vs Merge Sort\n");
        
        System.out.println("Given:");
        System.out.println("  Mystery Sort: T(n) = 5n² + 100n + 1000");
        System.out.println("  Merge Sort: T(n) = 10n log₂(n)\n");
        
        System.out.println("Find: When is Mystery Sort faster?");
        System.out.println("  5n² + 100n + 1000 < 10n log₂(n)\n");
        
        System.out.println("MATHEMATICAL SOLUTION:\n");
        
        System.out.println("Testing values:");
        int[] testValues = {1, 5, 10, 20, 50, 100, 200, 500, 1000, 2000, 5000};
        
        System.out.println("n\t\tMystery Sort\tMerge Sort\tWinner");
        System.out.println("----------------------------------------------------------");
        
        for (int n : testValues) {
            long mysteryCost = 5L * n * n + 100 * n + 1000;
            double logN = Math.log(n) / Math.log(2);
            long mergeCost = (long) (10 * n * logN);
            String winner = mysteryCost < mergeCost ? "Mystery" : "Merge";
            
            System.out.printf("%d\t\t%,d\t\t%,d\t\t%s\n", n, mysteryCost, mergeCost, winner);
        }
        
        System.out.println("\nObservation: Merge Sort is consistently faster for all n > 1");
        System.out.println("Example at n = 1,000,000: Merge is ~25,000 times faster\n");
    }

    public static void main(String[] args) {
        questionA();
        questionB();
        questionC();
        questionD();
        questionE();
    }
}

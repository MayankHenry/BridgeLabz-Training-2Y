import java.util.HashSet;
import java.util.Set;

public class Problem3_SpaceComplexityAndTradeoffs {

    public static boolean implementationA(int[] completedCourses, int[] prerequisites) {
        for (int i = 0; i < prerequisites.length; i++) {
            boolean found = false;
            for (int j = 0; j < completedCourses.length; j++) {
                if (prerequisites[i] == completedCourses[j]) {
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return true;
    }

    public static boolean implementationB(int[] completedCourses, int[] prerequisites) {
        Set<Integer> completedSet = new HashSet<>();
        for (int i = 0; i < completedCourses.length; i++) {
            completedSet.add(completedCourses[i]);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            if (!completedSet.contains(prerequisites[i])) {
                return false;
            }
        }
        return true;
    }

    public static void questionA() {
        System.out.println("\nQUESTION A: Time Complexity\n");
        
        System.out.println("Implementation A - Nested Loop:");
        System.out.println("  Structure:");
        System.out.println("    for i = 0 to m-1:");
        System.out.println("      for j = 0 to n-1:");
        System.out.println("        comparison");
        System.out.println("\n  Analysis:");
        System.out.println("    - Outer loop: m iterations");
        System.out.println("    - Inner loop: n iterations (worst case)");
        System.out.println("    - Comparisons per outer iteration: n (without early break)");
        System.out.println("    - Total comparisons: m × n");
        System.out.println("    - Time Complexity: O(m × n)\n");
        
        System.out.println("Implementation B - Hash Set:");
        System.out.println("  Structure:");
        System.out.println("    1. Create HashSet: for i = 0 to n-1: add()");
        System.out.println("    2. Check prerequisites: for i = 0 to m-1: contains()");
        System.out.println("\n  Analysis:");
        System.out.println("    - Building hash set: O(n) - n add operations");
        System.out.println("    - Each add operation: O(1) average");
        System.out.println("    - Checking prerequisites: O(m) - m contains operations");
        System.out.println("    - Each contains: O(1) average");
        System.out.println("    - Total: O(n) + O(m) = O(n + m)");
        System.out.println("    - Time Complexity: O(n + m)\n");
    }

    public static void questionB() {
        System.out.println("\nQUESTION B: Space Complexity\n");
        
        System.out.println("Implementation A - Nested Loop:");
        System.out.println("  Variables used:");
        System.out.println("    - i: 1 variable (integer)");
        System.out.println("    - j: 1 variable (integer)");
        System.out.println("    - found: 1 variable (boolean)");
        System.out.println("    - Input arrays: not counted (given)");
        System.out.println("  Auxiliary Space: O(1)");
        System.out.println("  No additional data structures created\n");
        
        System.out.println("Implementation B - Hash Set:");
        System.out.println("  Variables used:");
        System.out.println("    - i: 1 variable (integer)");
        System.out.println("    - completedSet: HashSet object");
        System.out.println("  Hash Set Storage:");
        System.out.println("    - Size: n elements");
        System.out.println("    - Space per element: 8 bytes (given)");
        System.out.println("    - Total: n × 8 bytes");
        System.out.println("    - Hash table overhead: approximately 8-16 bytes per entry");
        System.out.println("  Auxiliary Space: O(n)");
        System.out.println("  Creates HashSet of size n\n");
    }

    public static void questionC() {
        System.out.println("\nQUESTION C: Real-world Calculations\n");
        
        int n = 40;
        int m = 5;
        int studentsPerDay = 100_000;
        int bytesPerEntry = 8;
        
        System.out.println("Given Parameters:");
        System.out.println("  Completed courses (n): " + n);
        System.out.println("  Required prerequisites (m): " + m);
        System.out.println("  Students per day: " + String.format("%,d", studentsPerDay) + "\n");
        
        System.out.println("IMPLEMENTATION A - Total Comparisons Per Day:");
        long comparisonsA = (long) m * n * studentsPerDay;
        System.out.println("  Formula: m × n × students_per_day");
        System.out.println("  Calculation: " + m + " × " + n + " × " + String.format("%,d", studentsPerDay));
        System.out.println("  Total comparisons: " + String.format("%,d", comparisonsA) + "\n");
        
        System.out.println("IMPLEMENTATION B - Memory Usage Per Day:");
        System.out.println("  Per student HashSet:");
        System.out.println("    Elements: " + n);
        System.out.println("    Space per element: " + bytesPerEntry + " bytes");
        System.out.println("    Subtotal: " + n + " × " + bytesPerEntry + " = " + (n * bytesPerEntry) + " bytes");
        System.out.println("    Hash overhead: ~100-200 bytes (estimate)");
        System.out.println("    Per HashSet total: ~" + (n * bytesPerEntry + 150) + " bytes\n");
        
        long bytesPerStudent = n * bytesPerEntry + 150;
        long totalMemoryB = bytesPerStudent * studentsPerDay;
        double gbMemoryB = totalMemoryB / (1024.0 * 1024.0 * 1024.0);
        
        System.out.println("  Total for all students:");
        System.out.println("    Calculation: " + bytesPerStudent + " bytes × " + String.format("%,d", studentsPerDay));
        System.out.println("    Total memory: " + String.format("%,d", totalMemoryB) + " bytes");
        System.out.println("    In GB: " + String.format("%.2f", gbMemoryB) + " GB\n");
    }

    public static void questionD() {
        System.out.println("\nQUESTION D: Infrastructure Constraints\n");
        
        System.out.println("Constraints:");
        System.out.println("  (i) Response time: must be < 10ms per check");
        System.out.println("  (ii) Memory: must be < 1GB for 10,000 concurrent requests");
        System.out.println("  Concurrent requests: 10,000");
        System.out.println("  Comparison time: 0.1 microseconds\n");
        
        int n = 40;
        int m = 5;
        int concurrentRequests = 10_000;
        double comparisonTimeUs = 0.1;
        int bytesPerEntry = 8;
        long maxMemory = 1_000_000_000;
        
        System.out.println("IMPLEMENTATION A - Nested Loop:");
        System.out.println("  Worst case comparisons: m × n = " + m + " × " + n + " = " + (m * n));
        double timeAUs = (m * n) * comparisonTimeUs;
        double timeAMs = timeAUs / 1000;
        System.out.println("  Time per check: " + (m * n) + " × 0.1µs = " + String.format("%.2f", timeAMs) + " ms");
        System.out.println("  Check: " + String.format("%.2f", timeAMs) + " ms < 10 ms? YES ✓");
        System.out.println("  Memory for " + concurrentRequests + " requests: O(1) - negligible");
        System.out.println("  Constraint (i): SATISFIED ✓");
        System.out.println("  Constraint (ii): SATISFIED ✓\n");
        
        System.out.println("IMPLEMENTATION B - Hash Set:");
        System.out.println("  Worst case comparisons: n + m = " + n + " + " + m + " = " + (n + m));
        double timeBUs = (n + m) * comparisonTimeUs;
        double timeBMs = timeBUs / 1000;
        System.out.println("  Time per check: " + (n + m) + " × 0.1µs = " + String.format("%.2f", timeBMs) + " ms");
        System.out.println("  Check: " + String.format("%.2f", timeBMs) + " ms < 10 ms? YES");
        
        long perStudentMemory = n * bytesPerEntry + 150;
        long totalMemoryB = perStudentMemory * concurrentRequests;
        System.out.println("  Memory per request: " + perStudentMemory + " bytes");
        System.out.println("  Total for " + concurrentRequests + " concurrent: " + String.format("%,d", totalMemoryB) + " bytes");
        double gbMemoryB = totalMemoryB / (1024.0 * 1024.0 * 1024.0);
        System.out.println("  In GB: " + String.format("%.3f", gbMemoryB) + " GB");
        System.out.println("  Check: " + String.format("%.3f", gbMemoryB) + " GB < 1 GB? YES");
        System.out.println("  Constraint (i): SATISFIED");
        System.out.println("  Constraint (ii): SATISFIED\n");
        
        System.out.println("RECOMMENDATION:");
        System.out.println("  Both implementations satisfy the constraints");
        System.out.println("  Implementation B is PREFERRED because:");
        System.out.println("    - Faster response time: " + String.format("%.2f", timeBMs) + " ms vs " + String.format("%.2f", timeAMs) + " ms");
        System.out.println("    - Better scalability: O(n+m) vs O(n×m)");
        System.out.println("    - More predictable performance");
        System.out.println("    - Memory usage still acceptable\n");
    }

    public static void questionE() {
        System.out.println("\nQUESTION E: Hybrid Approach\n");
        
        System.out.println("Strategy Analysis:\n");
        
        System.out.println("When m is SMALL (1-2 prerequisites):");
        System.out.println("  - Hash set overhead: O(n) space");
        System.out.println("  - Implementation A: O(n × m) time");
        System.out.println("  - For n=40, m=1-2: only 40-80 comparisons");
        System.out.println("  - Space wasted on HashSet for few checks");
        System.out.println("  Recommendation: Use Implementation A (Nested Loop)\n");
        
        System.out.println("When m is LARGE (20+ prerequisites):");
        System.out.println("  - Implementation A: O(n × m) = O(40 × 20) = 800 comparisons");
        System.out.println("  - Implementation B: O(n + m) = O(40 + 20) = 60 operations");
        System.out.println("  - Significant performance gain with HashSet");
        System.out.println("  - Space usage still reasonable");
        System.out.println("  Recommendation: Use Implementation B (Hash Set)\n");
        
        System.out.println("Threshold Calculation:");
        System.out.println("  Break-even when: m × n ≈ n + m");
        System.out.println("  For n = 40:");
        System.out.println("    40m ≈ 40 + m");
        System.out.println("    39m ≈ 40");
        System.out.println("    m ≈ 1.03\n");
        
        System.out.println("Practical Threshold:");
        System.out.println("  For n = 40:");
        System.out.println("    m < 5: Use Implementation A");
        System.out.println("    m ≥ 5: Use Implementation B\n");
        
        System.out.println("General Formula:");
        System.out.println("  Threshold m_threshold ≈ n / (n - 1)");
        System.out.println("  For large n: m_threshold ≈ 1 + 1/n\n");
        
        System.out.println("HYBRID APPROACH:");
        System.out.println("  if (m < 5) {");
        System.out.println("    return implementationA(completed, prerequisites);");
        System.out.println("  } else {");
        System.out.println("    return implementationB(completed, prerequisites);");
        System.out.println("  }\n");
    }

    public static void main(String[] args) {
        questionA();
        questionB();
        questionC();
        questionD();
        questionE();
    }
}

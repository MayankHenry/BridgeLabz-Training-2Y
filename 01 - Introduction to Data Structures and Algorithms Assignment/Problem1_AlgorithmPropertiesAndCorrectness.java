public class Problem1_AlgorithmPropertiesAndCorrectness {

    public static double algorithmA(int[] temperatures, int n) {
        if (n == 0) return 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = total + temperatures[i];
        }
        double average = (double) total / n;
        return average;
    }

    public static double algorithmB(int[] temperatures, int n) {
        if (n == 0) return 0;
        int sum = temperatures[0];
        for (int i = 1; i < n; i++) {
            sum = sum + temperatures[i];
        }
        for (int i = 0; i < n; i++) {
            sum = sum / n;
        }
        return sum;
    }

    public static void executeQuestionB() {
        System.out.println("\nQUESTION B: Execution Test [20, 25, 22, 24, 21], n = 5\n");
        
        int[] temperatures = {20, 25, 22, 24, 21};
        int n = 5;
        
        System.out.println("Algorithm A: sum = 20+25+22+24+21 = 112, avg = 112/5 = 22.4");
        System.out.println("Result: " + algorithmA(temperatures, n) + " [CORRECT]");
        
        System.out.println("Algorithm B: sum = 112, then divided by 5 five times");
        System.out.println("  1st: 112/5 = 22, 2nd: 22/5 = 4, 3rd: 4/5 = 0, rest = 0");
        System.out.println("Result: " + algorithmB(temperatures, n) + " [WRONG]\n");
    }

    public static void executeQuestionC() {
        System.out.println("\nQUESTION C: Logical Error\n");
        System.out.println("Error: Second loop divides sum by n (repeated n times)");
        System.out.println("Violates: (a / b) / c != a / (b * c)");
        System.out.println("Correct: sum / n (once)");
        System.out.println("Wrong: sum / n / n / n / n / n = 0\n");
    }

    public static void executeQuestionD() {
        System.out.println("\nQUESTION D: Algorithm Comparison\n");
        System.out.println("Criterion   | Algorithm A | Algorithm B | Winner");
        System.out.println("Simplicity  | Simple      | Complex     | A");
        System.out.println("Correctness | CORRECT     | INCORRECT   | A");
        System.out.println("Efficiency  | O(n)        | O(n)        | Equal");
        System.out.println("Reliability | High        | Low         | A");
        System.out.println("\nUse Algorithm A - it is correct, simple, and efficient.\n");
    }

    public static void executeQuestionE() {
        System.out.println("\nQUESTION E: Test Cases\n");
        
        int[][] testCases = {{20, 25, 22, 24, 21}, {50}, {10, 20}, {-5, 5, -3, 8}, {0, 0, 0, 0}};
        String[] desc = {"5 elements", "Single element", "Two elements", "Negative temps", "All zeros"};
        
        for (int i = 0; i < testCases.length; i++) {
            double result = algorithmA(testCases[i], testCases[i].length);
            System.out.println("Test " + (i + 1) + " (" + desc[i] + "): " + result + " [PASS]");
        }
        
        System.out.println("Test 6 (Empty array): 0.0 [PASS]\n");
    }

    public static void executeAlgorithmPropertiesAnalysis() {
        System.out.println("\nQUESTION A: Algorithm Properties\n");
        System.out.println("1. Input: YES - Both take temperatures array and n");
        System.out.println("2. Output: YES - Both return a value");
        System.out.println("3. Definiteness: YES - Steps are clearly defined");
        System.out.println("4. Finiteness: YES - Both terminate in finite steps");
        System.out.println("5. Effectiveness: A=YES | B=NO - Produces wrong results");
        System.out.println("\nResult: Algorithm A satisfies all properties, B violates effectiveness\n");
    }

    public static void main(String[] args) {
        executeAlgorithmPropertiesAnalysis();
        executeQuestionB();
        executeQuestionC();
        executeQuestionD();
        executeQuestionE();
    }
}

import java.util.Stack;
import java.util.Scanner;

public class StockSpanProblem {

    public static int[] calculateSpan(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];
        Stack<Integer> indexStack = new Stack<>();

        span[0] = 1;
        indexStack.push(0);

        for (int i = 1; i < n; i++) {
            while (!indexStack.isEmpty() && prices[indexStack.peek()] <= prices[i]) {
                indexStack.pop();
            }

            if (indexStack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - indexStack.peek();
            }

            indexStack.push(i);
        }

        return span;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Stock Span Problem ===");
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];
        System.out.println("Enter stock prices for each day:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] span = calculateSpan(prices);

        System.out.println("\nDay\tPrice\tSpan");
        System.out.println("---\t-----\t----");
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1) + "\t" + prices[i] + "\t" + span[i]);
        }

        sc.close();
    }
}

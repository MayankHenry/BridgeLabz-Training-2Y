import java.util.Stack;
import java.util.Scanner;

public class SortStackRecursion {

    public static void sortStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        sortStack(stack);
        insertInSortedOrder(stack, top);
    }

    private static void insertInSortedOrder(Stack<Integer> stack, int element) {
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        int top = stack.pop();
        insertInSortedOrder(stack, element);
        stack.push(top);
    }

    public static void printStack(Stack<Integer> stack) {
        if (stack.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        Stack<Integer> temp = new Stack<>();
        while (!stack.isEmpty()) {
            int val = stack.pop();
            System.out.print(val + " ");
            temp.push(val);
        }
        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();

        System.out.println("=== Sort a Stack Using Recursion ===");
        System.out.print("How many elements do you want to push? ");
        int n = sc.nextInt();

        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int val = sc.nextInt();
            stack.push(val);
        }

        System.out.println("\nBefore sorting:");
        printStack(stack);

        sortStack(stack);

        System.out.println("\nAfter sorting (ascending from bottom to top):");
        printStack(stack);

        sc.close();
    }
}

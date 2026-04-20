import java.util.Stack;
import java.util.Scanner;

public class QueueUsingStacks {

    private Stack<Integer> enqueueStack;
    private Stack<Integer> dequeueStack;

    public QueueUsingStacks() {
        enqueueStack = new Stack<>();
        dequeueStack = new Stack<>();
    }

    public void enqueue(int value) {
        enqueueStack.push(value);
        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (dequeueStack.isEmpty() && enqueueStack.isEmpty()) {
            throw new RuntimeException("Queue is empty, nothing to dequeue");
        }
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.pop();
    }

    public int peek() {
        if (dequeueStack.isEmpty() && enqueueStack.isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        if (dequeueStack.isEmpty()) {
            while (!enqueueStack.isEmpty()) {
                dequeueStack.push(enqueueStack.pop());
            }
        }
        return dequeueStack.peek();
    }

    public boolean isEmpty() {
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public int size() {
        return enqueueStack.size() + dequeueStack.size();
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (int i = dequeueStack.size() - 1; i >= 0; i--) {
            System.out.print(dequeueStack.get(i) + " ");
        }
        for (int i = 0; i < enqueueStack.size(); i++) {
            System.out.print(enqueueStack.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        QueueUsingStacks queue = new QueueUsingStacks();

        System.out.println("=== Queue Using Two Stacks ===");
        System.out.println("1. Enqueue  2. Dequeue  3. Peek  4. Display  5. Exit");

        boolean running = true;
        while (running) {
            System.out.print("\nChoice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    queue.enqueue(val);
                    break;
                case 2:
                    try {
                        int removed = queue.dequeue();
                        System.out.println("Dequeued: " + removed);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Front element: " + queue.peek());
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}

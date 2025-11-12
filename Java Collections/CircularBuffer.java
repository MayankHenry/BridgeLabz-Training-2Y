import java.util.ArrayDeque;

class FixedSizeQueue<T> {
    private ArrayDeque<T> queue;
    private int maxSize;

    public FixedSizeQueue(int size) {
        this.maxSize = size;
        this.queue = new ArrayDeque<>(size);
    }

    public void add(T element) {
        if (queue.size() == maxSize) {
            queue.removeFirst();
        }
        queue.addLast(element);
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}

public class CircularBuffer {
    public static void main(String[] args) {
        FixedSizeQueue<Integer> buffer = new FixedSizeQueue<>(3);
        buffer.add(1);
        buffer.add(2);
        buffer.add(3);
        System.out.println("Buffer: " + buffer);
        
        buffer.add(4);
        System.out.println("Buffer after adding 4: " + buffer);
    }
}
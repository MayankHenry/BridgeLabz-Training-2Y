import java.util.Scanner;

public class CustomHashMap {

    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry[] buckets;
    private int size;
    private int capacity;

    static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public CustomHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new Entry[capacity];
        this.size = 0;
    }

    private int getBucketIndex(int key) {
        return Math.abs(key) % capacity;
    }

    public void put(int key, int value) {
        if ((float) size / capacity >= LOAD_FACTOR) {
            resize();
        }

        int index = getBucketIndex(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                current.value = value;
                System.out.println("Updated key " + key + " with value " + value);
                return;
            }
            current = current.next;
        }

        Entry newEntry = new Entry(key, value);
        newEntry.next = buckets[index];
        buckets[index] = newEntry;
        size++;
        System.out.println("Inserted (" + key + ", " + value + ")");
    }

    public int get(int key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];

        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    public boolean remove(int key) {
        int index = getBucketIndex(key);
        Entry current = buckets[index];
        Entry previous = null;

        while (current != null) {
            if (current.key == key) {
                if (previous == null) {
                    buckets[index] = current.next;
                } else {
                    previous.next = current.next;
                }
                size--;
                System.out.println("Removed key " + key);
                return true;
            }
            previous = current;
            current = current.next;
        }

        System.out.println("Key " + key + " not found");
        return false;
    }

    public boolean containsKey(int key) {
        return get(key) != -1;
    }

    private void resize() {
        int newCapacity = capacity * 2;
        Entry[] newBuckets = new Entry[newCapacity];
        int oldCapacity = capacity;
        capacity = newCapacity;

        for (int i = 0; i < oldCapacity; i++) {
            Entry current = buckets[i];
            while (current != null) {
                Entry next = current.next;
                int newIndex = getBucketIndex(current.key);
                current.next = newBuckets[newIndex];
                newBuckets[newIndex] = current;
                current = next;
            }
        }

        buckets = newBuckets;
        System.out.println("HashMap resized to capacity: " + newCapacity);
    }

    public void display() {
        System.out.println("\n--- HashMap Contents ---");
        boolean empty = true;
        for (int i = 0; i < capacity; i++) {
            if (buckets[i] != null) {
                empty = false;
                System.out.print("Bucket " + i + ": ");
                Entry current = buckets[i];
                while (current != null) {
                    System.out.print("(" + current.key + "=" + current.value + ")");
                    if (current.next != null) System.out.print(" -> ");
                    current = current.next;
                }
                System.out.println();
            }
        }
        if (empty) {
            System.out.println("HashMap is empty");
        }
        System.out.println("Size: " + size + ", Capacity: " + capacity);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomHashMap map = new CustomHashMap();

        System.out.println("=== Custom HashMap Implementation ===");
        System.out.println("1. Put  2. Get  3. Remove  4. Display  5. Exit");

        boolean running = true;
        while (running) {
            System.out.print("\nChoice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter key: ");
                    int key = sc.nextInt();
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
                    map.put(key, val);
                    break;
                case 2:
                    System.out.print("Enter key: ");
                    int searchKey = sc.nextInt();
                    int result = map.get(searchKey);
                    if (result == -1) {
                        System.out.println("Key not found");
                    } else {
                        System.out.println("Value: " + result);
                    }
                    break;
                case 3:
                    System.out.print("Enter key to remove: ");
                    int removeKey = sc.nextInt();
                    map.remove(removeKey);
                    break;
                case 4:
                    map.display();
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

class ItemNode {
    String name;
    int id;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManager {
    private ItemNode head;

    public void add(String name, int id, int quantity, double price, int position) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        if (position == 0 || head == null) {
            newNode.next = head;
            head = newNode;
            return;
        }
        ItemNode current = head;
        for (int i = 0; i < position - 1 && current.next != null; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void remove(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            return;
        }
        ItemNode current = head;
        while (current.next != null && current.next.id != id) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void updateQuantity(int id, int qty) {
        ItemNode item = search(id, null);
        if (item != null) item.quantity = qty;
    }

    public ItemNode search(int id, String name) {
        ItemNode current = head;
        while (current != null) {
            if ((name == null && current.id == id) || (name != null && current.name.equals(name))) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public double calculateTotalValue() {
        double total = 0;
        ItemNode current = head;
        while (current != null) {
            total += current.price * current.quantity;
            current = current.next;
        }
        return total;
    }

    public void sortByName() {
        if (head == null || head.next == null) return;
        head = mergeSort(head);
    }

    private ItemNode mergeSort(ItemNode h) {
        if (h == null || h.next == null) return h;
        ItemNode middle = getMiddle(h);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null;
        ItemNode left = mergeSort(h);
        ItemNode right = mergeSort(nextOfMiddle);
        return sortedMerge(left, right);
    }

    private ItemNode sortedMerge(ItemNode a, ItemNode b) {
        if (a == null) return b;
        if (b == null) return a;
        ItemNode result;
        if (a.name.compareTo(b.name) <= 0) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    private ItemNode getMiddle(ItemNode h) {
        if (h == null) return h;
        ItemNode slow = h, fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
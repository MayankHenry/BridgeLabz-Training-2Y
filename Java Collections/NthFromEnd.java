import java.util.LinkedList;

public class NthFromEnd {
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");
        
        int n = 2;

        String result = getNthFromEnd(list, n);
        System.out.println("List: " + list);
        System.out.println(n + "nd from end: " + result);
    }

    public static <T> T getNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n < 1) {
            return null;
        }

        java.util.ListIterator<T> fast = list.listIterator();
        java.util.ListIterator<T> slow = list.listIterator();

        for (int i = 0; i < n; i++) {
            if (fast.hasNext()) {
                fast.next();
            } else {
                return null;
            }
        }

        while (fast.hasNext()) {
            fast.next();
            slow.next();
        }

        return slow.next();
    }
}
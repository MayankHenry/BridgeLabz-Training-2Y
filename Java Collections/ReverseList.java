import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {

    public static <T> List<T> reverseList(List<T> original) {
        List<T> reversed = new ArrayList<>();
        for (int i = original.size() - 1; i >= 0; i--) {
            reversed.add(original.get(i));
        }
        return reversed;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("Original ArrayList: " + arrayList);
        System.out.println("Reversed ArrayList: " + reverseList(arrayList));

        List<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        System.out.println("\nOriginal LinkedList: " + linkedList);
        System.out.println("Reversed LinkedList: " + reverseList(linkedList));
    }
}
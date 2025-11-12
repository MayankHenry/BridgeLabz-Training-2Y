import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicatesOrdered {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(4);

        System.out.println("Original: " + list);

        LinkedHashSet<Integer> set = new LinkedHashSet<>(list);
        List<Integer> listWithoutDuplicates = new ArrayList<>(set);

        System.out.println("Cleaned:  " + listWithoutDuplicates);
    }
}
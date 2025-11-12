import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrequencyCount {
    public static void main(String[] args) {
        List<String> items = new ArrayList<>();
        items.add("apple");
        items.add("banana");
        items.add("apple");
        items.add("orange");

        Map<String, Integer> frequencies = new HashMap<>();
        for (String item : items) {
            frequencies.put(item, frequencies.getOrDefault(item, 0) + 1);
        }

        System.out.println("Input: " + items);
        System.out.println("Output: " + frequencies);
    }
}
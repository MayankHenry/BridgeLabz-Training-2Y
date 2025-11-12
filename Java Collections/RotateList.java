import java.util.ArrayList;
import java.util.List;

public class RotateList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        int k = 2;

        System.out.println("Original: " + list);
        
        List<Integer> rotated = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            rotated.add(null);
        }

        for (int i = 0; i < list.size(); i++) {
            int newIndex = (i - k + list.size()) % list.size();
            rotated.set(newIndex, list.get(i));
        }
        
        List<Integer> rotatedCorrect = new ArrayList<>();
        for(int i = k; i < list.size(); i++) {
            rotatedCorrect.add(list.get(i));
        }
        for(int i = 0; i < k; i++) {
            rotatedCorrect.add(list.get(i));
        }

        System.out.println("Rotated by " + k + ": " + rotatedCorrect);
    }
}
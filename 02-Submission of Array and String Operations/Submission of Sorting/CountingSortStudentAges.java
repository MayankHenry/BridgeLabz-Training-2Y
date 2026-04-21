public class CountingSortStudentAges {
    static void countingSort(int[] ages) {
        int min = ages[0];
        int max = ages[0];
        
        for (int age : ages) {
            if (age < min) {
                min = age;
            }
            if (age > max) {
                max = age;
            }
        }
        
        int range = max - min + 1;
        int[] count = new int[range];
        
        for (int age : ages) {
            count[age - min]++;
        }
        
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }
        
        int[] output = new int[ages.length];
        
        for (int i = ages.length - 1; i >= 0; i--) {
            int index = count[ages[i] - min] - 1;
            output[index] = ages[i];
            count[ages[i] - min]--;
        }
        
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }
    
    static void displayAges(int[] ages) {
        System.out.print("Ages: ");
        for (int age : ages) {
            System.out.print(age + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] ages = {15, 17, 14, 16, 18, 15, 14, 17, 16};
        
        System.out.println("Counting Sort - Student Ages");
        System.out.print("Before: ");
        displayAges(ages);
        
        countingSort(ages);
        
        System.out.print("After: ");
        displayAges(ages);
    }
}

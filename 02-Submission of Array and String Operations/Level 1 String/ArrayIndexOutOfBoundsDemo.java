import java.util.Scanner;

public class ArrayIndexOutOfBoundsDemo {
    static void generateArrayIndexOutOfBoundsException(String[] names) {
        System.out.println(names[names.length + 5]);
    }
    
    static void handleArrayIndexOutOfBoundsException(String[] names) {
        try {
            System.out.println(names[names.length + 5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException caught: Index out of array bounds");
        } catch (RuntimeException e) {
            System.out.println("RuntimeException caught: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter number of names: ");
        int n = sc.nextInt();
        String[] names = new String[n];
        
        System.out.println("Enter names:");
        for (int i = 0; i < n; i++) {
            System.out.print("Name " + (i + 1) + ": ");
            names[i] = sc.next();
        }
        
        System.out.println("Generating ArrayIndexOutOfBoundsException:");
        try {
            generateArrayIndexOutOfBoundsException(names);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exception generated: " + e.getClass().getName());
        }
        
        System.out.println("\nHandling ArrayIndexOutOfBoundsException:");
        handleArrayIndexOutOfBoundsException(names);
        
        sc.close();
    }
}

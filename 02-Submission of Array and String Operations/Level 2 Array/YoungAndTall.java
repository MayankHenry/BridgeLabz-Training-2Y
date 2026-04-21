import java.util.Scanner;

public class YoungAndTall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int[] ages = new int[3];
        double[] heights = new double[3];
        String[] names = {"Amar", "Akbar", "Anthony"};
        
        System.out.println("Enter age and height for 3 friends:");
        for (int i = 0; i < 3; i++) {
            System.out.print(names[i] + " age: ");
            ages[i] = sc.nextInt();
            
            System.out.print(names[i] + " height: ");
            heights[i] = sc.nextDouble();
        }
        
        int youngestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (ages[i] < ages[youngestIndex]) {
                youngestIndex = i;
            }
        }
        
        int tallestIndex = 0;
        for (int i = 1; i < 3; i++) {
            if (heights[i] > heights[tallestIndex]) {
                tallestIndex = i;
            }
        }
        
        System.out.println("\nYoungest: " + names[youngestIndex] + " with age " + ages[youngestIndex]);
        System.out.println("Tallest: " + names[tallestIndex] + " with height " + heights[tallestIndex]);
        
        sc.close();
    }
}

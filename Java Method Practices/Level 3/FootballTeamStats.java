import java.util.Random;
import java.util.Arrays;

public class FootballTeamStats {

    public static void main(String[] args) {
        int[] heights = new int[11];
        Random random = new Random();

        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + random.nextInt(101); // Range 150 to 250
        }

        System.out.println("Player heights (cm): " + Arrays.toString(heights));

        int sum = 0;
        int shortest = heights[0];
        int tallest = heights[0];

        for (int height : heights) {
            sum += height;
            if (height < shortest) {
                shortest = height;
            }
            if (height > tallest) {
                tallest = height;
            }
        }
        
        double mean = (double) sum / heights.length;

        System.out.println("Shortest player height: " + shortest + " cm");
        System.out.println("Tallest player height: " + tallest + " cm");
        System.out.printf("Mean team height: %.2f cm\n", mean);
    }
}
import java.util.Random;
import java.util.Arrays;

public class RandomNumberStats {
    
    public static int[] generate4DigitRandomArray(int size) {
        Random random = new Random();
        int[] numbers = new int[size];
        for(int i = 0; i < size; i++) {
            numbers[i] = 1000 + random.nextInt(9000);
        }
        return numbers;
    }

    public static void main(String[] args) {
        int[] randomNumbers = generate4DigitRandomArray(5);
        System.out.println("Generated numbers: " + Arrays.toString(randomNumbers));
        
        int min = randomNumbers[0];
        int max = randomNumbers[0];
        double sum = 0;

        for (int num : randomNumbers) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
            sum += num;
        }

        double average = sum / randomNumbers.length;

        System.out.println("Minimum value: " + min);
        System.out.println("Maximum value: " + max);
        System.out.println("Average value: " + average);
    }
}
import java.util.Scanner;

public class FrequencyUniqueChars {
    public static char[] findUnique(String text) {
        char[] temp = new char[text.length()];
        int index = 0;
        
        for (int i = 0; i < text.length(); i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (text.charAt(i) == text.charAt(j)) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                temp[index++] = text.charAt(i);
            }
        }
        
        char[] result = new char[index];
        for (int i = 0; i < index; i++) {
            result[i] = temp[i];
        }
        return result;
    }
    
    public static String[][] getFrequencyUnique(String text) {
        int[] freq = new int[256];
        
        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }
        
        char[] unique = findUnique(text);
        String[][] result = new String[unique.length][2];
        
        for (int i = 0; i < unique.length; i++) {
            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(freq[unique[i]]);
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        String[][] result = getFrequencyUnique(text);
        System.out.println("Character Frequency");
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i][0] + " : " + result[i][1]);
        }
    }
}

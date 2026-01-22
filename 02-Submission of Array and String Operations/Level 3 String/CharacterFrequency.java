import java.util.Scanner;

public class CharacterFrequency {
    static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    
    static String[][] findCharacterFrequency(String text) {
        int len = findLength(text);
        int[] frequency = new int[256];
        
        for (int i = 0; i < len; i++) {
            frequency[text.charAt(i)]++;
        }
        
        int count = 0;
        for (int i = 0; i < 256; i++) {
            if (frequency[i] > 0) {
                count++;
            }
        }
        
        String[][] result = new String[count][2];
        int index = 0;
        
        for (int i = 0; i < len; i++) {
            boolean alreadyAdded = false;
            for (int j = 0; j < index; j++) {
                if (result[j][0].equals(String.valueOf(text.charAt(i)))) {
                    alreadyAdded = true;
                    break;
                }
            }
            
            if (!alreadyAdded) {
                result[index][0] = String.valueOf(text.charAt(i));
                result[index][1] = String.valueOf(frequency[text.charAt(i)]);
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String[][] freq = findCharacterFrequency(text);
        
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + "\t\t" + freq[i][1]);
        }
        
        sc.close();
    }
}

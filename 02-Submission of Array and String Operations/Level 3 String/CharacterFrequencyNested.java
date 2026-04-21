import java.util.Scanner;

public class CharacterFrequencyNested {
    static String[][] findCharacterFrequencyNested(String text) {
        char[] chars = text.toCharArray();
        int len = chars.length;
        int[] frequency = new int[len];
        boolean[] counted = new boolean[len];
        
        for (int i = 0; i < len; i++) {
            if (!counted[i]) {
                int count = 1;
                frequency[i] = 1;
                
                for (int j = i + 1; j < len; j++) {
                    if (chars[i] == chars[j]) {
                        count++;
                        counted[j] = true;
                    }
                }
                
                frequency[i] = count;
            }
        }
        
        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            if (!counted[i]) {
                uniqueCount++;
            }
        }
        
        String[][] result = new String[uniqueCount][2];
        int index = 0;
        
        for (int i = 0; i < len; i++) {
            if (!counted[i]) {
                result[index][0] = String.valueOf(chars[i]);
                result[index][1] = String.valueOf(frequency[i]);
                counted[i] = true;
                index++;
            }
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter text: ");
        String text = sc.nextLine();
        
        String[][] freq = findCharacterFrequencyNested(text);
        
        System.out.println("Character\tFrequency");
        System.out.println("---------\t---------");
        
        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i][0] + "\t\t" + freq[i][1]);
        }
        
        sc.close();
    }
}

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountWordInFile {
    static int countWordInFile(String filename, String targetWord) {
        int count = 0;
        
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                
                for (String word : words) {
                    if (word.equalsIgnoreCase(targetWord)) {
                        count++;
                    }
                }
            }
            
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return count;
    }
    
    public static void main(String[] args) {
        String filename = "test.txt";
        String targetWord = "hello";
        
        int count = countWordInFile(filename, targetWord);
        
        System.out.println("Occurrences of '" + targetWord + "': " + count);
    }
}

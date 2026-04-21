import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class ChallengeStringAndFileIO {
    static void testStringBuilderStringBuffer() {
        System.out.println("=== Testing StringBuilder and StringBuffer ===");
        
        int iterations = 1000000;
        
        long startTime = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuffer.append("hello");
        }
        long stringBufferTime = System.nanoTime() - startTime;
        
        startTime = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append("hello");
        }
        long stringBuilderTime = System.nanoTime() - startTime;
        
        System.out.println("StringBuffer time: " + (stringBufferTime / 1000000.0) + " ms");
        System.out.println("StringBuilder time: " + (stringBuilderTime / 1000000.0) + " ms");
        System.out.println("StringBuilder is faster by: " + ((stringBufferTime - stringBuilderTime) / 1000000.0) + " ms");
    }
    
    static void testFileReaderAndInputStreamReader(String filename) {
        System.out.println("\n=== Testing FileReader and InputStreamReader ===");
        
        long fileReaderTime = readFileWithFileReader(filename);
        long inputStreamReaderTime = readFileWithInputStreamReader(filename);
        
        System.out.println("FileReader time: " + (fileReaderTime / 1000000.0) + " ms");
        System.out.println("InputStreamReader time: " + (inputStreamReaderTime / 1000000.0) + " ms");
    }
    
    static long readFileWithFileReader(String filename) {
        long startTime = System.nanoTime();
        int wordCount = 0;
        
        try {
            java.io.FileReader fr = new java.io.FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            
            br.close();
            fr.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Word count (FileReader): " + wordCount);
        return System.nanoTime() - startTime;
    }
    
    static long readFileWithInputStreamReader(String filename) {
        long startTime = System.nanoTime();
        int wordCount = 0;
        
        try {
            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(isr);
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                wordCount += words.length;
            }
            
            br.close();
            isr.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        System.out.println("Word count (InputStreamReader): " + wordCount);
        return System.nanoTime() - startTime;
    }
    
    public static void main(String[] args) {
        testStringBuilderStringBuffer();
        testFileReaderAndInputStreamReader("test.txt");
    }
}

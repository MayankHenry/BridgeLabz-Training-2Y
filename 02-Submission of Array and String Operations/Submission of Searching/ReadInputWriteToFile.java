import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadInputWriteToFile {
    static void readInputAndWrite(String filename) {
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            FileWriter fw = new FileWriter(filename);
            
            System.out.println("Enter text (type 'exit' to stop):");
            String line;
            
            while ((line = br.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                fw.write(line + "\n");
            }
            
            fw.close();
            br.close();
            isr.close();
            
            System.out.println("Data written to file: " + filename);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String filename = "output.txt";
        readInputAndWrite(filename);
    }
}

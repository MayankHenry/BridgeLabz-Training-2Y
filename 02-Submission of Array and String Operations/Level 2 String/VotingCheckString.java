import java.util.Random;

public class VotingCheckString {
    static int[] generateAges(int n) {
        Random rand = new Random();
        int[] ages = new int[n];
        
        for (int i = 0; i < n; i++) {
            ages[i] = 10 + rand.nextInt(50);
        }
        
        return ages;
    }
    
    static String[][] checkVotingEligibility(int[] ages) {
        String[][] result = new String[ages.length][2];
        
        for (int i = 0; i < ages.length; i++) {
            result[i][0] = String.valueOf(ages[i]);
            
            if (ages[i] < 0) {
                result[i][1] = "Invalid";
            } else if (ages[i] >= 18) {
                result[i][1] = "Can Vote";
            } else {
                result[i][1] = "Cannot Vote";
            }
        }
        
        return result;
    }
    
    static void displayTable(String[][] data) {
        System.out.println("Age\tEligibility");
        System.out.println("---\t-----------");
        
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t" + data[i][1]);
        }
    }
    
    public static void main(String[] args) {
        int[] ages = generateAges(10);
        String[][] eligibility = checkVotingEligibility(ages);
        
        displayTable(eligibility);
    }
}

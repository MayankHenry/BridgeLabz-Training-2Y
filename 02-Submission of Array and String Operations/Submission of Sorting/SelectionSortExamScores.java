public class SelectionSortExamScores {
    static void selectionSort(int[] scores) {
        int n = scores.length;
        
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j;
                }
            }
            
            if (minIndex != i) {
                int temp = scores[i];
                scores[i] = scores[minIndex];
                scores[minIndex] = temp;
            }
        }
    }
    
    static void displayScores(int[] scores) {
        System.out.print("Scores: ");
        for (int score : scores) {
            System.out.print(score + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] scores = {78, 45, 92, 56, 34, 88, 67, 85};
        
        System.out.println("Selection Sort - Exam Scores");
        System.out.print("Before: ");
        displayScores(scores);
        
        selectionSort(scores);
        
        System.out.print("After: ");
        displayScores(scores);
    }
}

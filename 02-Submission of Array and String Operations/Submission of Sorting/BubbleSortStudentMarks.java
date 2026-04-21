public class BubbleSortStudentMarks {
    static void bubbleSort(int[] marks) {
        int n = marks.length;
        
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            
            for (int j = 0; j < n - 1 - i; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
        }
    }
    
    static void displayMarks(int[] marks) {
        System.out.print("Marks: ");
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] marks = {78, 45, 92, 56, 34, 88, 67};
        
        System.out.println("Bubble Sort - Student Marks");
        System.out.print("Before: ");
        displayMarks(marks);
        
        bubbleSort(marks);
        
        System.out.print("After: ");
        displayMarks(marks);
    }
}

public class InsertionSortEmployeeIDs {
    static void insertionSort(int[] ids) {
        for (int i = 1; i < ids.length; i++) {
            int key = ids[i];
            int j = i - 1;
            
            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
            }
            
            ids[j + 1] = key;
        }
    }
    
    static void displayIDs(int[] ids) {
        System.out.print("IDs: ");
        for (int id : ids) {
            System.out.print(id + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int[] ids = {1005, 1002, 1008, 1001, 1007, 1003};
        
        System.out.println("Insertion Sort - Employee IDs");
        System.out.print("Before: ");
        displayIDs(ids);
        
        insertionSort(ids);
        
        System.out.print("After: ");
        displayIDs(ids);
    }
}

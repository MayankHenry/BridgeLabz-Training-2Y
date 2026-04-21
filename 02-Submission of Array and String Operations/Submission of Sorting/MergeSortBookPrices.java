public class MergeSortBookPrices {
    static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);
            
            merge(prices, left, mid, right);
        }
    }
    
    static void merge(double[] prices, int left, int mid, int right) {
        double[] temp = new double[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        
        while (i <= mid && j <= right) {
            if (prices[i] <= prices[j]) {
                temp[k++] = prices[i++];
            } else {
                temp[k++] = prices[j++];
            }
        }
        
        while (i <= mid) {
            temp[k++] = prices[i++];
        }
        
        while (j <= right) {
            temp[k++] = prices[j++];
        }
        
        for (i = left, k = 0; i <= right; i++, k++) {
            prices[i] = temp[k];
        }
    }
    
    static void displayPrices(double[] prices) {
        System.out.print("Prices: ");
        for (double price : prices) {
            System.out.print(price + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        double[] prices = {99.99, 45.50, 120.00, 67.89, 34.45, 150.00};
        
        System.out.println("Merge Sort - Book Prices");
        System.out.print("Before: ");
        displayPrices(prices);
        
        mergeSort(prices, 0, prices.length - 1);
        
        System.out.print("After: ");
        displayPrices(prices);
    }
}

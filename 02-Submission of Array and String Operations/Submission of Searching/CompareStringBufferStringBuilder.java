public class CompareStringBufferStringBuilder {
    public static void main(String[] args) {
        int iterations = 1000000;
        
        long startTime = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuffer.append("hello");
        }
        long endTime = System.nanoTime();
        long stringBufferTime = endTime - startTime;
        
        startTime = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append("hello");
        }
        endTime = System.nanoTime();
        long stringBuilderTime = endTime - startTime;
        
        System.out.println("StringBuffer time (1M concatenations): " + stringBufferTime + " ns");
        System.out.println("StringBuilder time (1M concatenations): " + stringBuilderTime + " ns");
        System.out.println("Difference: " + (stringBufferTime - stringBuilderTime) + " ns");
        
        if (stringBuilderTime < stringBufferTime) {
            System.out.println("StringBuilder is faster");
        } else {
            System.out.println("StringBuffer is faster");
        }
    }
}

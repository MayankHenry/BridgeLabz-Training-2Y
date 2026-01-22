public class LinearSearchWordInSentences {
    static String searchWordInSentences(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }
    
    public static void main(String[] args) {
        String[] sentences = {
            "The quick brown fox jumps over the lazy dog",
            "Hello world this is a test",
            "Java programming is fun",
            "Arrays and strings are important"
        };
        
        String searchWord = "programming";
        
        String result = searchWordInSentences(sentences, searchWord);
        
        System.out.println("Searching for word: '" + searchWord + "'");
        System.out.println("Result: " + result);
    }
}

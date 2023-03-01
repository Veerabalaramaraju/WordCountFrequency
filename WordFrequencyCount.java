import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencyCount {
    private HashMap<String, Integer> wordCounts;

    public WordFrequencyCount(String sentence) {
        wordCounts = new HashMap<String, Integer>();
        String[] words = sentence.split("\\s+");
        for (String word : words) {
            if (wordCounts.containsKey(word)) {
                wordCounts.put(word, wordCounts.get(word) + 1);
            } else {
                wordCounts.put(word, 1);
            }
        }
    }

    public int getCount(String word) {
        if (wordCounts.containsKey(word)) {
            return wordCounts.get(word);
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String sentence = input.nextLine();

        WordFrequencyCount wordCounter = new WordFrequencyCount(sentence);

        String[] words = sentence.split("\\s+");
        HashMap<String, Boolean> printedWords = new HashMap<String, Boolean>();
        for (String word : words) {
            if (!printedWords.containsKey(word)) {
                System.out.println(word + ": " + wordCounter.getCount(word));
                printedWords.put(word, true);
            }
        }

        input.close();
    }
}
package companies.facebook;

import java.util.HashSet;
import java.util.Set;

/**
 * Count distinct words in a sentence
 *
 * Ask:
 * Is case sensitive considered unique words ?
 * Will the sentence contain special characters.
 * Is '.' considered a unique word or we remove that ?
 */
public class CountDistinctWords {

    public static int getDistinctCount(String sentence) {
        Set<String> set = new HashSet<String>();

       // String sentence2 = sentence.replaceAll("\\s{2,}", " ");
        String sentence2 = sentence.replaceAll("\\s{2,}|\\.", " ").trim();

        String[] words = sentence2.split(" ");

        for(String word : words) {
            if(!set.contains(word)) {
                set.add(word);
            }
        }
        return set.size();
    }

    public static void main(String[] args) {
        String sentence = "This is the house that Jack built. This is the malt that lay in the house        that Jack built. This is the rat that ate the malt That lay in the " +
                "house that Jack built.";

        System.out.println(getDistinctCount(sentence));
    }
}

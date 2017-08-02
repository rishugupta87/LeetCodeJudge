package dynamicprogramming.editdistance;

/**
 Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

 You have the following 3 operations permitted on a word:

 a) Insert a character
 b) Delete a character
 c) Replace a character

 For example, the edit distance between "a" and "b" is 1, the edit distance between "abc" and "def" is 3.
 */
public class EditDistance {

    /**
     * Given two strings of length m, n
     *
     * 1) If the last characters match, do not change anything, recurse for length m-1, n-1
     * 2) If match, compute the min cost of 3 operations(insert, delete, replace) and take min of three values.
     *    a. Insert: Recurse for m, n-1
     *    b. Delete: Recurse for m-1, n
     *    c. Replace: Recurse for m-1, n-1
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return 0;
    }
}

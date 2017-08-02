package ArraysAndString.Q_01_2_ReverseString;

/**
 Given an input string, reverse the string word by word.

 For example,
 Given s = "the sky is blue",
 return "blue is sky the".

 ASK: How is the input string

    What constitutes a word?
    A sequence of non-space characters constitutes a word.

    Could the input string contain leading or trailing spaces?
    Yes. However, your reversed string should not contain leading or trailing spaces.

    How about multiple spaces between two words?
    Reduce them to a single space in the reversed string.
 */
public class ReverseWords {
    /**
     * Solution:

       We'll write a helper function reverseCharacters() that reverses all the characters in a string between a frontIndex and backIndex. We use it to:

       Reverse all the characters in the entire message, giving us the correct word order but with each word backwards.
       Reverse the characters in each individual word.
     */
    public static String reverseWords(String s) {
        final char[] chars = s.toCharArray();

        //reverse the entire string
        reverseCharacters(chars, 0 , chars.length - 1);

        int i = 0;
        int j = 0;
        while(j <= chars.length) {
            if(j == chars.length || chars[j] == ' ') { //reverse each individual word, note we have an extra condition to check if j = chars.length. This is to reverse
                // the last word, since it doesn have a space at the end
                reverseCharacters(chars, i , j-1);
                j++;
                i = j;
            } else{
                j++;
            }
        }
        return new String(chars);
    }

    /**
     * Another solution which takes care of souble spaces.
     *
     * @param s
     * @return
     */
    public  String reverseWords2(String s) {
        String[] strs = s.split("\\s+");
        StringBuilder sb = new StringBuilder();
        for(int i = strs.length - 1; i >= 0 ; i--) {
            sb.append(strs[i]).append(" ");
        }
        String reversed = sb.toString().trim();
        return reversed;
    }

    private static void reverseCharacters(char[] chars, int frontIndex, int backIndex) {
        while(frontIndex < backIndex) {
            char tmp = chars[frontIndex];
            chars[frontIndex] = chars[backIndex];
            chars[backIndex] = tmp;
            frontIndex++;
            backIndex--;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("the sky is blue"));
    }
}

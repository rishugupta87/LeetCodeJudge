package ArraysAndString.Q_27_LongestSubstringWithRepeatCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 substring, "pwke" is a subsequence and not a substring.

 */
public class LongestSubstrWithoutRepeatChars {

    /**
     Solution: Solution is correct but get time limit exceeded in leet code

     Consider input:

     "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~ abcdefghijkl....

     Test cases:
       "abcabcbb"
       "bbbbb"
       "pwwkew"
       "au"
       "aab"
       "adbccba"
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1) {
            return s.length();
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        char[] chars = s.toCharArray();
        int i = 0; int max = Integer.MIN_VALUE; int length = 0;

        while(i < chars.length) {
            if(!map.containsKey(chars[i])) {
                map.put(chars[i], i);
                length++;
                i++;
            } else {
                max = Math.max(max, length);
                i = map.get(chars[i]) + 1; //start from index after last matched character.
                map.clear();
                length = 0;
            }
        }
        max = Math.max(max, length);
        return max;
    }
}

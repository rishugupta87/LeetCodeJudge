package ArraysAndString.Q_28_LongestSubstringWithTwoUniqueCharacters;

import java.util.HashMap;
import java.util.Map;

/**
 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.
 */
public class LongestSubWithTwoUniqueChars {

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        //map of character and the frequency of occurence
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int max = Integer.MIN_VALUE;

        for(int i = 0,j = 0; i < s.length(); i++) {
            if(map.size() <= 2 ) { //just put in the map and update the length
                map.put(s.charAt(i), map.get(s.charAt(i)) == null ? 1: map.get(s.charAt(i)) + 1);
                max = Math.max(max, i - j + 1);
            } else {
                while(map.size() > 2) {
                    if( map.get(s.charAt(j)) > 1) {
                        map.put(s.charAt(j), map.get(s.charAt(j) - 1));
                    } else {
                        map.remove(s.charAt(j));
                    }
                    j++;
                }
                map.put(s.charAt(i), 1);
                max = Math.max(max, i - j + 1);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "eceba";
        lengthOfLongestSubstringTwoDistinct(s);
    }
}

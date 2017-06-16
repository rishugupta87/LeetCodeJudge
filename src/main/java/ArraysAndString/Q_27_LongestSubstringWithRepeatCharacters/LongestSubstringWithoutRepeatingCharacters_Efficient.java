package ArraysAndString.Q_27_LongestSubstringWithRepeatCharacters;

import java.util.HashMap;

/**
 Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a
 substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharacters_Efficient {

    /**
     * the basic idea is, keep a hashmap which stores the characters in string as keys and their positions as values, and keep
     * two pointers which define the max substring. move the right pointer to scan through the string , and meanwhile update the hashmap.
     * If the character is already in the hashmap, then move the left pointer to the right of the same character last found. Note that the two pointers
     * can only move forward.
     *
     * Time complexity = O(n)
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for (int i = 0, j=0; i < s.length(); ++i){
            if (map.containsKey(s.charAt(i))){
                j = Math.max(j, map.get(s.charAt(i))+1); //update the substring by incrementing j.
            }
            map.put(s.charAt(i),i); //here we dont clear the map, just override the values
            max = Math.max(max,i-j+1); // we keep updating length based on i and j index , substring from i to j always has unique characters, i can keep moving forward.
        }
        return max;
    }
}

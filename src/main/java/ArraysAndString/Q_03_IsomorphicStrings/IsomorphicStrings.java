package ArraysAndString.Q_03_IsomorphicStrings;

import java.util.HashMap;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters.
 No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.
 */
public class IsomorphicStrings {

    public static boolean areStringsIsomorphic(String s, String t) {
        if(s == null || t == null) {
            return false;
        }

        if(s.length()!=t.length()) return false;
        HashMap<Character,Character> map1=new HashMap<Character, Character>();
        HashMap<Character,Character> map2=new HashMap<Character, Character>();

        for(int i=0;i<s.length();i++){
            char c1=s.charAt(i);
            char c2=t.charAt(i);
            if(map1.containsKey(c1)){
                if(map1.get(c1)!=c2) return false;
            }
            if(map2.containsKey(c2)){
                if(map2.get(c2)!=c1) return false;
            }

            map1.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }
}
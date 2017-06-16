package ArraysAndString.Q_49_GroupAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by rg029761 on 5/15/17.
 */
public class GroupAnagrams {

    public ArrayList<ArrayList<Integer>> anagrams(final List<String> words) {
        Map<String, ArrayList<Integer>> wordToIndexListMap = new LinkedHashMap<String, ArrayList<Integer>>();

        for(int i = 0 ; i < words.size(); i++) {
            char[] chararray = words.get(i).toCharArray();
            Arrays.sort(chararray);
            String sortedString = String.valueOf(chararray); //sort each word. so that all anagrams generate same hashcode
            if(!wordToIndexListMap.containsKey(sortedString)) {
                ArrayList<Integer> tmpList = new ArrayList<Integer>();
                tmpList.add(i+1);
                wordToIndexListMap.put(sortedString, tmpList);
            } else {
                wordToIndexListMap.get(sortedString).add(i+1);
            }
        }

        final ArrayList<ArrayList<Integer>> resultList = new ArrayList<ArrayList<Integer>>();
        for(ArrayList<Integer> list : wordToIndexListMap.values()) {
            resultList.add(list);
        }
        return resultList;
    }

    public static void main(String args[]) {
        String[] words = {"cat", "dog", "god", "tca"};
        String[] s = {"dog", "elvis", "forest", "fortes", "foster", "goat", "god", "heros", "horse", "lives", "shore", "softer"};
        System.out.println(new GroupAnagrams().anagrams(Arrays.asList(words)));
        System.out.println(new GroupAnagrams().anagrams(Arrays.asList(s)));
    }
}

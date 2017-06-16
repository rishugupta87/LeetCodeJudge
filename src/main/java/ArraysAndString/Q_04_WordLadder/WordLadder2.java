package ArraysAndString.Q_04_WordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 1) Only one letter can be changed at a time, 2) Each intermediate word must exist in the dictionary.

 For example, given: start = "hit", end = "cog", and dict = ["hot","dot","dog","lot","log"], return:

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]
 */
public class WordLadder2 {

    /**
     *
     * TODO: The code is not complete
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();

        List<List<String>> resultList = new ArrayList<List<String>>();

        queue.add(beginWord);
        //if end word is not in the wordList you need to add it.

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<String> subList = new ArrayList<String>();

            for(int loop = 0 ; loop < size; loop++) {
                String currWord = queue.remove();
                subList.add(currWord);

                addValidWordsToQueue(currWord, queue, wordList);
            }
            resultList.add(subList);
        }
        return resultList;
    }

    private static void addValidWordsToQueue(String currWord, Queue queue, List<String> wordList) {
        for(int i = 0 ; i < currWord.length(); i++) {
            char[] chars = currWord.toCharArray();

            for(char c = 'a' ; c <= 'z'; c++) {
                chars[i] = c;
                String newWord = new String(chars);

                if(wordList.contains(newWord)) {
                    queue.add(newWord);
                    wordList.remove(newWord);
                }
            }
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<String>(Arrays.asList(words));

        System.out.println(findLadders(beginWord, endWord, wordList));
    }
}

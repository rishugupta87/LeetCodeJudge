package ArraysAndString.Q_04_WordLadder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
   Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

   Only one letter can be changed at a time.
   Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
   For example,

   Given:
   beginWord = "hit"
   endWord = "cog"
   wordList = ["hot","dot","dog","lot","log","cog"]
   As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
   return its length 5.

   Note:
   Return 0 if there is no such transformation sequence.
   All words have the same length.
   All words contain only lowercase alphabetic characters.
   You may assume no duplicates in the word list.
   You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {

    /**
     *
     https://discuss.leetcode.com/topic/43893/simple-java-bfs-solution-with-explanation

     The first intuition for this problem is to build a graph whose nodes represent strings and edges connect strings that are only 1 character apart,
     and then we apply BFS from the startWord node. If we find the endWord, we return the level count of the bfs. This intuition is correct, but there are
     some places that we can save time.

     When we build adjacency list graph, we don't use two loops to check every pair of string to see if they are 1 character apart. Instead, we make
     changes to current string to obtain all the strings we can reach from current node, and see if it is in the wordList. Thus, there are currentString.length() * 25
     case we need to check for every node. This is faster when the wordList set is large, since the check-every-pair method need wordList.size() * currentString.length()
     for each node. Otherwise, your may exceed the running time limit.

     For the strings we visited, we remove it from the wordList. This way we don't need to mark visited using another HashSet or something.

     Actually, we don't even need to build the adjacency list graph explicitly using a HashMap<String, ArrayList<String>>, since we keep all the nodes we can
     reach in the queue of each level of BFS. This can be seen as the keys of the HashMap are the strings that in the queue, and values are the strings that satisfy
     the 1 character apart in the wordList. Thus, we avoid the time cost of build map for those nodes we don't need to visit.

     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue = new LinkedList<String>();

        int level = 0;
        queue.add(beginWord);
        //if end word is not in the wordList you need to add it.

        while(!queue.isEmpty()) {
            int size = queue.size();

            for(int loop = 0 ; loop < size; loop++) {
                String currWord = queue.remove();
                if(currWord.equals(endWord)) {
                    return level + 1;
                }

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
            level++;
        }
        return 0;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new ArrayList<String>(Arrays.asList(words));

        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}

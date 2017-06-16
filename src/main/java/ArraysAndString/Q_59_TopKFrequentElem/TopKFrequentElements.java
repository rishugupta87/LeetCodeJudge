package ArraysAndString.Q_59_TopKFrequentElem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by rg029761 on 5/15/17.
 */
public class TopKFrequentElements {
    /**
     * put in map of word, frequency = O(n)
     * sort the map O(nlogn)
     * pick top k O(k)
     * Total time = O(nlogn)
     *
     * @param wordList
     * @param k
     * @return
     */
    public static List<Pair> findTopKUsingSorting(List<String> wordList, int k) {
        Map<String, Integer> wordToFrequencyMap = new HashMap<String, Integer>();

        //create a map of word, frequency
        for(String word: wordList) {
            if(!wordToFrequencyMap.containsKey(word)) {
                wordToFrequencyMap.put(word, 1);
            } else {
                wordToFrequencyMap.put(word, wordToFrequencyMap.get(word) + 1);
            }
        }

        //can sort the map
        List<Map.Entry<String, Integer>> entryList = new ArrayList<Map.Entry<String, Integer>>(wordToFrequencyMap.entrySet());
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(final Map.Entry<String, Integer> o1, final Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        //now put the list in the linkedHashMap
        Map<String, Integer> resultMap = new LinkedHashMap<String, Integer>();
        for(Map.Entry<String, Integer> entry: entryList) {
            resultMap.put(entry.getKey(), entry.getValue());
        }

        List<Pair> result = new ArrayList<Pair>();

        int count = 0;
        //Now take the first K from the map
        for(Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if(count < k) {
                result.add(new Pair(entry.getKey(), entry.getValue()));
                count++;
            } else {
                break;
            }
        }
        return result;
    }

    /**
     * put in map of word, frequency = O(n)
     * create heap of size k = O(k)
     * Iterate over n-k elements in mao and put in heap if currFrequency > pq.peek = O(logk)n-k
     * Total : O(n) + O(k) + O((n-k)logk)
     *
     * @param wordList
     * @param k
     * @return
     */
    public static List<Pair> findTopKUsingHeap(List<String> wordList, int k) {
        Map<String, Integer> wordToFrequencyMap = new HashMap<String, Integer>();

        //create a map of word, frequency
        for(String word: wordList) {
            if(!wordToFrequencyMap.containsKey(word)) {
                wordToFrequencyMap.put(word, 1);
            } else {
                wordToFrequencyMap.put(word, wordToFrequencyMap.get(word) + 1);
            }
        }

        //create a min heap pf size k
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>(k, new Comparator<Pair>() {
            public int compare(final Pair o1, final Pair o2) {
                return o1.frequency - o2.frequency;
            }
        });

        //put the first k elements of map in the pq
        int count = 0;
        for(Map.Entry<String, Integer> entry : wordToFrequencyMap.entrySet()) {
            String word = entry.getKey();
            int frequency = entry.getValue();
            if(count < k) {
                pq.offer(new Pair(entry.getKey(), entry.getValue()));
                count++;
            } else { //for rest of the elements check if frequence > pq top element. if yes replace top element and replace with this
                if(frequency > pq.peek().frequency) {
                    pq.poll();
                    pq.offer(new Pair(word, frequency));
                }
            }
        }
        List<Pair> result2 = new ArrayList<Pair>();

        Iterator<Pair> itr = pq.iterator();
        while(itr.hasNext()) {
            Pair pair = itr.next();
            result2.add(pair);
        }

        return result2;
    }

    static class Pair {
        String word;
        int frequency;

        public Pair(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        public String toString() {
            return String.format("\t[word=%s, frequency=%s]\n", word, frequency);
        }
    }

    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("Rishu", "is", "great", "but", "great" , "is", "is", "ithe", "the", "Rishu", "rishu", "sonal", "is", "sonal", "too", "for", "sure",
                "is", "a", "wonder");
        List<Pair> pair1 = TopKFrequentElements.findTopKUsingSorting(wordList, 5);
        System.out.println("-----------Using Sorting-------------"+ pair1.toString());
        List<Pair> pair2 = TopKFrequentElements.findTopKUsingHeap(wordList, 5);
        System.out.println("-----------Using Heap-------------"+ pair2.toString());
    }
}

package HashingProblems.uber;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Add a third dimension of time to a hashmap , so ur hashmap will look something like this - HashMap<K, t, V>
 * where t is a float value. Implement the get and put methods to this map. The get method should be something like
 * - map.get(K,t) which should give us the value. If t does not exists then map should return the closest t' such that t'
 * is smaller than t. For example, if map contains (K,1,V1) and (K,2,V2)
 * and the user does a get(k,1.5) then the output should be v1 as 1 is the next smallest number to 1.5
 *
 * See: https://www.youtube.com/watch?v=UaLIHuR1t8Q
 * http://javahungry.blogspot.com/2014/06/how-treemap-works-ten-treemap-java-interview-questions.html
 *
 * Note: Treemap is internally implemented using red black binary search tree.
 * Treemap implementation provides guaranteed log(n) time cost for the containsKey, get, put and remove operations.
 *
 */
public class HashMapUber {
    Map<Integer, TreeMap<Double, Integer>> uberMap = new HashMap<Integer, TreeMap<Double, Integer>>();

    public Integer get(final Integer key, final Double timestamp) {
        if(key == null) {
            return null;
        }
        if(!uberMap.containsKey(key)) {
            return null;
        }
        TreeMap<Double, Integer> timestampToValueMap = uberMap.get(key);
        if(timestampToValueMap.containsKey(timestamp)) {
            return timestampToValueMap.get(timestamp);
        }
        double trackMinTimestamp = 0;
        for(double currTimestamp : timestampToValueMap.keySet()) {
            if(currTimestamp < timestamp) {
                trackMinTimestamp = currTimestamp;
            }
        }
        return timestampToValueMap.get(trackMinTimestamp);
    }

    public void put(final Integer key, final Double timestamp, final Integer value) {
        if(key == null || timestamp == null) {
            return;
        }

        //check if the key already exists
        TreeMap<Double, Integer> timestampToValueMap = uberMap.get(key);
        if(timestampToValueMap == null) { //no entry for this key
            TreeMap<Double, Integer> newMap = new TreeMap<Double, Integer>();
            newMap.put(timestamp, value);
            uberMap.put(key, newMap);
        } else {
            timestampToValueMap.put(timestamp, value);
        }
    }

    public static void main(String args[]) {
        HashMapUber uber = new HashMapUber();
        uber.put(1, 24.3, 58);
        uber.put(1, 22.3, 56);
        uber.put(1, 27.3, 57);
        uber.put(2, 25.0, 68);
        uber.put(2, 26.0, 69);
        uber.put(3, 11.0, 70);
        System.out.println(uber.get(1, 25.0));
        System.out.println(uber.get(1, 24.2));
        System.out.println(uber.get(1, 26.0));
        System.out.println(uber.get(1, 21.0));
        System.out.println(uber.get(2, 26.0));
        System.out.println(uber.get(2, 25.0));
        System.out.println(uber.get(2, 26.2));
        System.out.println(uber.get(3, 12.0));
        System.out.println(uber.get(3, 10.0));
    }
}

package HashingProblems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Created by rg029761 on 9/5/16.
 */
public class RandomElement{

    /**
     * 2.
     * Note here to get random value from hashmap we have copied its value to arraylist or an array.
     * This copying is O(n) operation and the memory is too O(n).
     *
     * Then why do we copy this map values to array.
     * This is useful if you know how many times the value will be fetched randomly.
     * Copying takes O(n) operation once. However any further calls take O(1) operation to get random value from list.
     *
     * @param map
     * @return
     */
    static String getRandomValueFromHashMap(Map map) {
        List<String> list = new ArrayList<String>(map.values());
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    static Integer getRandomKeyFromHashMap(Map map) {
        List<Integer> list = new ArrayList<Integer>(map.keySet());
        Random random = new Random();
        int index = random.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String args[]) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");

        System.out.println("get random Value->");
        System.out.println(RandomElement.getRandomValueFromHashMap(map));
        System.out.println(RandomElement.getRandomValueFromHashMap(map));
        System.out.println(RandomElement.getRandomValueFromHashMap(map));
        System.out.println(RandomElement.getRandomValueFromHashMap(map));
        System.out.println(RandomElement.getRandomValueFromHashMap(map));
        System.out.println(RandomElement.getRandomValueFromHashMap(map));
        System.out.println(RandomElement.getRandomValueFromHashMap(map));

        System.out.println("Now get random key->");
        System.out.println(RandomElement.getRandomKeyFromHashMap(map));
        System.out.println(RandomElement.getRandomKeyFromHashMap(map));
        System.out.println(RandomElement.getRandomKeyFromHashMap(map));
        System.out.println(RandomElement.getRandomKeyFromHashMap(map));
        System.out.println(RandomElement.getRandomKeyFromHashMap(map));
        System.out.println(RandomElement.getRandomKeyFromHashMap(map));
    }
}

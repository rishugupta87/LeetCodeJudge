package companies.facebook;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rishugupta on 7/22/17.
 */
public class CountWordOccurence {

    public Map<String, Integer> wordCount(String[] strings) {
        //edge cases here

        Map<String, Integer> map = new HashMap<String, Integer>();

        for (String s:strings) {
            if (!map.containsKey(s)) {  // first time we've seen this string
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }
        return map;
    }
}

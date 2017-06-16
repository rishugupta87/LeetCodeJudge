package ArraysAndString.SearchString;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rg029761 on 5/27/17.
 */
public class SearchStringInSortedStrings {

    /**
     * Is input string containing duplicates.doesn matter u can put in a set
     * is the search string case sensitive
     * can we use an external data structure
     *   - if yes can put in hash set and use contains method
     * If not need to iterate over the strings in array and use equalIgnoreCase
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        List<String> dan = Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Orange", "Blue");
        boolean contains = dan.contains("Blue");

        System.out.println(contains);

    }
}

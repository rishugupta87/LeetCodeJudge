package companies.facebook;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by rishugupta on 7/28/17.
 */
public class MaxElementArray {

    public static void main(String[] args) {
        Integer[] numbers = { 8, 2, 6, 7, 0, 1, 4, 9, 5, 3 };

        int min = (int) Collections.min(Arrays.asList(numbers));
        int max = (int) Collections.max(Arrays.asList(numbers));

        System.out.println("Min number: " + min);
        System.out.println("Max number: " + max);
    }
}

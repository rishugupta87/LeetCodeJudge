package companies.facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by rishugupta on 7/22/17.
 */
public class MedianElementFromList {

    public static int getMedian(int[] numArray) {
        Arrays.sort(numArray);
        int middle = numArray.length/2;

        int medianValue = 0; //declare variable
        if (numArray.length % 2 == 1) //odd
            medianValue = numArray[middle];
        else
            medianValue = (numArray[middle-1] + numArray[middle]) / 2;

        return medianValue;
    }

    public static void main(String a[]){
        List<Integer> li = new ArrayList<Integer>();
        li.add(23);
        li.add(44);
        li.add(12);
        li.add(45);
        li.add(2);
        li.add(16);
        System.out.println("Maximum element from the list: "+ Collections.max(li));
    }
}

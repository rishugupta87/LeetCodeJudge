package ArraysAndString.Q_24_ConainsDuplicates;

import java.util.Arrays;
import java.util.HashSet;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array, and
 * it should return false if every element is distinct.
 *
 */
public class ArrayDuplicates {

    /**
     * Using external memory HashSet is easy
     *
     * Time = O(n), space = O(n)
     *
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int num : nums) {
            if(!set.add(num)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Can sort and serach for consecutive duplicates
     *
     * Time = O(nlogn)
     *
     * @param nums
     * @return
     */
    public boolean containsDuplicate2(int[] nums) {
        Arrays.sort(nums);
        for(int ind = 1; ind < nums.length; ind++) {
            if(nums[ind] == nums[ind - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7};
        System.out.println(containsDuplicate(nums));
    }
}

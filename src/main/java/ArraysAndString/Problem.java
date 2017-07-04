package ArraysAndString;

import java.util.Arrays;

/**
 * Created by rg029761 on 6/29/17.
 */
public class Problem {


    static int[] counts(int[] nums, int[] maxes) {
        if(nums == null || maxes == null) {
            return null;
        }

        if(nums.length < 2 || maxes.length > Math.pow(10, 5)) {
            return null;
        }

        int[] array = new int[maxes.length];
        int k = 0;

        //sort nums
        Arrays.sort(nums);

        for(int maxNum : maxes) {
            int numbersLessCount = findNumbersLess(maxNum, nums, 0, nums.length - 1);
            array[k++] = numbersLessCount;
        }

        return array;
    }

    static int findNumbersLess(int maxNum, int[] nums, int start, int end) {

        if(maxNum >= nums[nums.length - 1]) { //compare with last element in nums array
            return nums.length; //all are smaller in this case
        }

        while(start <= end) {
            int mid = (start + end)/2;

            if(nums[mid] <= maxNum) {
                if(nums[mid+1] > maxNum) { //found the ideal number
                    return mid + 1;
                }
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 10, 5, 4, 8};
        int[] maxes1 = {3, 1, 7, 8};
        counts(nums1, maxes1);
    }

}

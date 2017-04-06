package Math.Q_16_ProductOfArrayExceptSelf;

import java.util.Arrays;

/**
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is
 equal to the product of all the elements of nums except nums[i].

 Solve it without division and in O(n).

 For example, given [1,2,3,4], return [24,12,8,6].

 Follow up:
 Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceptSelf {

    /**
     * basically we use two arrays.
     *
     * leftArray calculates product of anything on left of it. We reuse the product calculated at each step
     * rightArray calculates product of anything right on it. We reuse the product calculated at each step
     *
     * Time complexity = O(n)
     * Space complexity = O(n) + O(n) for two arrays
     *
     * @param nums
     * @return
     */
    public static int[] product(int[] nums) {
        int n = nums.length;

        if(n == 1) {
            return nums;
        }

        int[] leftArray = new int[n];
        int[] rightArray = new int[n];

        leftArray[0] = 1;
        rightArray[n - 1] = 1;

        //populate left array, go from left to right
        //leftArray = {1, 1*1, 1*2, 2*3} = {1, 1, 2, 6}
        for(int i = 1; i < leftArray.length; i++) {
            leftArray[i] = leftArray[i - 1] * nums[i - 1];
        }

        //populate left array, go from right to left
        //rightArray = { 12*2 , 4*3, 1*4, 1} = {24, 12, 4, 1}
        for(int i = n - 2; i >=0; i--) {
            rightArray[i] = rightArray[i+1] * nums[i+1];
        }

        int[] result = new int[n];

        //multiply left and right array {1, 1, 2, 6} * {24, 12, 4, 1} =  {24, 12, 8, 6}
        for(int i = 0;i < n ; i++) {
            result[i] = leftArray[i] * rightArray[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(product(nums)));
    }
}

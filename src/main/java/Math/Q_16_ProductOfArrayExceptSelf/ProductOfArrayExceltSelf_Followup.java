package Math.Q_16_ProductOfArrayExceptSelf;

import java.util.Arrays;

/**
 Follow up:
 Could you solve it with constant space complexity?
 (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */
public class ProductOfArrayExceltSelf_Followup {

    /**
     * We can just use one array which will be the result array. How will u do this.
     * See comments
     *
     * Space is O(1) since we assumed using one array is constant time.
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        //first populate array from right to left similar to how u populate rightArray, holds the product of anything to the right
        // for nums = {1, 2, 3, 4}
        // result = {24, 12, 4, 1}
        result[nums.length-1]=1;
        for(int i=nums.length-2; i>=0; i--){
            result[i]=result[i+1]*nums[i+1];
        }

        // result = {24, 12, 4, 1}
        // nums = {1, 2, 3, 4}
        // at pos = i we already have the product of all numbers to right of result[i]
        // all we need to do is multiply the left, we keep a variable to keep track of left side multiplication
        // result = {24*1, 12*1, 4*2, 1*6} = {24, 12, 8 , 6}
        int left=1;
        for(int i=0; i<nums.length; i++){
            result[i]= result[i] * left;
            left = left * nums[i];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }
}

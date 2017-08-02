package ArraysAndString.Q_25_RemoveDuplicates;

import java.util.Arrays;

/**
 Given an array nums, write a function to move all 0's to the end of it while maintaining the
 relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

 Note:
 You must do this in-place without making a copy of the array.
 Minimize the total number of operations.
 */
public class MoveZeros {

    public void moveZeroes2(int[] nums) {
        int i=0;
        int j=0;

        while(j<nums.length){
            if(nums[j]==0){
                j++;
            }else{
                nums[i]=nums[j];
                i++;
                j++;
            }
        }

        while(i<nums.length){
            nums[i]=0;
            i++;
        }
    }

    /**
     * My solution. Also look down at leetcode solution
     *
     * @param nums
     */
    public static void moveZeroes(int[] nums) {
        if(nums.length == 0 || nums.length == 1) {
            return;
        }
        int i = 0; int j = 0;

        while(j < nums.length) {
            if(nums[i] != 0) {
                i++;
            } else {
                if (nums[j] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                    i++;
                }
            }
            j++;
        }
    }

    /**
     * Great idea easy to understand.
     *
     * @param nums
     */
    public static void moveZeroes_leetCodeSolution(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 0, 3, 12};
        int nums2[] = {2,0,0,0,0,0,1};

        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}

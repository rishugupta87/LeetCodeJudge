package permutationscombination;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a collection of distinct numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [
 [1,2,3],
 [1,3,2],
 [2,1,3],
 [2,3,1],
 [3,1,2],
 [3,2,1]
 ]
 */
public class ArrayPermutations {

    public static void permute(int[] nums) {
        permute(nums, 0 , nums.length - 1);
    }

    private static void permute(int[] nums, int l, int r) {
        if(l == r) {
            System.out.println(Arrays.toString(nums));
        } else {

            for(int i = l ; i <=r ; i++) {
                swap(nums, l, i);
                permute(nums, l+1, r);
                swap(nums, l, i); //backtrack
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp;
        temp = nums[i] ;
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
    }
}

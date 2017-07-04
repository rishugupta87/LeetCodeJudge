package permutationscombination;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example, [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 */
public class ArrayPermutationsDuplicates {

    public static void permute(int[] nums) {
        permute(nums, 0 , nums.length - 1);
    }

    private static void permute(int[] nums, int l, int r) {
        if(l == r) {
            System.out.println(Arrays.toString(nums));
        } else {

            Set<Integer> alreadyVisited = new HashSet<Integer>();
            for(int i = l ; i <=r ; i++) {
                if(alreadyVisited.add(nums[i])) { //just this extra check to see if number is already visited
                    swap(nums, l, i);
                    permute(nums, l+1, r);
                    swap(nums, l, i); //backtrack
                }
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
        int[] nums = {1, 1, 2};
        permute(nums);
    }
}

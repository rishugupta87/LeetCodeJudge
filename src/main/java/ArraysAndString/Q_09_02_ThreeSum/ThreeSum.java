package ArraysAndString.Q_09_02_ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

 Note: The solution set must not contain duplicate triplets.

 For example, given array S = [-1, 0, 1, 2, -1, -4],

 A solution set is:
 [
   [-1, 0, 1],
   [-1, -1, 2]
 ]
 */
public class ThreeSum {

    /**
     * Leet code tested
     *
     *  Idea:
     * Sort the array
     * fix position at i,
     *  Use two pointers once which moves from i+1 forward
     *  and another one which moves from end backward
     *
     * Time complexity = O(n^2)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> set = new HashSet<List<Integer>>();

        if (nums.length<3) {
            return result;
        }
        Arrays.sort(nums);

        for (int i=0; i<nums.length-2; i++) {
            int low = i+1;
            int high = nums.length-1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] == 0) {
                    set.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                } else if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else {
                    high--;
                }
            }
        }
        result.addAll(set);
        return result;
    }
}

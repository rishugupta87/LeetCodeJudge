package ArraysAndString.Q_10_3SumClosest;

import java.util.Arrays;

/**
 Given an array S of n integers, find three integers in S such that the sum is closest to a given number,

 target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumClosest {

    /**
     * Time complexity = O(n^2)
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {

        if(nums.length < 3) {
            return 0;
        }

        Arrays.sort(nums);

        int i = 0;
        int n = nums.length;

        int res = 0;
        int min = Integer.MAX_VALUE;

        while(i < n - 2) {
            int j = i+1; int k = n - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                int diff = Math.abs(sum - target);
                if(diff == 0) {
                    return sum;
                }
                if(diff < min) {
                    min = diff;
                    res = sum;
                }
                if(sum <= target) {
                    j++;
                } else if(sum > target) {
                    k--;
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        //int[] nums = {-1, 2, 1, -4};
        //System.out.println(threeSumClosest(nums, 1));

        int[] nums2 = {1, 1 , 1, 0};
        System.out.println(threeSumClosest(nums2, -100));
    }
}

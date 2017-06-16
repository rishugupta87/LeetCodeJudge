package ArraysAndString.Q_15_MinimumSizeSubarraySum;

/**
 Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

 For example, given the array [2, 3, 1, 2, 4, 3] and s = 7,
 the subarray [4, 3] has the minimal length under the problem constraint.
 */
public class MinimumSizeSubarraySum {

    /**
     * Self explanatory
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int localSum = 0;
        for (int end = 0; end < nums.length; end++) {
            localSum += nums[end];
            while (localSum >= s) {
                minLen = Math.min(minLen, end - start + 1);
                localSum -= nums[start++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}

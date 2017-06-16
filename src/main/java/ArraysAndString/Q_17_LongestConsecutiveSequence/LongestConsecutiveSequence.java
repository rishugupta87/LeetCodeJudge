package ArraysAndString.Q_17_LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 For example,
 Given [100, 4, 200, 1, 3, 2],
 The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

 Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {

    /**
     * Ideas:
     * We can also project the arrays to a new array with length to be the largest element in the array.
     * Then iterate over the array and get the longest consecutive sequence. If the largest number is too large, then the time would be bad.
     * This is just another thought.
     *
     * Solution: Using a hashset. Self Explanatory
     *
     * @param nums
     * @return
     */
    public static int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            int count = 1;

            // look left
            int num = nums[i];
            while (set.contains(--num)) {
                count++;
                set.remove(num);
            }

            // look right
            num = nums[i];
            while (set.contains(++num)) {
                count++;
                set.remove(num);
            }

            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}

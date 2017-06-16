package ArraysAndString.Q_09_01_TwoSumProblems;

import java.util.HashMap;
import java.util.Map;

/**
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

 Example:
 Given nums = [2, 7, 11, 15], target = 9,

 Because nums[0] + nums[1] = 2 + 7 = 9,
 return [0, 1].
 */
public class TwoSumUnsortedArray {
    public int[] twoSum(int[] nums, int target) {

        final Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        if(nums.length == 1) {
            return new int[] {0, 0};
        }

        for(int i = 0 ; i < nums.length; i ++) {
            final int numToLook = target - nums[i];

            if(map.containsKey(numToLook)) {
                return new int[] {map.get(numToLook), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[] {0, 0};
    }
}

package ArraysAndString.Q_09_01_TwoSumProblems;

import java.util.HashMap;
import java.util.Map;

/**
 Design and implement a TwoSumDataStructure class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.

 For example,
 add(1); add(3); add(5);
 find(4) -> true
 find(7) -> false

 Your ArraysAndString.TwoSum object will be instantiated and called as such:
 ArraysAndString.TwoSum twoSum = new ArraysAndString.TwoSum();
 twoSum.add(number);
 twoSum.find(value);

 Important Followup:
 Can we make find faster if add has just 10 elements ?
 Yes we can precompute all possible sums of pair in 10 elements and store in a set
 then find can just look at this set in O(1) time

 Good read to increase speed : https://discuss.leetcode.com/topic/31411/my-beats-99-49-java-submission/3
 */
public class TwoSumDataStructure {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    // Add the number to an internal data structure.
    //O(1) time
    // O(n) space
    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    // O(n)
    public boolean find(int value) {
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num1 = entry.getKey();
            int numToLook = value - num1;

            //first condition in if handles duplicates, second condition is normal
            if( (num1 == numToLook && entry.getValue() > 1) || (num1 != numToLook && map.containsKey(numToLook))) {
                return true;
            }
        }
        return false;
    }
}

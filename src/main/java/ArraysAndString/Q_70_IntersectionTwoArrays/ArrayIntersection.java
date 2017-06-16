package ArraysAndString.Q_70_IntersectionTwoArrays;

import java.util.HashSet;

/**
 Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:
 Each element in the result must be unique.
 The result can be in any order.
 */
public class ArrayIntersection {

    /**
     * Can easily do using two sets.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> firstSet = new HashSet<Integer>();
        HashSet<Integer> resultSet = new HashSet<Integer>();

        for(int num : nums1) {
            firstSet.add(num);
        }
        for(int num : nums2) {
            if(firstSet.contains(num)) {
                resultSet.add(num);
            }
        }
        int[] result = new int[resultSet.size()];
        int k = 0;
        for (Integer num : resultSet) {
            result[k++] = num;
        }
        return result;
    }
}

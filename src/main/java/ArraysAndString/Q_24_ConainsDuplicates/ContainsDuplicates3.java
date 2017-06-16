package ArraysAndString.Q_24_ConainsDuplicates;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices
 * i and j in the array such that the absolute difference between nums[i] and nums[j] is
 * at most t and the absolute difference between i and j is at most k.
 */
public class ContainsDuplicates3 {

    /**
     This problem requires to maintain a window of size k of the previous values that can be queried for value ranges.
     The best data structure to do that is Binary Search Tree. As a result maintaining the tree of size k will result in time complexity O(N lg K).
     In order to check if there exists any value of range abs(nums[i] - nums[j]) to simple queries can be executed both of time complexity O(lg K)

     Here is the whole solution using TreeMap.

     Solution:
     Dry Run: set = {1, 10, 16, 21, 80, 46, 60, 50}, k = 2, t = 4

     a) for i = 0; nums[i] = 1, set ={}
        tmp1 = null, tmp2 = null, set = {1}
     b) for i = 1, nums[i] = 10, set = {1}
        tmp1 = null, tmp2 = 1, 10-1 <= 4=t ? false, set = {1, 10}
     c) for i = 2, nums[i] = 16, set = {1, 10}
        tmp1 = null, tmp2 = 10, 16 - 10 <= 4 ? false, set.remove(1), set.add(16), set = {10, 16}
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int p = 0;
        if(nums.length==0) return false;
        if(k==0) return false;

        //internally uses a tree map which internally uses a balanced binary search tree.
        TreeSet<Long> set = new TreeSet<Long>();

        for(int i = 0; i<nums.length; i++){
            Long tmp1 = set.ceiling((long)nums[i]); //look for a least value in set which has value >= curr elem in array
            Long tmp2 = set.floor((long)nums[i]); //look for a greated value in set which has value <= curr elem in array
            if(tmp1!=null && tmp1 - nums[i]<=t) return true;
            if(tmp2!=null && nums[i] - tmp2<=t) return true;

            if(set.size() == k) set.remove((long)nums[p++]); // we maintain a set always of size k, once we exceed it we can remove the elements already visited starting from start of array

            set.add((long)nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {1, 10, 16, 21, 80, 46, 60, 50};
        System.out.println(containsNearbyAlmostDuplicate(nums, 2, 4));
    }
}

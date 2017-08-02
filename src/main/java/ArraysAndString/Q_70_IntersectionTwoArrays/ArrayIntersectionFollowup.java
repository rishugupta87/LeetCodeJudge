package ArraysAndString.Q_70_IntersectionTwoArrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 Given two arrays, write a function to compute their intersection including duplicates.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

 Note:
 Each element in the result should appear as many times as it shows in both arrays.
 The result can be in any order.

 Follow up:
 What if the given array is already sorted? How would you optimize your algorithm?
 What if nums1's size is small compared to nums2's size? Which algorithm is better?
 What if elements of nums2 are stored on disk, and the memory is limited such that you cannot
 load all elements into the memory at once?


 Solutions:
 Q. What if the given array is already sorted? How would you optimize your algorithm?

 If both arrays are sorted, I would use two pointers to iterate, which somehow resembles the merge process in merge sort.

 Q. What if nums1's size is small compared to nums2's size? Which algorithm is better?

 Suppose lengths of two arrays are N and M, the time complexity of my solution is O(N+M) and the space complexity if O(N) considering the hash.
 So it's better to use the smaller array to construct the counter hash.

 Well, as we are calculating the intersection of two arrays, the order of array doesn't matter. We are totally free to swap to arrays.

 Q. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

 If only nums2 cannot fit in memory, put all elements of nums1 into a HashMap, read chunks of array that fit into the memory, and record the intersections.
 If both nums1 and nums2 are so huge that neither fit into the memory, sort them individually (external sort), then read 2 elements from each array at a
 time in memory, record intersections.
 */
public class ArrayIntersectionFollowup {

    // without sorting

    /**
     *
     -Hash nums1 into the hashtable and increase values.
     -Put nums2 into the array list and decrease values in hashtable.
     -Convert ArrayList to array of integers.

     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i])) map.put(nums1[i], map.get(nums1[i])+1);
            else map.put(nums1[i], 1);
        }

        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]) && map.get(nums2[i]) > 0)
            {
                result.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }

        int[] r = new int[result.size()];
        for(int i = 0; i < result.size(); i++)
        {
            r[i] = result.get(i);
        }

        return r;
    }

    // with sorting
    public static int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0, j = 0; i< nums1.length && j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i] == nums2[j]){
                res.add(nums1[i]);
                i++;
                j++;
            }
            else{
                j++;
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i<res.size();i++){
            result[i] = res.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {1,3};

        System.out.println(Arrays.toString(ArrayIntersectionFollowup.intersect(nums1, nums2)));
    }
}

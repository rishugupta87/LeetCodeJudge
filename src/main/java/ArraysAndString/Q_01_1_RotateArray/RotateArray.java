package ArraysAndString.Q_01_1_RotateArray;

import java.util.Arrays;

/**

 Rotate an array of n elements to the right by k steps.

 For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

 Note:
 Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 */
public class RotateArray {

    /**
     * Solution 1:
     *
     * Given a[] = {1, 2, 3, 4, 5, 6, 7} n = 7, k = 3
     * can easily use an external array to copy first the last k elements and then the n - k elements
     *
     * Time complexity = O(n)
     * Space = O(n)
     *
     * @param array
     * @return
     */
    public int[] rotate(int[] array, int k) {
        //easy to implemeny
        return null;
    }

    /**
     * Can swap 5 with each prior element till 5 reaches at the first index
     * Similarly swap 6 with each prior element till 6 reaches at the second index
     * Similarly swap 7 with each prior element till 7 reaches at the third index
     *
     * Time complexity = O(kn)
     * Space complexity = O(1)
     *
     * @param array
     * @return
     */
    public static int[] rotate_usingSwap(int[] array, int k) {
        int n = array.length;

        for(int i = 0 ; i < k; i++) {
            for(int j = n - 1 ; j > 0; j--) {
                int tmp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = tmp;
            }
        }
        return array;
    }

    /**
     * By reversing the array.
     *
     1. Divide the array two parts: 1,2,3,4 and 5, 6, 7
     2. Reverse first part: 4,3,2,1
     3. Reverse second part: 7,6,5
        a[] = {4, 3, 2, 1, 7, 6, 5}
     4. Reverse the whole array: 5,6,7,1,2,3,4
     *
     * Time complexity = O(n)
     * Space complexity = O(1)
     *
     * @param array
     * @param k
     */
    public static int[] rotate_usingReversing(int[] array, int k) {
        //easy to implement
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3 , 4, 5, 6, 7};
        System.out.println(Arrays.toString(rotate_usingSwap(nums, 3)));
    }
}

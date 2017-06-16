package ArraysAndString.Q_12_MergeSortedArray;

import java.util.Arrays;

/**
 Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

 Note:
 You may assume that nums1 has enough space (size that is greater or equal to m + n)
 to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 */
public class MergeSortedArray {

    public static int[] sortedMerge(int[] A, int[] B) {
        //base cases
        int[] longArray;
        int[] shortArray;

        //find which array is the longest
        if(A.length >= B.length) {
            longArray = A;
            shortArray = B;
        } else {
            longArray = B;
            shortArray = A;
        }

        //we use three variables.
        int k = longArray.length - 1;
        int i = longArray.length - shortArray.length - 1;
        int j = shortArray.length - 1;

        while(i >= 0 && j >= 0) {
            if(longArray[i] >= shortArray[j]) {
                longArray[k--] = longArray[i--];
            } else {
                longArray[k--] = shortArray[j--];
            }
        }

        while(i >= 0) {
            longArray[k--] = longArray[i--];
        }

        while(j >= 0) {
            longArray[k--] = shortArray[j--];
        }

        return longArray;
    }

    public static void main(String[] args) {
        int[] A = {3, 8, 10, 20, 30 , 40, -1, -1, -1, -1, -1};
        int[] B = {1, 5, 11, 35, 55 };

        System.out.println(Arrays.toString(sortedMerge(A, B)));
    }
}

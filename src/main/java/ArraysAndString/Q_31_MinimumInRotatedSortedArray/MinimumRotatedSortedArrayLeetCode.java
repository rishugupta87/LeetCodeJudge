package ArraysAndString.Q_31_MinimumInRotatedSortedArray;

/**
 * Created by rg029761 on 5/10/17.
 */
public class MinimumRotatedSortedArrayLeetCode {

    /*
     * The minimum element must satisfy one of two conditions:
     *  1) If rotate, A[min] < A[min - 1];
     *  2) If not A[0].
     *
     *  Therefore, we can use binary search: check the middle element, if it is less than previous one,
      * then it is minimum. If not, there are 2 conditions as well:
      *
      * If it is greater than both left and right element,
      * then minimum element should be on its right, otherwise on its left.
     */
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        int start = 0, end = num.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (mid > 0 && num[mid] < num[mid - 1]) {
                return num[mid];
            }
            if (num[start] <= num[mid] && num[mid] > num[end]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return num[start];
    }
}

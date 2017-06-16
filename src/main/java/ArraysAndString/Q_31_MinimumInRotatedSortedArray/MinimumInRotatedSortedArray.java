package ArraysAndString.Q_31_MinimumInRotatedSortedArray;

/**
 * 4 5 6 7 0 1 2).

 Find the minimum element.You may assume no duplicate exists in the array.

 */
public class MinimumInRotatedSortedArray {

    /**
     *
     If we pick the middle element, we can compare the middle element with the leftmost (or rightmost) element.
     If the middle element is less than leftmost, the left half should be selected; if the middle element is greater
     than the leftmost (or rightmost), the right half should be selected. Using recursion or iteration, this problem can
     be solved in time log(n).

     In addition, in any rotated sorted array, the rightmost element should be less than the left-most element,
     otherwise, the sorted array is not rotated and we can simply pick the leftmost element as the minimum.

     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        if(nums.length == 0 || nums[0] < nums[nums.length - 1]) { // if single or if array is sorted
            return nums[0];
        }
        return findMin(nums, 0, nums.length - 1);
    }

    int findMin(int[] nums, int low, int high) {

        if(nums[low] < nums[high]) {
            return nums[low];
        }

        if(low >= high) {
            return nums[low];
        }
        int mid = (low + high)/2;

        if(nums[mid] < nums[low]) {
            if(nums[mid] > nums[mid-1]) {
                return findMin(nums, low, high - 1);
            } else {
                return nums[mid];
            }
        } else {
            return findMin(nums, mid+1, high);
        }
    }
}

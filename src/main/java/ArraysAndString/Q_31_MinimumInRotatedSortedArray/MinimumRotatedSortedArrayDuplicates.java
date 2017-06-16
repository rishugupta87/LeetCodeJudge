package ArraysAndString.Q_31_MinimumInRotatedSortedArray;

/**
 Follow up for "Find Minimum in Rotated Sorted Array":
 What if duplicates are allowed?

 Would this affect the run-time complexity? How and why?
 */
public class MinimumRotatedSortedArrayDuplicates {

    /**
     * Time complexity = O(n) is all elements are duplicated we need to walk through each
     * element in the array
     *
     * This is a follow-up problem of finding minimum element in rotated sorted array without duplicate elements.
     * We only need to add one more condition, which checks if the left-most element and the right-most
     * element are equal. If they are we can simply drop one of them
     *
     * @param nums
     * @return
     */
    public int findMin(int[] nums) {
        int low = 0, high = nums.length-1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else if (nums[mid] > nums[high]){
                low = mid + 1;
            } else {
                high--;  //nums[mid]=nums[high] no idea, but we can eliminate nums[high];
            }
        }
        return nums[low];
    }

}

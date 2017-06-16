package ArraysAndString.Q_16_SearchInsertPosition;

/**
 Given a sorted array and a target value, return the index if the target is found. If not, return the index where
 it would be if it were inserted in order. You may assume no duplicates in the array.

 Here are few examples.

 [1,3,5,6], 5 -> 2
 [1,3,5,6], 2 -> 1
 [1,3,5,6], 7 -> 4
 [1,3,5,6], 0 -> 0
 */
public class SearchInsertPositionFaster {

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0) {
            return -1;
        }
        int n = nums.length;
        return binarySearch(nums, target, 0, n - 1);
    }

    private static int binarySearch(int[] nums, int target, int low, int high) {
        int mid = (low + high)/2;
        if(nums[mid] == target) {
            return mid;
        }
        if(target > nums[mid]) {
            if(mid == high || target < nums[mid+1]){
                return mid + 1;
            }
            return binarySearch(nums, target, mid + 1, high);
        } else {
            if(mid == 0) {
                return 0;
            } else if(target > nums[mid - 1]) {
                return mid;
            }
            return binarySearch(nums, target, low, mid - 1);
        }
    }

    public static void main(String[] args) {
        /**

         Test cases:

         [1, 3, 5, 6]
         5
         [1, 3, 5, 6]
         2
         [1, 3, 5, 6]
         7
         [1, 3, 5, 6]
         0
         [1, 3, 5, 8]
         7
         */
        int[] nums = {1};
        System.out.println(searchInsert(nums, 0));
    }
}

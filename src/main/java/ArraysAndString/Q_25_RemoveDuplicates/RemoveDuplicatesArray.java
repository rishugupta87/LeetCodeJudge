package ArraysAndString.Q_25_RemoveDuplicates;

/**
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this in place with constant memory.

 For example,
 Given input array nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesArray {

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int i = 0; int j = 1;

        while (j < nums.length) {
            if(nums[i] == nums[j]) {
                j++;
            } else {
                nums[i+1] = nums[j];
                i = i + 1;
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,2,2,3,4,5,5};
        System.out.println(removeDuplicates(nums));
    }
}

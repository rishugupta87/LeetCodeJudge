package ArraysAndString.Q_25_RemoveDuplicates;

/**
 Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?

 For example,
 Given sorted array nums = [1,1,1,2,2,3],

 Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
 It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesArrayTwiceAllowed {

    /**
     * Brilliant solution from leet code.
     *
     * Just go through the numbers and include those in the result that haven't been included twice already.
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int num : nums) {
            if (i < 2 || num > nums[i - 2]) {
                nums[i++] = num;
            }
        }
        return i;
    }

    public static int removeDuplicates2(int[] nums) {
        if(nums.length < 3)
            return nums.length;

        int idx = 2;
        for(int i = 2; i < nums.length; ++i) {
            if(nums[i] != nums[idx-2])
                nums[idx++] = nums[i];
        }
        return idx;
    }

    public static void main(String[] args) {
        int nums[] = {1,1,2,2,2,3,4,5,5};
        System.out.println(removeDuplicates(nums));
    }
}

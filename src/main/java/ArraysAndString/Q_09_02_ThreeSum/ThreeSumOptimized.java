package ArraysAndString.Q_09_02_ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by rg029761 on 4/9/17.
 */
public class ThreeSumOptimized {

    /**
     * This solves 3 sum problem without a  hash set (which was used to remove duplicates)
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            if(i > 0 && (nums[i] == nums[i-1])) continue; // avoid duplicates

            for(int j = i+1, k = nums.length-1; j<k;) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while((j < k) && (nums[j] == nums[j-1]))j++;// avoid duplicates
                    while((j < k) && (nums[k] == nums[k+1]))k--;// avoid duplicates
                } else if(nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return list;
    }
}

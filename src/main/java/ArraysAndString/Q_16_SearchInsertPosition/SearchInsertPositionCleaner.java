package ArraysAndString.Q_16_SearchInsertPosition;

/**
 * Created by rg029761 on 4/11/17.
 */
public class SearchInsertPositionCleaner {

    /**
     * This is cleaner but slower than the other program i wrote
     *
     * @param A
     * @param target
     * @return
     */
    public int searchInsert(int[] A, int target) {
        int low = 0, high = A.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(A[mid] == target) return mid;
            else if(A[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
    }
}

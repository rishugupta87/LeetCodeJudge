package companies.facebook;

/**
 * Given an array of size n, the array contains numbers in range from 0 to k-1 where k is a
 * positive integer and k <= n. Find the maximum repeating number in this array. For example,
 * let k be 10 the given array be arr[] = {1, 2, 2, 2, 0, 2, 0, 2, 3, 8, 0, 9, 2, 3}, the maximum repeating number
 * would be 2. Expected time complexity is O(n) and extra space allowed is O(1). Modifications to array are allowed.
 */
public class MaximumRepeatingNumber {


    /**
     * Solution1:
     * f no constraint of space can easily do this using a hashmap
     *
     * Solution2:
     * A better approach is to create a count array of size k and initialize all elements of count[] as 0.
     * Iterate through all elements of input array, and for every element arr[i], increment count[arr[i]].
     * Finally, iterate through count[] and return the index with maximum value. This approach takes O(n) time,
     * but requires O(k) space.
     *
     * Solution4:
     * Can sort in place
     *
     * Solution3:
     * where arr[] = {2, 3, 3, 5, 3, 4, 1, 7}, k = 8, n = 8 (number of elements in arr[]).

     1) Iterate though input array arr[], for every element arr[i], increment arr[arr[i]%k] by k (arr[] becomes
        {2, 11, 11, 29, 11, 12, 1, 15 })

     2) Find the maximum value in the modified array (maximum value is 29). Index of the maximum value is
        the maximum repeating element (index of 29 is 3).

     3) If we want to get the original array back, we can iterate through the array one more time and
        do arr[i] = arr[i] % k where i varies from 0 to n-1.
     */
    static int maxRepeating(int arr[], int n, int k)
    {
        // Iterate though input array, for every element
        // arr[i], increment arr[arr[i]%k] by k
        for (int i = 0; i< n; i++)
            arr[(arr[i]%k)] += k;

        // Find index of the maximum repeating element
        int max = arr[0], result = 0;
        for (int i = 1; i < n; i++)
        {
            if (arr[i] > max)
            {
                max = arr[i];
                result = i;
            }
        }

        /* Uncomment this code to get the original array back
        for (int i = 0; i< n; i++)
          arr[i] = arr[i]%k; */

        // Return index of the maximum element
        return result;
    }
}

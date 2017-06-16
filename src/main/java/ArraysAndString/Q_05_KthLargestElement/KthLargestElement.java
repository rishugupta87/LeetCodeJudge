package ArraysAndString.Q_05_KthLargestElement;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 For example,
 Given [3,2,1,5,6,4] and k = 2, return 5.

 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */
public class KthLargestElement {
    /**
     * Solution 1:
     * Can construct a max heap, and then extract from heap k times, the kth time the extracted element will be the kth largest
     *
     * Time complexity: O(n) + O(klogn)
     * O(n) = to contruct the max heap, bottom up construction takes only O(n)
     * O(klogn) = k * (time taken to fix max heap property when extracted max = logn) = klogn
     *
     * @param array
     * @param k
     * @return
     */
    public static int findKthLargest_MaxHeap(int[] array, int k) {
        //by default pq makes  amin heap, so we need to do Collections.reverse to construct a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(array.length, Collections.reverseOrder());
        for(int num : array) {
            pq.add(num);
        }
        int i = 0;
        while(i < k - 1) {
            pq.poll();
            i++;
        }
        return pq.peek();
    }

    /**
     * Can improve the above by using the min heap, insert the first k elements in the min heap, iterate over the next n -k elements in the arrar.
     * If the element is > pq peek element, remove the pq peek element and add element in the pq.
     *
     * Time complexity:
     * O(k) + O(n-klogk)
     *
     * @param array
     * @param k
     * @return
     */
    public static int findKthLargest_MinHeap(int[] array, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        for(int i = 0 ; i < k; i++) {
            pq.add(array[i]);
        }
        for(int i = k ; i < array.length; i++) {
            if(array[i] > pq.peek()) {
                pq.poll();
                pq.offer(array[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] nums = {1,10, 5, 6, 11, 13, 20};
        System.out.println(findKthLargest_MaxHeap(nums, 4));
        System.out.println(findKthLargest_MinHeap(nums, 4));
    }
}

package heap.Q_03_MedianDataStream;

import java.util.Collections;
import java.util.PriorityQueue;

public class ContinuousMedian {

    /**
     * The median of a dataset of integers is the midpoint value of the dataset for which an equal
     * number of integers are less than and greater than the value.
     *
     * If your dataset contains an odd number of elements, the median is the middle element of the sorted sample.
     * In the sorted dataset {1,2,3} is the median.
     * If your dataset contains an even number of elements, the median is the average of the two middle
     * elements of the sorted sample. In the sorted dataset {1,2,3,4}, 2+3/2=2.5 is the median.
     *
     * Idea is two use two heaps. Use max heap containing left half and use min heap containing right half
     * Then use can find the biggest from left half and smallest from right half.
     *
     * Note that the two heap sizes should not differ by 1
     *
     * @param array
     * @return
     */
    public static double[] getMedians(int[] array) {
        PriorityQueue<Integer> leftHalfMaxHeap = new PriorityQueue<Integer>(4, Collections.<Integer>reverseOrder());
        PriorityQueue<Integer> rightHalfMinHeap = new PriorityQueue<Integer>();

        double[] medians = new double[array.length];

        for(int i = 0 ; i < array.length; i++) {
            int num = array[i];
            addNumber(num, leftHalfMaxHeap, rightHalfMinHeap);
            rebalance(leftHalfMaxHeap, rightHalfMinHeap);
            medians[i] = getMedian(leftHalfMaxHeap, rightHalfMinHeap);
        }
        return medians;
    }

    private static void addNumber(int num, PriorityQueue<Integer> leftHalfMaxHeap, PriorityQueue<Integer> rightHalfMinHeap) {
        if(leftHalfMaxHeap.isEmpty()) {
            leftHalfMaxHeap.offer(num);
        } else if(rightHalfMinHeap.isEmpty()) {
            rightHalfMinHeap.offer(num);
        } else if(num > leftHalfMaxHeap.peek()) {
            rightHalfMinHeap.offer(num);
        } else {
            leftHalfMaxHeap.offer(num);
        }
    }

    private static void rebalance(PriorityQueue<Integer> leftHalfMaxHeap, PriorityQueue<Integer> rightHalfMinHeap) {
        if(Math.abs(leftHalfMaxHeap.size() - rightHalfMinHeap.size()) < 2) { //no need to rebalance :
            return;
        }
        PriorityQueue<Integer> largeHeap = leftHalfMaxHeap.size() > rightHalfMinHeap.size() ? leftHalfMaxHeap : rightHalfMinHeap;
        PriorityQueue<Integer> smallerHeap = leftHalfMaxHeap.size() < rightHalfMinHeap.size() ? leftHalfMaxHeap : rightHalfMinHeap;

        while (largeHeap.size() - smallerHeap.size() >= 2) {
            smallerHeap.offer(largeHeap.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> leftHalfMaxHeap, PriorityQueue<Integer> rightHalfMinHeap) {
        PriorityQueue<Integer> largeHeap = leftHalfMaxHeap.size() > rightHalfMinHeap.size() ? leftHalfMaxHeap : rightHalfMinHeap;
        PriorityQueue<Integer> smallerHeap = leftHalfMaxHeap.size() < rightHalfMinHeap.size() ? leftHalfMaxHeap : rightHalfMinHeap;

        if(smallerHeap.size() == largeHeap.size()) {
            return ((double)leftHalfMaxHeap.peek() + rightHalfMinHeap.peek())/2;
        } else {
            return largeHeap.peek();
        }
    }

    public static void main(String[] args) {

    }
}

package ArraysAndString.Q_05_MedianSortedArray;

/**
 * Created by rg029761 on 5/27/17.
 */
public class MedianSortedArray {

    /**
     *
        1) Calculate the medians m1 and m2 of the input arrays ar1[]
           and ar2[] respectively.
        2) If m1 and m2 both are equal then we are done.
           return m1 (or m2)
        3) If m1 is greater than m2, then median is present in one
           of the below two subarrays.
           a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
           b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
        4) If m2 is greater than m1, then median is present in one
           of the below two subarrays.
           a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
           b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
        5) Repeat the above process until size of both the subarrays
           becomes 2.
        6) If size of the two arrays is 2 then use below formula to get
           the median.
           Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
     *
     *
     */

    private static final int ERROR_INVALID_INPUT = -1; // change value of this const as per your specific requirement

    public int max(int a, int b)
    {
        if (a > b) return a;
        return b;
    }

    public int min(int a, int b)
    {
        if (a < b) return a;
        return b;
    }

    private double findMedian(int[] array, int startIndex, int endIndex)
    {
        int indexDiff = (endIndex - startIndex);
        if (indexDiff % 2 == 0) // we are looking at odd number of elements
        {
            return array[startIndex + (indexDiff/2)];
        }
        else
        {
            return 1.0 * (array[startIndex + (indexDiff/2)] + array[startIndex + (indexDiff/2) + 1])/2;
        }
    }

    // a: 1,2,5,11,15  // b: 3 4 13 17 18
    public double findMedianSortedArrays(int[] a, int[] b, int startIndexA, int endIndexA, int startIndexB, int endIndexB) {
        if ((endIndexA - startIndexA < 0) || ((endIndexB - startIndexB < 0)))
        {
            System.out.println("Invalid Input.");
            return ERROR_INVALID_INPUT;
        }

        if ((endIndexA - startIndexA == 0) && ((endIndexB - startIndexB == 0))) //just 1 element
        {
            return (a[0] + b[0])/2;
        }

        if ((endIndexA - startIndexA == 1) && ((endIndexB - startIndexB == 1))) //2 elements
        {
            return (1.0 * (max(a[startIndexA], b[startIndexB]) + min(a[endIndexA], b[endIndexB])))/2;
        }

        double m1 = findMedian(a, startIndexA, endIndexA);
        double m2 = findMedian(b, startIndexB, endIndexB);

        if (m2 == m1)
        {
            return m2;
        }

        // since m1 <= median <= m2 narrow down search by eliminating elements less than m1 and elements greater than m2
        if (m1 < m2)
        {
            if ((endIndexA - startIndexA) % 2 == 0) // we are looking at odd number of elements
            {
                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
                endIndexB = startIndexB + (endIndexB - startIndexB) / 2;
            }
            else
            {
                startIndexA = startIndexA + (endIndexA - startIndexA) / 2;
                endIndexB = startIndexB + (endIndexB - startIndexB) / 2 + 1;
            }
        }

        // since m2 <= median <= m1 narrow down search by eliminating elements less than m2 and elements greater than m1
        else // m2 < m1
        {
            if ((endIndexB - startIndexB) % 2 == 0) // we are looking at odd number of elements
            {
                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
                endIndexA = startIndexA + (endIndexA - startIndexA) / 2;
            }
            else
            {
                startIndexB = startIndexB + (endIndexB - startIndexB) / 2;
                endIndexA = startIndexA + (endIndexA - startIndexA) / 2 + 1;
            }
        }
        return findMedianSortedArrays(a, b, startIndexA, endIndexA, startIndexB, endIndexB);
    }

    public static void main(String[] args) {

        MedianSortedArray solution = new MedianSortedArray();

        System.out.println("Case 1: When arrays have odd number of elements in them.");
        int [] a = {1,2,3,4,5};
        int [] b = {6,7,8,9,10};

        System.out.println("Median: " + solution.findMedianSortedArrays(a, b, 0, a.length-1, 0, b.length-1));

        System.out.println("-----------------");

        System.out.println("Case 2: When arrays have even number of elements in them.");
        int[] c = {1,2,99, 100};
        int[] d = {4,5,101, 102};

        System.out.println("Median: " + solution.findMedianSortedArrays(c, d, 0, c.length-1, 0, d.length-1));
    }
}


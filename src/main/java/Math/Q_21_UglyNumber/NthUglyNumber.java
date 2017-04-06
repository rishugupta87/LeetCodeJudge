package Math.Q_21_UglyNumber;

/**
 Write a program to find the n-th ugly number.

 Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example,
 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

 Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class NthUglyNumber {
    /**
     * Can iterate over each number and keep a count of number of ugly numbers encountered so far.
     * If no of ugly numbers encountered = n, return that number
     *
     * This method is not time efficient as it checks for all integers until ugly number count becomes n, but space complexity of this method is O(1)
     */
    public static int findNthUglyNumber(int n) {
        int num = 1;
        int uglyNoCount = 0;

        while(uglyNoCount != n) {
            if(UglyNumber.isUglyNumber(num)) {
                uglyNoCount++;

                if(uglyNoCount == n) { //found the nth ugly number.
                    break;
                }
            }
            num++;
        }
        return num;
    }


    public static void main(String[] args) {
        for(int i = 1 ; i <= 10; i++) {
            System.out.println(findNthUglyNumber(i));
        }
    }
}

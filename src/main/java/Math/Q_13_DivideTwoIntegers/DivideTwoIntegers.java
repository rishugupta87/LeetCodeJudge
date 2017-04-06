package Math.Q_13_DivideTwoIntegers;

/**
 * Divide two integers without using multiplication, division and mod operator. If it is overflow, return MAX_INT.

   Return the floor of the result of the division.

   Example:
   5 / 2 = 2
 */
public class DivideTwoIntegers {

    /**
     * Lets say you wanna devide 39/4
     * dividend = 39, divisor = 4;
     *
     * 1) Keep multiplying divisor with multiples of 2 till the result is <= divident
     *   4 << 0 => 4 * 2^0 = 4
     *   4 << 1 => 4 * 2^1 = 8
     *   4 << 2 => 4 * 2^2 = 16
     *   4 << 3 => 4 * 2^3 = 32
     *   4 << 4 => 4 * 2^4 = 64
     *
     *   Since 64 > 39, the previous quotient was  2^3 = 8 , save this res = 8
     *
     * 2) Next loop the divident now is 39 - 4 * 2^3 = 7
     *    So now the problem is to divide 7/4
     *
     *     4 << 0 => 4 * 2^0 = 4
     *     4 << 1 => 4 * 2^1 = 8
     *
     *     Since 8 > 7 , he previous quotient was  2^0 = 1 , save this and add to previous result = 8 + 1 = 9
     *
     * 3) Next loop divident = 7 - 4 * 2^0 = 3
     *    Since 3 < 4 we break
     *
     * return res = 9
     *
     * Time complexity = O(logn)
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public static int divide(int dividend, int divisor) {

        //handle special cases
        if(divisor == 0) return Integer.MAX_VALUE;

        if(dividend == Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        if(dividend == Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }

        int sign = -1;
        if(dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) {
            sign = 1;
        }

        //get positive values
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);

        int multiplier = 0;
        int noOfShifts = 0;
        int quotient = 0;
        int previousMultiplier = 0;

        while(divisor <= pDividend) {
            multiplier = (int) pDivisor << noOfShifts;
            if(multiplier > pDividend) {
                quotient += 1 << (noOfShifts - 1);
                pDividend = pDividend - previousMultiplier;
                noOfShifts = 0;
            } else {
                previousMultiplier = multiplier; //keep track of previousMultiplier
                noOfShifts++;
            }
        }
        return quotient * sign;
    }

    public static void main(String[] args) {
        System.out.println(divide(311, 5));
        System.out.println(divide(39, 4));
    }
}

package Math.Q_09_TrailingZerosFactorial;

public class FactorialTrailingZeros {

    /**
     * Solution explanation:
     * http://www.purplemath.com/modules/factzero.htm
     *
     Take the number that you've been given the factorial of.
     Divide by 5; if you get a decimal, truncate to a whole number.
     Divide by 52 = 25; if you get a decimal, truncate to a whole number.
     Divide by 53 = 125; if you get a decimal, truncate to a whole number.
     Continue with ever-higher powers of 5, until your division results in a number less than 1.
     Once the division is less than 1, stop.
     Sum all the whole numbers you got in your divisions. This is the number of trailing zeroes.
     *
     * @param n
     * @return
     */
    public static int getTrailingZeros(int n) {
        int trailingZeros = 0;
        while (n > 0) {
            trailingZeros += n/5;
            n = n/5;
        }
        return trailingZeros;
    }

    public static void main(String[] args) {
        System.out.println(getTrailingZeros(23));
        System.out.println(getTrailingZeros(101));
        System.out.println(getTrailingZeros(1000));
        System.out.println(getTrailingZeros(4617));
    }
}

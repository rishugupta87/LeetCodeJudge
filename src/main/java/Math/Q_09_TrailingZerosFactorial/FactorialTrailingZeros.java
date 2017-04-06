package Math.Q_09_TrailingZerosFactorial;

public class FactorialTrailingZeros {

    /**
     * Solution explanation:
     * http://www.purplemath.com/modules/factzero.htm
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

package Math.Q_03_PowerNumber;

/**
 * Created by rg029761 on 3/28/17.
 */
public class PowerNumer_Solution2 {

    /**
     * Can divide the problem in half and solve recursively.
     *
     * Although this works we are doing unnecessary work to call recursion twice tio calculate the same value
     *
     * for ex 2^4
     *
     * Time complexity = O(n)
     *
     * @param x
     * @param n
     * @return
     */
    public static double calculatePower(double x, int n) {
        if(n == 0) {
            return 1;
        }
        if (n == 1)
            return x;

        if (n % 2 == 0) {
            if(n < 0) {
                return 1/(calculatePower(x, n / 2) * calculatePower(x, n / 2));
            } else {
                return calculatePower(x, n / 2) * calculatePower(x, n / 2);
            }
        } else {
            if(n < 0) {
                return 1/x*(calculatePower(x, n / 2) * calculatePower(x, n / 2));
            } else {
                return x* calculatePower(x, n / 2) * calculatePower(x, n / 2);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2,3));
        System.out.println(calculatePower(2,-3));
        System.out.println(calculatePower(2.5,3));
    }
}

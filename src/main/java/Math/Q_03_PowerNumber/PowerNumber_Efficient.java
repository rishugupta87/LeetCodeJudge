package Math.Q_03_PowerNumber;

public class PowerNumber_Efficient {

    /**
     * Sol2 can be optimized to O(logn) by calculating power(x, n/2) only once and storing it.
     *
     * @param x
     * @param n
     * @return
     */
    public static double calculatePower(double x, int n)
    {
        if( n == 0)
            return 1;

        double temp = calculatePower(x, n / 2);

        if (n%2 == 0) {
            return temp * temp;
        } else {
            if(n > 0) {
                return x * temp * temp;
            } else {
                return (temp*temp)/x;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2,3));
        System.out.println(calculatePower(2,4));

        System.out.println(calculatePower(2,-3));
        System.out.println(calculatePower(2,-4));

        System.out.println(calculatePower(2.5,3));
    }
}

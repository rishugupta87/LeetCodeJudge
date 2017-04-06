package Math.Q_03_PowerNumber;

/**
 * Implement pow(x, n).
 *
 * Examples to consider:
 * 2^3 = 8
 * 2^-3  = 1/8
 * 2.5 ^ 2 = 6.25
 */
public class PowerNumber_Recursion {

    public static double calculatePower(double x , int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return x;
        }
        double val = x * calculatePower(x, Math.abs(n) - 1);

        return n < 0 ? 1/val : val;
    }

    public static void main(String[] args) {
        System.out.println(calculatePower(2,3));
    }
}

package Math.Q_01_ReverseInteger;

/**

 Reverse digits of an integer.
 Example1: x = 123, return 321
 Example2: x = -123, return -321

 Time complexity = O(no of digits in the number)
 */
public class ReverseInteger {
    public static int reverseInteger(int num) {

        if(String.valueOf(num).length() == 1) {
            return num;
        }
        int sign = num < 0 ? -1 : 1;

        num = Math.abs(num);

        long rev = 0;
        int remainder = 0;
        while (num > 0) {
            remainder = num % 10;
            rev = rev*10 + remainder;
            if(rev < Integer.MIN_VALUE || rev > Integer.MAX_VALUE) {
                return 0;
            }
            num = num / 10;
        }

        return (int)(rev * sign);
    }


    public static void main(String args[]) {
        System.out.println(new ReverseInteger().reverseInteger(45678));
    }
}

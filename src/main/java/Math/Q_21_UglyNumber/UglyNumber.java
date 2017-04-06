package Math.Q_21_UglyNumber;

/**
   Write a program to check whether a given number is an ugly number.
   Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are
   ugly while 14 is not ugly since it includes another prime factor 7.
   Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {
    public static boolean isUglyNumber(int num) {
        if(num == 0) { //you need this check else you will get a stack overflow
            return false;
        }
        if(num == 1) {
            return true;
        }
        if(num % 2 == 0) {
            return isUglyNumber(num / 2);
        } if(num % 3 == 0) {
            return isUglyNumber(num / 3);
        } if(num % 5 == 0) {
            return isUglyNumber(num / 5);
        }
        return false;
    }

    public static void main(String[] args) {
         System.out.println(UglyNumber.isUglyNumber(323));
         //System.out.println(UglyNumber.isUglyNumber(6));
         //System.out.println(UglyNumber.isUglyNumber(8));
         //System.out.println(UglyNumber.isUglyNumber(14));
    }
}

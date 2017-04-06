package Math.Q_02_PalindromeNumber;

import Math.Q_01_ReverseInteger.ReverseInteger;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * You are not allowed to convert the integer to a string.
 *
 */
public class PalindromeNumber {

    /**
     * Return true if you think the number is a palindrome.
     *
     * Easy is allowed to reverse the integer.
     *
     * If the reversed integer = original number then the number is a palindrome ignore the sign(-ve numbers)
     *
     * @param num
     * @return
     */
    public static boolean isPalindrome(int num) {
        return num == ReverseInteger.reverseInteger(num);
    }

    /**
     * Return true if you think the number is a palindrome.
     *
     * Not allowed to reverse the integer.
     *
     * ex: 132231
     * ex: 1331
     *
     * Need a way to compare the first and the last digit.
     *
     * @param x
     * @return
     */

    public static boolean isPalindrome_withoutExtraSpace(int x) {
        if(x < 0 || x == Integer.MIN_VALUE || x == Integer.MAX_VALUE) {
            return false;
        }

        int num = x;

        int div = 1;
        while (x / div >= 10) {
            div *= 10;
        }

        //ex 34543
        while (num != 0) {
            int left = num / div; // 34543/10000=3
            int right = num % 10; // 34543 % 10 = 3

            if (left != right)
                return false;

            num = (num % div) / 10; //this will strip first and last digit = 454
            div /= 100;  //div = 100
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(1332));
        System.out.println(isPalindrome_withoutExtraSpace(34543));
    }
}

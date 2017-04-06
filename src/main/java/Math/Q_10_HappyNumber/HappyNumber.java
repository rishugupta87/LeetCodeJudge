package Math.Q_10_HappyNumber;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 *
 * To figure out if a number is happy or sad, you must separate its digits,
 * square each digit in the number and then add each squared digit together.
 * Keep doing this process until you either reach 1=Happy, or if the process loops back it is Sad.
 *
   19 is a happy number

   1^2 + 9^2 = 82
   8^2 + 2^2 = 68
   6^2 + 8^2 = 100
   1^2 + 0^2 + 0^2 = 1
 *
 */
public class HappyNumber {

    public static boolean isHappyNumber(int n) {
        if(n == 1) {
            return true;
        }

        //The loop will stop if you encounter the same number again, to keep track maintain a hashset
        Set<Integer> set = new HashSet<Integer>();

        while(!set.contains(n)) {
            set.add(n);
            int squareSum = getDigitsSquared(n);
            if(squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }
    private static int getDigitsSquared(int n) {
        int squareSum = 0;
        while(n > 0) {
            squareSum += Math.pow(n % 10, 2);
            n = n/10;
        }
        return squareSum;
    }

    public static void main(String[] args) {
        System.out.println(isHappyNumber(19)); //happy
        System.out.println(isHappyNumber(7)); //happy
        System.out.println(isHappyNumber(32)); //happy
        System.out.println(isHappyNumber(121)); //sad
    }
}

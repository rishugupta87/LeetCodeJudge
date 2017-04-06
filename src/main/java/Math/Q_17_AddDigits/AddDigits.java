package Math.Q_17_AddDigits;

/**
 Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.

 For example:

 Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.

 Follow up:
 Could you do it without any loop/recursion in O(1) runtime?
 */
public class AddDigits {

    public static int addDigits(int num) {
        if(num <= 9) {
            return num;
        }
        return add(num, 0);
    }

    private static int add(int num, int sumOfDigits) {
        while(num > 0) {
            sumOfDigits += num % 10;
            num = num/10;
        }
        if(String.valueOf(sumOfDigits).length() == 1) {
            return sumOfDigits;
        } else {
            return add(sumOfDigits, 0);
        }
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}

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

    /**
     * The digital root (also repeated digital sum) of a non-negative integer is the (single digit) value obtained by
     * an iterative process of summing digits, on each iteration using the result from the previous iteration to compute a digit sum.
     * The process continues until a single-digit number is reached.

       For example, the digital root of 65,536 is 7, because 6 + 5 + 5 + 3 + 6 = 25 and 2 + 5 = 7.


     *
     * @param num
     * @return
     */
    public int addDigits_followup(int num) {
        return num==0?0:(num%9==0?9:(num%9));

    }

    public int addDigits_followup2(int num) {
        if(num <= 9) {
            return num;
        }

        if(num % 9 == 0) {
            return 9;
        }
        return num % 9;
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}

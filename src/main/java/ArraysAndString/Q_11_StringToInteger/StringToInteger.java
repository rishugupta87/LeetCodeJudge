package ArraysAndString.Q_11_StringToInteger;

/**
 Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases. If you want a challenge,
 please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 You are responsible to gather all the input requirements up front.
 */
public class StringToInteger {

    /**
     * Consider Cases:
     *    "123" = 123
     *    "-212" = 212
     *    "-212.90" = -212
     *    "bcdeh" = 0
     *    "12abc" = 12 (only check start characters.)
     *    "1a2bc" = 1
     *    "abc12" = 0
     *    " " = 0
     *    null = 0
     *
     *
     * @param str
     * @return
     */
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }
        String s1 = str.trim();
        int sign = s1.charAt(0) == '-'  ? -1 : 1;
        int i = sign == -1 ||  s1.charAt(0) == '+' ? 1 : 0;

        double result = 0 ;

        while (i < s1.length()) {
            char c = s1.charAt(i);
            if(Character.isDigit(c)) {
                result = result * 10 + Character.getNumericValue(c);
            } else {
                break;
            }
            i++;
        }
        result = result* sign;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int)result;
    }
}

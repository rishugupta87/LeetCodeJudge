package Math.Q_14_MultiplyStrings;

/**

 Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.

 Note:
 The length of both num1 and num2 is < 110.
 Both num1 and num2 contains only digits 0-9.
 Both num1 and num2 does not contain any leading zero.
 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class StringNumberMultiplication {

    /**
     * Explanation in evernote
     *
     * The key to solve this problem is multiplying each digit of the numbers at the corresponding positions
     * and get the sum values at each position. That is how we do multiplication manually.
     *
     * @param num1
     * @param num2
     * @return
     */
    public static String multiply(String num1, String num2) {
        int n1 = num1.length(), n2 = num2.length();
        int[] products = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';
                products[i + j + 1] += d1 * d2;
            }
        }
        int carry = 0;
        for (int i = products.length - 1; i >= 0; i--) {
            int sum = products[i] + carry;
            products[i] = sum % 10;
            carry = sum / 10;
        }
        StringBuilder sb = new StringBuilder();
        for (int num : products) sb.append(num);
        while (sb.length() != 0 && sb.charAt(0) == '0') sb.deleteCharAt(0);
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(multiply("362", "124"));
        System.out.println(multiply("12", "12"));
    }
}


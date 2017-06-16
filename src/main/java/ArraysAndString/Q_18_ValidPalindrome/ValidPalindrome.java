package ArraysAndString.Q_18_ValidPalindrome;

/**
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 Can we reverse the string ? note we generally reverse string using stringbuilder.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {

    public static boolean isPalindrome(String s) {
        if(s.length() == 0) {
            return true;
        }
        //remove all the extra white spaces and invalid characters and convert to lower case.
        String s2 = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        return isStringPalindrome(s2);
    }

    private static boolean isStringPalindrome(final String s2) {
        char[] chars = s2.toCharArray();
        int low = 0;
        int high = chars.length - 1;
        while(low < high) {
            if(chars[low] != chars[high]) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}

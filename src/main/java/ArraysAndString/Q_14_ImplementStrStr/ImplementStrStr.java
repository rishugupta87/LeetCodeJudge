package ArraysAndString.Q_14_ImplementStrStr;

/**
 Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack
 */
public class ImplementStrStr {

    /**
     *  We need to do this without using indexOf operator.
     *
     *  Time complexity: O(n^2)
     *
     *  To do better than this you need to use the KMP Algorithm
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        if(haystack == null || haystack.length() == 0) {
            return -1;
        }
        if(haystack.length() < needle.length()) {
            return -1;
        }
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) return i;
                if (i + j == haystack.length()) return -1;
                if (needle.charAt(j) != haystack.charAt(i + j)) break;
            }
        }
    }

    /**
     * We have used indexOf Method here. Ideally try to implement strstr without using indexof
     *
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr2(String haystack, String needle) {
        if(needle == null || needle.length() == 0) {
            return 0;
        }
        if(haystack == null || haystack.length() == 0) {
            return -1;
        }
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        String str = "Rishu is a";
        System.out.println(strStr(str, "shl"));
    }
}

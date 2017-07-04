package permutationscombination;

/**
 * Created by rg029761 on 7/1/17.
 */
public class StringPermutationsToggle {

    public static void permute(String s) {
        permute(s, 0 , s.length() - 1);
    }
    /**
     * permutation function
     * @param str string to calculate permutation for
     * @param l starting index
     * @param r end index
     */
    private static void permute(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++) {

                char c = Character.toUpperCase(str.charAt(i));
                String remain = str.substring(1, str.length());

                str = swap(String.valueOf(c) + remain, l, i);
                permute(str, l+1, r);
                str = swap(str, l, i);
            }
        }
    }

    private static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        permute("abc");
    }
}

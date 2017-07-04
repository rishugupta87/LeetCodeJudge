package permutationscombination;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by rg029761 on 7/1/17.
 */
public class StringPermutationsDuplicates {

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
        else {
            Set<Character> alreadyVisited = new HashSet<Character>();
            for (int i = l; i <= r; i++) {
                if(alreadyVisited.add(str.charAt(i))) {
                    str = swap(str, l, i);
                    permute(str, l+1, r);
                    str = swap(str, l, i);
                }
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

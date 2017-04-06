package Math.Q_08_ExcelSheetColumnTitle;

/**
 Given a positive integer, return its corresponding column title as appear in an Excel sheet. For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB
 */
public class ExcelSheetColumnTitle {

    /**
     *
     This problem is not difficult but needs more attention on the format.
     General cases are straightforward:
     1 -> A
     2 -> B
     3 -> C
     27 -> AA    27/26 = 1    27%26 = 1   1->A, 1->A   thus AA
     3  -> C     3/26 =  0,   3%26 =  3   0-> , 3->C   thus C
     53 -> BA    53/26 = 2    53%26 = 1   2>B , 1->A   thus BA

     Some special cases we need to handle:
     26 -> Z           26%26 = 0      26/26 = 0,
     52 -> AZ          52%26 = 0      52/26 = 2,

     When n%26 == 0, the last digit must be filled with a 'Z', therefore n in the next step must subtract this 'Z' (which is 26) and continue.
     *
     * @param n
     * @return
     */
    public static String convertToTitle(int n) {
        StringBuilder res = new StringBuilder();
        while (n>0) {
            if (n%26==0){
                res.append("Z");
                n = n/26 -1;
            }else{
                int val =  n % 26 - 1 + 'A';
                char c = (char) val;
                res.append(c);
                n = n/26;
            }
        }
        return res.toString();
    }


    /**
     * Second Solution
     *
     * @param n
     * @return
     */
    public static String convertToTitle2(int n) {
        if(n <= 0){
            throw new IllegalArgumentException("Input is not valid!");
        }

        StringBuilder sb = new StringBuilder();

        while(n > 0){
            n--;
            char ch = (char) (n % 26 + 'A');
            n /= 26;
            sb.append(ch);
        }

        sb.reverse();
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convertToTitle(702));
    }
}

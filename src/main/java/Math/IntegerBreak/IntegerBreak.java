package Math.IntegerBreak;

/**

 Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

 For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

 Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {

    /**
       Notice the pattern
        2 -> 1*1
        3 -> 1*2
        4 -> 2*2
        5 -> 3*2
        6 -> 3*3
        7 -> 3*4
        8 -> 3*3*2
        9 -> 3*3*3
        10 -> 3*3*4
        11 -> 3*3*3*2

        We only need to find how many 3's we can get when n> 4. If n%3==1, we do not want 1 to be one of the broken numbers, we want 4.

        How to think about the problem ?
        We observed that for all N > 4, all factors should be 2 0r 3 . How ?

        Solution:
        If an optimal product contains a factor f >= 4, then you can replace it with factors 2 and f-2 without
        losing optimality, as 2*(f-2) = 2f-4 >= f. So you never need a factor greater than or equal to 4, meaning you only need factors 1, 2 and 3
        (and 1 is of course wasteful and you'd only use it for n=2 and n=3, where it's needed).

        Which is better factor of 2 or 3 ?
        Consider: 6 = 2 + 2 + 2 = 3 + 3. But 2 * 2 * 2 < 3 * 3.
        Therefore, if there are three 2's in the decomposition, we can replace them by two 3's to gain a larger product.

        All the analysis above assumes n is significantly large. When n is small (say n <= 10), it may contain flaws.
        For instance, when n = 4, we have 2 * 2 > 3 * 1.

        * @param num
        * @return
     */
    public static int integerBreak(int n) {
        if(n==2) return 1;
        if(n==3) return 2;
        if(n==4) return 4;

        int result=1;
        if(n % 3 == 0){ // for n = 6
            int m = n/3;
            result = (int) Math.pow(3, m);
        }else if(n % 3 == 2){ // for n = 5
            int m=n/3;
            result = (int) Math.pow(3, m) * 2;
        }else if(n % 3 == 1){ //for n = 7
            int m = (n-4)/3;
            result = (int) Math.pow(3, m) *4;
        }
        return result;
    }
}

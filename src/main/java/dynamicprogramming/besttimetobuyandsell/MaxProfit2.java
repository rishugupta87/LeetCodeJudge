package dynamicprogramming.besttimetobuyandsell;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete as many transactions as you
 like (ie, buy one and sell one share of the stock multiple times). However, you may not engage
 in multiple transactions at the same time (ie, you must sell the stock before you buy again).

 */
public class MaxProfit2 {

    /**
     * just need to buy/sell when it is profitable.
     *
     I don't think the code has any conflict with the requirement "you can't
     sell and buy at the same time position". Accumulating the gain profit every day
     does not have to mean that I sell and buy the stock every day. I just check my account and
     say :"wow, I gained more xx profit!" when the stock price is increasing.
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int total = 0;
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1] > prices[i]) {
                total += prices[i+1] - prices[i];
            }
        }

        return total;
    }

    public static void main(String[] args) {
        int[] prices = {2,1,2,0,1};
        System.out.println(maxProfit(prices));
    }
}

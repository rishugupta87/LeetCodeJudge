package dynamicprogramming.besttimetobuyandsell;

import java.util.Arrays;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)

 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 */
public class MaxProfit {

    /**
     * The points of interest are the peaks and valleys in the given graph. We need to find the largest peak following the smallest valley.
     * We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference
     * between selling price and minprice) obtained so far respectively.
     *
     * @param prices
     * @return
     */
    public int maxProfit_bestWay(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    public int maxProfit_KendanesAlgo(int[] prices) {
        int maxCur = 0, maxSoFar = 0;
        for(int i = 1; i < prices.length; i++) {
            maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
            maxSoFar = Math.max(maxCur, maxSoFar);
        }
        return maxSoFar;
    }

    public static int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1) {
            return 0;
        }
        return maxProfit(prices, new int[prices.length]);
    }

    public static int maxProfit(int[] prices, int[] maxProfit) {
        maxProfit[0] = 0;

        int maxProfitSum = 0;
        for(int i = 1 ; i < prices.length; i++) {
            maxProfit[i] = maxProfit[i - 1] + (prices[i] - prices[i-1]) > 0 ? maxProfit[i - 1] + (prices[i] - prices[i-1]) : 0;
            maxProfitSum = Math.max(maxProfitSum, maxProfit[i]);
        }

        return maxProfitSum;
    }

    public static void main(String[] args) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        //int[] prices2 = {2,1,2,1,0,1,2};

        System.out.println(maxProfit(prices1));
    }
}

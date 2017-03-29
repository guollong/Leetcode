/**
 * Question description: Say you have an array for which the ith element is the price of a given stock on day i.
 * 		If you were only permitted to complete at most one transaction, design an algorithm to find the maximum profit.
 *
 * Example 1: Input: [7, 1, 5, 3, 6, 4]; Output: 5
 * Example 2: Input: [7, 6, 4, 3, 1]; Output: 0 (In this case, no transaction is done, i.e. max profit = 0.)
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

public class Solution {
    public int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (maxprofit < prices[i] - minprice){
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }
}
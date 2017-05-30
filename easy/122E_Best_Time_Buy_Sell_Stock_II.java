/**
 * Question description: Say you have an array for which the ith element is the price of a given stock on day i.
 * 		Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 *		(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
 * 		transactions at the same time (ie, you must sell the stock before you buy again).
 * Note: Just get the max profit, the times of transactions do not matter.
 */

/**
 * Author: Jinglong Guo
 * Company: .
 * Date: 03/25/2017
 */

// Approach 1: peak valley approach
// Idea: The points of interest are consecutive valleys and peaks.
// 		 One buy stock at the lowest insterest and sell the stock at the highest interest.
// 		 So, we start from recording the first valley and get the profits every buy and sell.
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int lowPointer = 1;
        int highPointer = 1;
        while (lowPointer < prices.length && highPointer < prices.length) {
            while (lowPointer < prices.length && prices[lowPointer] <= prices[lowPointer - 1]) {
                lowPointer++;
            }
            highPointer = lowPointer;
            while (highPointer < prices.length && prices[highPointer] >= prices[highPointer - 1]) {
                highPointer++;
            }
            profit += (prices[highPointer - 1] - prices[lowPointer - 1]);
            lowPointer = highPointer;
        }
        return profit;
    }
}

// Approach 2: 将所有的增长累加起来就是max收益。
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                profit += (prices[i] - prices[i - 1]);
            }
        }
        return profit;
    }
}

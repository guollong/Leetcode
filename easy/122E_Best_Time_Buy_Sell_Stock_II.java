/**
 * Question description: Say you have an array for which the ith element is the price of a given stock on day i.
 * 		Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 *		(ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple 
 * 		transactions at the same time (ie, you must sell the stock before you buy again).
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

// Approach 1: peak valley approach
// Idea: The points of interest are consecutive valleys and peaks.
// 		 One buy stock at the lowest insterest and sell the stock at the highest interest.
// 		 So, we start from recording the first valley and get the profits every buy and sell.
public class Solution {
    public int maxProfit(int[] prices) {
        int low = 0; 		// valley.
        int high = 0;		// peak.
        int max = 0;		// max profit.
        int index = 0;
        while (index < prices.length - 1) {
            while (index < prices.length - 1 && prices[index + 1] <= prices[index]) {
                index++;
            }
            low = index;
            while (index < prices.length - 1 && prices[index + 1] >= prices[index]) {
                index++;
            }
            high = index;
            max = max + prices[high] - prices[low];
        }
        return max;
    }
}

// Approach 2: 将所有的增长累加起来就是max收益。
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                max += prices[i + 1] - prices[i];
            }
        }
        return max;
    }
}
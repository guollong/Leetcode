/**
 * Question description: Say you have an array for which the ith element is the price of a given stock on day i.
 *		Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Amazon, Microsoft, Bloomberg, Uber, Facebook.
 */

/**
 * Progress...
 * Create Date: 07/07/2017
 */

// Dynamic programming: Two sequences DP.

/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(dp[i-1, jj] - prices[jj]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
public class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices.length <= 1)
            return 0;

        // if k >= length / 2, then you can make maximum number of transactions. Then the problem becomes
        // the second question of this stock series.
        if (k >= prices.length / 2) {
        	int maxPro = 0;
        	for (int i = 1; i < prices.length; i++) {
        		if (prices[i] > prices[i-1])
        			maxPro += prices[i] - prices[i-1];
        	}
        	return maxPro;
        }

        // State: dp[i, j] represents the max profit up until prices[j] using at most i transactions.
        int[][] dp = new int[k + 1][prices.length];
        
        // Function: 
        for (int i = 1; i <= k; i++) {
            int localMax = 0 - prices[0];
            for (int j = 1; j < prices.length; j++) {
                dp[i][j] = Math.max(dp[i][j-1],  prices[j] + localMax);
                localMax = Math.max(localMax, dp[i-1][j] - prices[j]);
            }
        }
        return dp[k][prices.length - 1];
    }
}



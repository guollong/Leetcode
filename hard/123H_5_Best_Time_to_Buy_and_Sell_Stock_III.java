/**
 * Question description: Say you have an array for which the ith element is the price of a given stock on day i.
 *		Design an algorithm to find the maximum profit. You may complete at most two transactions.
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

// Solution 1: The idea is similiar to question Single Number II, check it later.
public class Solution {
    public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE;
        int hold2 = Integer.MIN_VALUE;
        int release1 = 0;
        int release2 = 0;
        // Assume we only have 0 money at first, so the money we have finally will be our profit.
        // Since the release2 always bigger than release1, so need to update release2 first.
        for (int i : prices) {                               
            release2 = Math.max(release2, hold2 + i);        // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2, release1 - i);        // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1 + i);        // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1, 0 - i);               // The maximum if we've just buy  1st stock so far. 
        }
        return release2;  // Since release1 is initiated as 0, so release2 will always higher than release1.
    }
}


// Solution 2: Dynamic programming: Two sequences DP.

/**
 * dp[i, j] represents the max profit up until prices[j] using at most i transactions. 
 * dp[i, j] = max(dp[i, j-1], prices[j] - prices[jj] + dp[i-1, jj]) { jj in range of [0, j-1] }
 *          = max(dp[i, j-1], prices[j] + max(localMax, dp[i-1, j] - prices[j]))
 * dp[0, j] = 0; 0 transactions makes 0 profit
 * dp[i, 0] = 0; if there is only one price data point you can't make any transaction.
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int k = 2;
        if (prices.length <= 1) {
            return 0;
        }

        // State: dp[i, j] represents the max profit up until prices[j] using at most i transactions.
        int[][] dp = new int[k + 1][prices.length];
        
        // No need to initialization since they the first column and first row both take default values.
        // dp[i][0]: Only one data point, thus no profit.
        // dp[0][j]: No transaction proceed.
        
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




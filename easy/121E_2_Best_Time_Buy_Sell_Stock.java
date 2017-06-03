/**
 * Question description: Say you have an array for which the ith element is the price of a given stock on day i.
 * 		If you were only permitted to complete at most one transaction, design an algorithm to find the maximum profit.
 *
 * Example 1: Input: [7, 1, 5, 3, 6, 4]; Output: 5
 * Example 2: Input: [7, 6, 4, 3, 1]; Output: 0 (In this case, no transaction is done, i.e. max profit = 0.)
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: No.
 * Create Date: 03/28/2017
 * Update date: 06/03/2017
 */

// Kadane's Algorithm. (The logic to solve this problem is same as "max subarray problem" using Kadane's Algorithm. )
//  All the straight forward solution should work, but if the interviewer twists the question 
//      slightly by giving the difference array of prices, Ex: for {1, 7, 4, 11}, if he gives {0, 6, -3, 7}, 
//      you might end up being confused.
//  Here, the logic is to calculate the difference (maxCur += prices[i] - prices[i-1]) of the original array,
//      and find a contiguous subarray giving maximum profit. If the difference falls below 0, reset it to zero.
public int maxProfit(int[] prices) {
    int maxCur = 0, maxSoFar = 0;
    for(int i = 1; i < prices.length; i++) {
        maxCur = Math.max(0, maxCur += prices[i] - prices[i-1]);
        maxSoFar = Math.max(maxCur, maxSoFar);
    }
    return maxSoFar;
}

// Straight forward solution.
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

// Time limit exceeded method.
public class Solution {
    public int maxProfit(int[] prices) {
        int profit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int min = findLocalMin(prices, 0, i);
            int max = findLocalMax(prices, i, prices.length);
            profit = Math.max(profit, max - min);
        }
        return Math.max(profit, 0);   
    }
    
    private int findLocalMin(int[] prices, int start, int end) {
        int min = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            min = Math.min(min, prices[i]);
        }
        return min;
    }
    
    private int findLocalMax(int[] prices, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            max = Math.max(max, prices[i]);
        }
        return max;
    }
}



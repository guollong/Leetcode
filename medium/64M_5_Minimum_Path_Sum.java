/**
 * Question description: Given a m x n grid filled with non-negative numbers, find a path 
 *		from top left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

// Dynamic programming. Matrix DP.
public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int column = grid[0].length;
        
        // Step1: state: f[i][j]: the minimum path sum from (0, 0) to (i, j)
        int dp[][] = new int[row][column];
        
        // Step2: initialization.
        dp[0][0] = grid[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < column; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        
        // Step3: function.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        
        // Step4: result.
        return dp[row - 1][column - 1];
    }
}


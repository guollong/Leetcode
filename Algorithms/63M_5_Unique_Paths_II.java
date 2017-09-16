/**
 * Question description: Follow up for "Unique Paths": Now consider if some obstacles are 
 *		added to the grids. How many unique paths would there be?
 *
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Example: There is one obstacle in the middle of a 3x3 grid as illustrated below.
 *		[
 *		  [0,0,0],
 *		  [0,1,0],
 *		  [0,0,0]
 *		]
 * The total number of unique paths is 2.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg.
 */

/**
 * Progress...
 * Create Date: 07/12/2017
 * Update Date: 09/16/2017
 */

// Dynamic programming. Matrix DP.
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // corner case.
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }
        
        // Initialization.
        int row = obstacleGrid.length;
        int column = obstacleGrid[0].length;
        int[][] dp = new int[row][column];
        int index = 0;
        while (index < row && obstacleGrid[index][0] == 0) {
            dp[index][0] = 1;
            index++;
        }
        index = 0;
        while (index < column && obstacleGrid[0][index] == 0) {
            dp[0][index] = 1;
            index++;
        }
        
        // Function.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        
        return dp[row - 1][column - 1];
    }
}


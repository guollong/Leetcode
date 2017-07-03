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

// Dynamic programming. Matrix DP.

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // Step1: state: f[i][j] represents for the number of unique path from start to (i, j).
        int row = obstacleGrid.length;
        if (row == 0) {
            return 0;
        }
        int column = obstacleGrid[row- 1].length;  
        int[][] paths = new int[row][column];
        
        // Step2: Initialization.
        for (int i = 0; i < row; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            paths[i][0] = 1;
        }
        for (int j = 0; j < column; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            paths[0][j] = 1;
        }
        
        // Step3: function.
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < column; j++) {
                if (obstacleGrid[i][j] == 1) {
                    paths[i][j] = 0;
                } else {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        
        // Step4: result.
        return paths[row - 1][column - 1];
    }
}


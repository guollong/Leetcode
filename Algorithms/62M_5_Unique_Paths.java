/**
 * Question description: A robot is located at the top-left corner of a m x n grid. The robot 
 *		can only move either down or right at any point in time. The robot is trying to reach 
 *		the bottom-right corner of the grid (marked 'Finish' in the diagram below). How many 
 *		possible unique paths are there?
 *
 * Note: m and n will be at most 100.
 *
 * Follow up: Question 63: If the grid has obstacles. 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg.
 */

// Dynamic programming. Matrix DP.

public class Solution {
    public int uniquePaths(int m, int n) {
        // Step1: state: f[i][j] represents for the number of unique path from start to (i, j).
        int[][] paths = new int[m][n];
        
        // Step2: Initialization.
        for (int i = 0; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            paths[0][j] = 1;
        }
        
        // Step3: function.
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        
        // Step4: result.
        return paths[m - 1][n - 1];
    }
}


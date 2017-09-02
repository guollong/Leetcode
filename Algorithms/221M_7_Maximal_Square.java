/**
 * Question description: Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
 * 
 * Example, given the following matrix:
 *	1 0 1 0 0
 *	1 0 1 1 1
 *	1 1 1 1 1
 *	1 0 0 1 0
 * Return 4. 
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Apple, Airbnb, Facebook.
 */

/**
 * Progress...
 * Create Date: 09/01/2017
 */

// Solution 1: Brute force method.
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        int maxSide = 1;
        boolean allZeros = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == '1') {
                    allZeros = false;
                    int maxSideTemp = Math.min(row - i, column - j);
                    for (int side = maxSide; side <= maxSideTemp; side++) {
                        if (isSquare(matrix, i, j, side)) {
                            maxSide = Math.max(maxSide, side);
                        }
                    }
                }
            }
        }
        return allZeros ? 0 : maxSide * maxSide;
    }
    
    private boolean isSquare(char[][] matrix, int i, int j, int side) {
        for (int m = i; m < i + side; m++) {
            for (int n = j; n < j + side; n++) {
                if (matrix[m][n] == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}


// Solution 2: Dynamic programming: 
//		dp[i][j]: the side length of the maximum square whose bottom right corner is the cell with
//   	index (i, j) in the original matrix.
// Running time complexity: O(m * n)
// Space Complexity: O(m * n)
class Solution {
    // 
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        
        // Initialization.
        int maxSide = 0;
        int row = matrix.length;
        int column = matrix[0].length;
        int[][] dp = new int[row + 1][column + 1];
        
        // Function: dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j], dp[i][j - 1]) + 1
        for (int i = 1; i < row + 1; i++) {
            for (int j = 1; j < column + 1; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}






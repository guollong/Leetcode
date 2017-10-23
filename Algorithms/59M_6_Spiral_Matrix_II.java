/**
 * Question description: Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * 
 * Example: Given n = 3, you will return the following matrix:
 *	[
 *	 [ 1, 2, 3 ],
 *	 [ 4, 5, 6 ],
 *	 [ 7, 8, 9 ]
 *	]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Google, Uber.
 */

/**
 * Progress...
 * Create Date: 08/23/2017
 * Update Date: 10/23/2017
 */

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        if (n == 0) {
            return result;
        }
        
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int index = 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse right.
            for (int j = colBegin; j <= colEnd; j++) {
                result[rowBegin][j] = index++;
            }
            rowBegin++;
            
            // Traverse down.
            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = index++;
            }
            colEnd--;
            
            // Traverse left.
            if (rowBegin <= rowEnd) {
                for (int j = colEnd; j >= colBegin; j--) {
                    result[rowEnd][j] = index++;
                }
            }
            rowEnd--;
            
            // Traverse up.
            if (colBegin <= colEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[i][colBegin] = index++;
                }
            }
            colBegin++;
        }
        return result;
    }
}



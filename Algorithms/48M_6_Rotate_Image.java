/**
 * Question description: You are given an n x n 2D matrix representing an image. Rotate the image by 90 degrees (clockwise).
 *
 * Follow up: Could you do this in-place?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Apple.
 */

/**
 * Progress...
 * Create Date: 08/23/2017
 */

// Clockwise rotation: Flip the matrix based on diagonal and then the middle column;
// AntiClockwise rotation: Flip the matrix based on anti-diagonal and then the middle column.
class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int column = matrix[0].length;
        
        // flip the matrix symmetrically based on diagonal.
        // Attention: Only loop half of the matrix to swap, otherwise, if loop over the whole matrix, 
        //            the matrix will return to the original one.
        for (int i = 0; i < row; i++) {
            for (int j = i + 1; j < column; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        
        // flip the matrix based on middle column;
        for (int j = 0; j < column / 2; j++) {
            for (int i = 0; i < row; i++) {
                swap(matrix, i, j, i, column - j - 1);
            }
        }
    }
    
    private void swap(int[][] matrix, int row1, int column1, int row2, int column2) {
        int temp = matrix[row1][column1];
        matrix[row1][column1] = matrix[row2][column2];
        matrix[row2][column2] = temp;
    }
}


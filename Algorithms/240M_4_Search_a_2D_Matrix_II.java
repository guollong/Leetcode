/**
 * Question description: Write an efficient algorithm that searches for a value in an m x n matrix. 
 *		This matrix has the following properties:
 * 			Integers in each row are sorted in ascending from left to right.
 *			Integers in each column are sorted in ascending from top to bottom.
 *
 * Example: Consider the following matrix:
 *		[
 *		  [1,   4,  7, 11, 15],
 *		  [2,   5,  8, 12, 19],
 *		  [3,   6,  9, 16, 22],
 *		  [10, 13, 14, 17, 24],
 *		  [18, 21, 23, 26, 30]
 *		]
 *	Given target = 5, return true.
 *	Given target = 20, return false.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Google, Apple.
 */

/**
 * Progress...
 * Create Date: 06/25/2017
 */

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length - 1;
        int column = 0;
        while (row >= 0 && column < matrix[0].length) {
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                column++;
            } else {
                row--;
            }
        }
        return false;
    }
}


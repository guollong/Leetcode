/**
 * Question description: Write an efficient algorithm that searches for a value in an m x n matrix. 
 *		This matrix has the following properties:
 * 			Integers in each row are sorted from left to right.
 *			The first integer of each row is greater than the last integer of the previous row.
 *
 * Example: Consider the following matrix:
 *		[
 *		  [1,   3,  5,  7],
 *		  [10, 11, 16, 20],
 *		  [23, 30, 34, 50]
 *		]
 *	Given target = 3, return true.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/25/2017
 */

// Treat this 2d matrix as a 1d sorted matrix.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int start = 0;
        int end = matrix.length * matrix[0].length - 1;
        int mid = 0;
        int row = 0;
        int column = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            row = mid / matrix[0].length;
            column = mid % matrix[0].length;
            if (matrix[row][column] == target) {
                return true;
            } else if (matrix[row][column] < target) {
                start = mid + 1;
            } else {
                end = end - 1;
            }
        }
        return false;
    }
}

// Another complex solution: first find the row and get the column of the target.
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // find the last element in the first column that smaller than target.
        int startRow = 0;
        int endRow = matrix.length - 1;
        int midRow = 0;
        while (startRow + 1 < endRow) {
            midRow = startRow + (endRow - startRow) / 2;
            if (matrix[midRow][0] == target) {
                return true;
            } else if (matrix[midRow][0] > target) {
                endRow = midRow - 1;
            } else {
                startRow = midRow;
            }
        }
        int row = 0;
        if (matrix[endRow][0] == target) {
            return true;
        } else if (matrix[endRow][0] < target) {
            row = endRow;
        } else {
            row = startRow;
        }
        System.out.println(row);
        
        int startColumn = 0;
        int endColumn = matrix[0].length - 1;
        int midColumn = 0;
        while (startColumn <= endColumn) {
            midColumn = startColumn + (endColumn - startColumn) / 2;
            if (matrix[row][midColumn] == target) {
                return true;
            } else if (matrix[row][midColumn] > target) {
                endColumn = midColumn - 1;
            } else {
                startColumn = midColumn + 1;
            }
        }
        return false;
    }
}


/**
 * Question description: Given a matrix represented by a two-dimensional array, and two 
 * 		positive integers r and c representing the row number and column number of the 
 *		wanted reshaped matrix, respectively.
 *
 * 		If the 'reshape' operation with given parameters is possible and legal, output 
 *		the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Example: 
 * Input: nums = [[1,2],
 *		   		  [3,4]]; r = 1, c = 4
 * Output: [[1,2,3,4]]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

// Idea: If the input arguments are illegal, return original array.
// 		For each element(totally r * c elements), get the corresponding row and column
// 			in original array and output array.
public class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int row = nums.length;
        int column = nums[0].length;
        if (r * c != row * column) {
            return nums;
        }

        int[][] res = new int[r][c];
        int rowOri = 0, columnOri = 0, rowRes = 0, columnRes = 0;
        for (int i = 0; i < r * c; i++) {
            rowOri = i / column;
            columnOri = i % column;
            rowRes = i / c;
            columnRes = i % c;
            res[rowRes][columnRes] = nums[rowOri][columnOri];
        }
        return res;
    }
}





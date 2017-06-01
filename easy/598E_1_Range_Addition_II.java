/**
 * Question description: Given an m * n matrix M initialized with all 0's and several update operations.
 *		Operations are represented by a 2D array, and each operation is represented by an array with two 
 *		positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.
 *
 *		You need to count and return the number of maximum integers in the matrix after performing all the operations.
 *
 * Example: Input: m = 3, n = 3, operations = [[2,2],[3,3]]; Output: 4
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

public class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int minCol1 = m;
        int minCol2 = n;
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][0] < minCol1) {
                minCol1 = ops[i][0];
            }
        }
        for (int i = 0; i < ops.length; i++) {
            if (ops[i][1] < minCol2) {
                minCol2 = ops[i][1];
            }
        }
        return minCol1 * minCol2;
    }
}

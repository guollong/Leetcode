/**
 * Question description: Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 * 
 * Follow up: Did you use extra space?
 * 		A straight forward solution using O(mn) space is probably a bad idea.
 *		A simple improvement uses O(m + n) space, but still not the best solution.
 *		Could you devise a constant space solution?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Amazon.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

// Solution 1: Use constant space.
class Solution {
    public void setZeroes(int[][] matrix) {
        // corner case.
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        // Since the state of row0 and column0 will overlap, so create another variable indicating the state 
        //      of the column0, and leave the matrix[0][0] represents for the state of row0.
        int col0 = 1;       
        
        
        // First phase: use matrix elements to set states in a top-down way.
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
            }
            for (int j = 1; j < column; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        // Second phase: use states to set matrix elements in a bottom-up way.
        for (int i = row - 1; i >= 0; i--) {
            for (int j = column - 1; j >= 1; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) {
                matrix[i][0] = 0;
            }
        }
    }
}

// Solution 2: Brute force method with the time complexity O(row * column) and the space complexity O(row + column).
class Solution {
    public void setZeroes(int[][] matrix) {
        // corner case.
        if (matrix == null || matrix.length == 0) {
            return;
        }
        
        // Initialization.
        int row = matrix.length;
        int column = matrix[0].length;
        // Two sets: rows and columns that don't need to set to 0.
        Set<Integer> indicesR = new HashSet<>();
        for (int i = 0; i < row; i++) {
            indicesR.add(i);
        }
        Set<Integer> indicesC = new HashSet<>();
        for (int i = 0; i < column; i++) {
            indicesC.add(i);
        }
        
        // Remove indices that should be set to 0 from two sets.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (matrix[i][j] == 0) {
                    if (indicesR.contains(i)) {
                        indicesR.remove(i);
                    }
                    if (indicesC.contains(j)) {
                        indicesC.remove(j);
                    }
                }
            }
            if (indicesR.size() == 0 && indicesC.size() == 0) {
                break;
            }
        }
        
        // Set required elements in matrix to be 0.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (indicesR.contains(i) && indicesC.contains(j)) {
                    continue;
                }
                matrix[i][j] = 0;
            }
        }
    }
}

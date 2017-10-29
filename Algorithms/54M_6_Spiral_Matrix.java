/**
 * Question description: Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 * 
 * Example: Given the following matrix:
 *	[
 *	 [ 1, 2, 3 ],
 *	 [ 4, 5, 6 ],
 *	 [ 7, 8, 9 ]
 *	]
 * You should return [1,2,3,6,9,8,7,4,5].
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


// Solution 1: Simpler version from discussion.
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> res = new ArrayList<Integer>();
        
        if (matrix.length == 0) {
            return res;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length - 1;
        
        while (rowBegin <= rowEnd && colBegin <= colEnd) {
            // Traverse Right.
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            
            // Traverse Down.
            for (int j = rowBegin; j <= rowEnd; j ++) {
                res.add(matrix[j][colEnd]);
            }
            colEnd--;
            
            if (rowBegin <= rowEnd) {
                // Traverse Left.
                for (int j = colEnd; j >= colBegin; j --) {
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            
            if (colBegin <= colEnd) {
                // Traver Up.
                for (int j = rowEnd; j >= rowBegin; j --) {
                    res.add(matrix[j][colBegin]);
                }
                colBegin++;
            }
        }
        
        return res;
    }
}


// Solution 2: My own solution: need to check if the parser needs to go up or not.
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        // corner case.
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int row = matrix.length;
        int column = matrix[0].length;
        
        boolean[][] visited = new boolean[row][column];
        boolean needGoUp = false;
        
        int i = 0;
        int j = 0;
        // We assume parser needs to go right, down, left and up. However, while the parser goes up, 
        //      we could only go up or right.
        while (!visited[i][j] && (i == 0 || i == row - 1 || j == 0 || j == column - 1 || 
                                  !visited[i][j + 1] || !visited[i + 1][j] || !visited[i][j - 1] || !visited[i - 1][j])) {
            result.add(matrix[i][j]);
            visited[i][j] = true;
            
            if (needGoUp && i - 1 >= 0 && visited[i - 1][j]) {  // set needGoUp to false when there is no way to go up.
                needGoUp = false;
            }
            
            if (!needGoUp && j + 1 < column && !visited[i][j + 1]) {    // go right.
                j = j + 1;
                continue;
            }
            if (!needGoUp && i + 1 < row && !visited[i + 1][j]) {       // go down.
                i = i + 1;
                continue;
            }
            if (!needGoUp && j - 1 >= 0 && !visited[i][j - 1]) {        // go left.
                j = j - 1;
                continue;
            }
            if (i - 1 >= 0 && !visited[i - 1][j]) {                     // go up.
                i = i - 1;
                needGoUp = true;
                continue;
            }
        }
        if (i != 0 && j != 0) {
            result.add(matrix[i][j]);
        }
        return result;
    }
}







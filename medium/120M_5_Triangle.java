/**
 * Question description: Given a triangle, find the minimum path sum from top to bottom. 
 *		Each step you may move to adjacent numbers on the row below.
 *
 * Example, given the following triangle
 *		[
 *		     [2],
 *		    [3,4],
 *		   [6,5,7],
 *		  [4,1,8,3]
 *		]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note: Bonus point if you are able to do this using only O(n) extra space, where n is the 
 *		 total number of rows in the triangle.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/03/2017
 */

// Dynamic programming: Matrix DP.

// Solution 1: Top-down 2D dp array Dynamic programming.
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Step 1: state: f[i][j]: The minimum path sum from (0, 0) to (i, j).
        int row = triangle.size();
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[row + 1][triangle.get(row - 1).size() + 1];
        
        // Step 2: initialization.
        dp[0][0] = triangle.get(0).get(0);

        // Step 3: function.
        for (int i = 1; i < row; i++) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                // The path could from (j)th element and (j-1)th element of last level.
                if (j >= 1 && j < triangle.get(i - 1).size()) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + curr.get(j);
                } else if (j < 1) {
                    // The path could only from (j)th element of last level.
                    dp[i][j] = dp[i - 1][j] + curr.get(j);
                } else {
                    // The path could only from (j - 1)th element of last level.
                    dp[i][j] = dp[i - 1][j - 1] + curr.get(j);
                }
            }
        }
        
        // Step 4: result.
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < triangle.get(row - 1).size(); j++) {
            min = Math.min(min, dp[row - 1][j]);
        }
        return min;
    }
}

// Solution 2: Bottom-up 2D dp array Dynamic programming.
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Step 1: state: f[i][j]: The minimum path sum from bottom to (i, j).
        int row = triangle.size();
        if (triangle.size() == 0) {
            return 0;
        }
        int[][] dp = new int[row][triangle.get(row - 1).size()];
        
        // Step 2: initialization.
        List<Integer> lastRow = triangle.get(row - 1);
        for (int j = 0; j < triangle.get(row - 1).size(); j++) {
            dp[row - 1][j] = lastRow.get(j);
        }

        // Step 3: function.
        for (int i = row -2; i >= 0; i--) {
            List<Integer> curr = triangle.get(i);
            for (int j = 0; j < curr.size(); j++) {
                dp[i][j] = curr.get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        
        // Step 4: result.
        return dp[0][0];
    }
}


// Solution 3: Bottom-up 1D dp array Dynamic programming.
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Create a dp array with size + 1.
        int[] A = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                A[j] = Math.min(A[j], A[j+1]) + triangle.get(i).get(j);
            }
        }
        return A[0];
    }
}



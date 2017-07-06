/**
 * Question description: Given two words word1 and word2, find the minimum number of steps required 
 *		to convert word1 to word2. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 *		a) Insert a character
 * 		b) Delete a character
 *		c) Replace a character
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 07/05/2017
 */

public class Solution {
    // Dynamic programming: Two sequences DP.
    // Three operations: insertion, deletion and replacement.
    public int minDistance(String word1, String word2) {
        // State: dp[i][j]: The minimum number of steps required to convert word1(the previous i characters) to word2(the previous j characters)
        int[][] minSteps = new int[word1.length() + 1][word2.length() + 1];
        
        // Intialization.
        for (int i = 0; i <= word1.length(); i++) {
            minSteps[i][0] = i;
        }
        for (int j = 0; j <= word2.length(); j++) {
            minSteps[0][j] = j;
        }
        
        // Three operations: insertion, deletion and replacement.
        // Function: dp[i][j]
        // If word1.charAt(i) == word2.charAt(j), could apply nothing or insertion or deletion.
        //      dp[i][j] = min(dp[i - 1][j - 1], dp[i - 1][j] + 1, dp[i][j - 1] + 1);
        // If word1.charAt(i) != word2.charAt(j), apply one of the three operations.
        //      dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1;
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    minSteps[i][j] = Math.min(minSteps[i - 1][j - 1], Math.min(minSteps[i][j - 1], minSteps[i - 1][j]) + 1);
                } else {
                    minSteps[i][j] = Math.min(minSteps[i - 1][j - 1], Math.min(minSteps[i][j - 1], minSteps[i - 1][j])) + 1;
                }
            }
        }
        
        return minSteps[word1.length()][word2.length()];
    }
}






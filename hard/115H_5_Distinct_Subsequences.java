/**
 * Question description: Given a string S and a string T, count the number of distinct subsequences of S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original string by deleting some 
 *		(can be none) of the characters without disturbing the relative positions of the remaining characters. 
 *		(ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 *
 * Example: S = "rabbbit", T = "rabbit", Return 3.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/06/2017
 */

// Dynamic programming: Two sequences DP.
public class Solution {
    public int numDistinct(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return 0;
        }
        // State. dp[i][j]: The number of distinct subsequences of s.substring(0, i + 1) which equals t.substring(0, j + 1);
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        
        // Initialization.
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        
        // Function. f[i][j]
        // If s.charAt(i) == s.charAt(j), f[i][j] = f[i - 1][ j - 1] + f[i - 1][j].
        // If s.charAt(i) != s.charAt(j), f[i][j] = f[i - 1][j].
        // t的第j个字符永远不可能扔掉。
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
}




/**
 * Question description: Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 *
 * Example: Given: s1 = "aabcc", s2 = "dbbca",
 *		When s3 = "aadbbcbcac", return true.
 *		When s3 = "aadbbbaccc", return false.
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
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        
        // State: dp[i][j]: whether s3(0 ~ i + j) is formed by the interleaving of s1 (0 ~ i) and s2 (0 ~ j).
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        
        // Initialization.
        dp[0][0] = true;
        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }
        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }
        
        // Function: f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || 
                    (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        
        return dp[s1.length()][s2.length()];
    }
}


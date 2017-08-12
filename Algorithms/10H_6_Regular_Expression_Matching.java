/**
 * Question description: Implement regular expression matching with support for '.' and '*'.
 *		'.' Matches any single character.
 *		'*' Matches zero or more of the preceding element.
 * 		The matching should cover the entire input string (not partial).
 * 
 * Examples:
 *	isMatch("aa","a") ? false
 *	isMatch("aa","aa") ? true
 *	isMatch("aaa","aa") ? false
 *	isMatch("aa", "a*") ? true
 *	isMatch("aa", ".*") ? true
 *	isMatch("ab", ".*") ? true
 *	isMatch("aab", "c*a*b") ? true
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google, Uber, Airbnb, Facebook, Twitter.
 */

/**
 * Progress...
 * Create Date: 08/11/2017
 */

// Dynamic programming.
public class Solution {
    public boolean isMatch(String s, String p) {
        // Corner case:
        if (s == null || p == null) {
            return false;
        }
        
        // State: dp[i][j]: if s.substirng(0, i) and substring(0, j) is a match.
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        
        // Intialization. Why initialize the dp array like this ?? 
        // i = 0: take nothing from s (s.substring == empty)
        dp[0][0] = true;
        // special example: s = "aab", p = "c*a*b", return true;
        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        // Function.
        // 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
        // 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
        // 3, If p.charAt(j) == '*': 
        //     here are two sub conditions:
        //        1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
        //        2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
        //                       dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
        //                    or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
        //                    or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                } else if (p.charAt(j) == '*') {
                    if (s.charAt(i) != p.charAt(j - 1) && p.charAt(j - 1) != '.') {
                        // a* count as empty.
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        // dp[i + 1][j]: a* counts as single a.
                        // dp[i + 1][j - 1]: a* counts as empty.
                        // dp[i][j + 1]: a* counts as multiple a.
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}





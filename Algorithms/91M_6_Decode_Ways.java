/**
 * Question description: A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 		'A' -> 1
 * 		'B' -> 2
 * 		...
 * 		'Z' -> 26
 * Given an encoded message containing digits, determine the total number of ways to decode it.
 * 
 * Example: Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
 *		The number of ways decoding "12" is 2.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Uber, Facebook.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

// Dynamic programming. 
class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // State: dp[i]: the total number of ways to decode s.substring(i);
        // Initialization: dp[n] = 1; dp[n - 1] = c == '0' ? 0 : 1;
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        dp[s.length() - 1] = s.charAt(s.length() - 1) != '0' ? 1 : 0;
        
        // Function: s.substring(i, i + 2)) <= 26: s.charAt(i) could be treated as single number (dp[i + 1]), 
        //      and also could form an two-digit number with its previous number (dp[i + 2]). However, when
        //      s.substring(i, i + 2)) > 26, s.charAt(i) could only be treated as single number (dp[i + 1]).
        for (int i = s.length() - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                continue;
            } else {
                dp[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? dp[i + 1] + dp[i + 2] : dp[i + 1];
            }
        }
        
        return dp[0];
    }
}





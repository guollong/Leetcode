/**
 * Question description: Given a string s, partition s such that every substring of the partition is a palindrome.
 *		Return the minimum cuts needed for a palindrome partitioning of s.
 *
 * Example, given s = "aab", Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 07/04/2017
 */


// Dynamic programming: Sequence DP.
public class Solution {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        // prepartition. Check isPalindrome for substrings ahead.
        boolean[][] isPalindrome = getIsPalindrome(s);
            
        // Step1 & 2: state and initialization: f[i]: The minimum cuts needed for a substring of s from 0 to i.(the number of substrings - 1)
        int[] dp = new int[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            dp[i] = i - 1;
        }
        
        // Step3: function. f[i] = MIN{f[j]+1}, j < i && substring(j + 1, i) is a palindrome.
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                // If I check isPalindrome using function here, the time complexity will
                // be O(n^3). So I could precompute the isPalindrome using O(n^2) time and 
                // access it using O(1) time. The overall time complexity will be O(n^2).
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        
        // Step4: result.
        return dp[s.length()];
    }
    
    // Dynamic programming again. 
    private boolean[][] getIsPalindrome(String s) {
        // Step1: state: isPalindrome.
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        
        // Step2: Initialization.
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        
        // Step3: function. f[i][j] = f[i + 1][j- 1] && s.charAt(i) == s.charAt(j).
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length] = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isPalindrome;
    }
}




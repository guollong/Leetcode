/**
 * Question description: Write a program to find the n-th ugly number. Ugly numbers are positive numbers 
 *		whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the 
 *		sequence of the first 10 ugly numbers.
 * 
 * Note: 1 is typically treated as an ugly number, and n does not exceed 1690.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 09/01/2017
 */

// Dynamic programming:
// Idea: Every subsequence is the ugly-sequence itself (1, 2, 3, 4, 5, …) multiply 2, 3, 5.
// (1) 1×2, 2×2, 3×2, 4×2, 5×2, …
// (2) 1×3, 2×3, 3×3, 4×3, 5×3, …
// (3) 1×5, 2×5, 3×5, 4×5, 5×5, …
// So we use similar merge method as merge sort, to get every ugly number from the three subsequence.
class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        int pointer1 = 0;   // the pointer of '2'.
        int pointer2 = 0;   // the pointer of '3'.
        int pointer3 = 0;   // the pointer of '5'.
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(dp[pointer1] * 2, Math.min(dp[pointer2] * 3, dp[pointer3] * 5));
            if (dp[i] == dp[pointer1] * 2) {
                pointer1++;
            }
            if (dp[i] == dp[pointer2] * 3) {
                pointer2++;
            }
            if (dp[i] == dp[pointer3] * 5) {
                pointer3++;
            }
        }
        return dp[n - 1];
    }
}


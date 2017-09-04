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
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 09/02/2017
 */

// Solution 1: The same idea with ugly number II.
// Running time complexity: O(K * N).
class Solution {
    // merge sort of k arrays. (k is the number of primes)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n];
        int[] pointers = new int[primes.length];
        
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                min = Math.min(min, dp[pointers[j]] * primes[j]);
            }
            dp[i] = min;
            
            for (int j = 0; j < primes.length; j++) {
                if (min == dp[pointers[j]] * primes[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n - 1];
    }
}

// Solution 2: 







/**
 * Question description: Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/07/2017
 */

public class Solution {
    // All trailing 0 is from factors 5 * 2. In the n! operation, factors 2 is always ample. 
    // So we just count how many 5 factors in all number from 1 to n.
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}


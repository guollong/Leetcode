/**
 * Question description: Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive.
 * 
 * Example: given the range [5, 7], you should return 4.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: . 
 */

/**
 * Progress...
 * Create Date: 08/31/2017
 */


// Bit manipulation: use a mask to find the leftmost common digits of m and n, that would be the answer.
class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int mask = Integer.MAX_VALUE;
        while ((m & mask) != (n & mask)) {
            mask <<= 1;
        }
        return m & mask;
    }
}


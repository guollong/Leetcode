/**
 * Question description: Given an integer, write a function to determine if it is a power of two.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 03/28/2017
 * Update date: 06/02/2017
 */

// Be careful of the negative values and 0;
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        int temp = n;
        while ((temp & 1) != 1) {
            temp = temp >> 1;
        }
        return temp == 1;
    }
}

// solution from discussion.
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}


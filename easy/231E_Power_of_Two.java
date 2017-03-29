/**
 * Question description: Given an integer, write a function to determine if it is a power of two.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

// solution from discussion.
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n>0 && Integer.bitCount(n) == 1;
    }
}

// Jinglong's loop solution.
public class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int temp = n;
        while (temp != 1) {
            if (temp % 2 != 0) {
                return false;
            }
            temp = temp >> 1;
        }
        return true;
    }
}


/**
 * Question description: Given an integer, write a function to determine if it is a power of three.
 * Follow up: Could you do it without using any loop / recursion?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 * Create Date: 03/28/2017
 * Update date: 06/03/2017
 */

// iterative method.
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        int temp = n;
        while (temp % 3 == 0) {
            temp /= 3;
        }
        return temp == 1;
    }
}

// recursive method.
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n == 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        if (n % 3 != 0) {
            return false;
        }
        return isPowerOfThree(n / 3);
    }
}

// No loop no recursion. Method 1: 
// 3^20 exceeds the scope of an integer.
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n > 0 && Math.pow(3, 19) % n == 0;
    }
}

// No loop no recursion. Method 2: 
// If N is a power of 3: X == (log N) / (log 3)
// However, the fact is that log(3) cannot be precisely represented on a binary computer;
public class Solution {
    public boolean isPowerOfThree(int n) {
        return n == 0 ? false : n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}









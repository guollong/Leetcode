/**
 * Question description: Given an integer, write a function to determine if it is a power of three.
 * Follow up: Could you do it without using any loop / recursion?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

// loop method.
// Discussion 中有很多不用loop实现的方法。。。。现在不想看呢
public class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        int temp = n;
        while (temp != 1) {
            if (temp % 3 != 0) {
                return false;
            } 
            temp = temp / 3;
        }
        return true;
    }
}
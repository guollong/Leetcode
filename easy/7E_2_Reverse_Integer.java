/**
 * Question description: Reverse digits of an integer.
 * 
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Notes: Consider if the integer's last digit is 0, what should the output be?
 * 		Did you notice that the reversed integer might overflow? return 0 when the reverse digits overflow.
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
    public int reverse(int x) {
        int y1 = reverseHelper(x);
        int y2 = reverseHelper(y1);
        if (x != y2 && x % 10 != 0) {
            return 0;
        }
        return y1;
    }
    
    private int reverseHelper(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 0;
        int temp = Math.abs(x);
        int remainder = 0;
        while (temp % 10 == 0) {
            temp /= 10;
        }
        while (temp != 0) {
            remainder = temp % 10;
            result = result * 10 + remainder;
            temp /= 10;
        }
        if (x < 0) {
            return -result;
        }
        return result;
    }
}




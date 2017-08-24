/**
 * Question description: Implement pow(x, n).
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn, Google, Bloomberg, Facebook.
 */

/**
 * Progress...
 * Create Date: 08/23/2017
 */

// Binary search. 
class Solution {
    public double myPow(double x, int n) {
        double result = 1;
        int sign = n > 0 ? 1 : -1;
        n = Math.abs(n);
        
        while (n != 0) {
            int count = 1;
            double multipler = x;
            while (n - count>= 0) {
                result *= multipler;
                n = n - count;
                multipler = multipler * multipler;
                count = 2 * count;
            }
        }
        if (sign == 1) {
            return result;
        }
        return 1 / result;
    }
}


/**
 * Question description: We define the Perfect Number is a positive integer that is equal to 
 *		the sum of all its positive divisors except itself.
 *		Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 *
 * Example: Input: 28; Output: True; Explanation: 28 = 1 + 2 + 4 + 7 + 14
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Fallible.
 */

/**
 * Progress...
 * Create Date: 06/10/2017
 */

public class Solution {
    public boolean checkPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }
        int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                sum = sum + i + num / i;
            }
        }
        return sum == num;
    }
}


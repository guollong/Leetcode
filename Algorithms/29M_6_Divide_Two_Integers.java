/**
 * Question description: Divide two integers without using multiplication, division and mod operator.
 * 
 * If it is overflow, return MAX_INT.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 08/22/2017
 */

// Not allowed to use division, multiplication and mod operations. So bit manipulation.
class Solution {
    public int divide(int dividend, int divisor) {
        // Integer.MAX_VALUE + 1 = abs(Integer.MIN_VALUE).
        // Overflow.
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        
        // get the sign.
        int sign = (dividend < 0) ^ (divisor < 0) ? -1 : 1;
        
        // subtract divisor from dividend. Using binary search (<<) to determine how many divisors should be subtracted.
        // Why we need convert the type to long ????
        long dividendAbs = Math.abs((long)dividend);
        long divisorAbs = Math.abs((long)divisor);
        int quotient = 0;

        while (dividendAbs >= divisorAbs) {
            long subtractor = divisorAbs;
            long multiple = 1;
            while (dividendAbs >= (subtractor << 1)) {
                subtractor <<= 1;
                multiple <<= 1;
            }
            dividendAbs -= subtractor;
            quotient += multiple;
        }
        return sign * quotient;
    }
}




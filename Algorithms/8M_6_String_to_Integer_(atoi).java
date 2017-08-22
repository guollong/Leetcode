/**
 * Question description: Implement atoi to convert a string to an integer.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg, Uber.
 */

/**
 * Progress...
 * Create Date: 08/21/2017
 */

// 4 cases to handle: 
//  1. white spaces in front of the string.
//  2. sign: '+' and '-'.
//  3. non-number characters.
//  4. number out of range.
class Solution {
    public int myAtoi(String str) {
        int index = 0;
        int sign = 1;
        int total = 0;
        str = str.trim();

        // Empty string.
        if (str.length() == 0) {
            return 0;
        }

        // Handle signs: assume the string only has one sign, either '+' or '-'.
        if (str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        // Convert number and avoid overflow.
        while (index < str.length()){
            int digit = str.charAt(index) - '0';
            // If the character is not a number.
            if (digit < 0 || digit > 9) {
                break;
            }

            // Check if total will be overflow after 10 times and add digit.
            if (Integer.MAX_VALUE / 10 < total || (Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            total = 10 * total + digit;
            index++;
        }
        return total * sign;
    }
}



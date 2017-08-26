/**
 * Question description: Given two integers representing the numerator and denominator of a fraction, return the 
 *		fraction in string format.
 * 
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * 
 * Example: Given numerator = 1, denominator = 2, return "0.5".
 *		Given numerator = 2, denominator = 1, return "2".
 *		Given numerator = 2, denominator = 3, return "0.(6)".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google. 
 */

/**
 * Progress...
 * Create Date: 08/25/2017
 */

// Three special cases: 
//      1. Negative number.
//      2. When the quotient is an integer.
//      3. When the fractional part of quotient is repeating.
class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        
        StringBuilder result = new StringBuilder();
        // get the sign of the quotient.
        if ((numerator > 0) ^ (denominator > 0)) {
            result.append("-");
        }
        long num = Math.abs((long) numerator);  // must convert to long first.
        long den = Math.abs((long) denominator);
        
        // integral part.
        result.append(num / den);
        num %= den;
        if (num == 0) {
            return result.toString();
        }

        // fractional part.
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());
        while (num != 0) {
            num *= 10;
            result.append(num / den);
            num %= den;
            if (map.containsKey(num)) {
                int index = map.get(num);
                result.insert(index, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }
        return result.toString();
    }
}



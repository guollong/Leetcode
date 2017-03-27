/**
 * Question description: Given an integer, return its base 7 string representation.
 *
 * Example 1: Input: 100; Output: "202"
 * Example 2: Input: -7; Output: "-10"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

// 注意事项：corner case： num为0, 考虑正负数。
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder base7 = new StringBuilder();
        boolean isPositive = true;
        if (num < 0) {
            isPositive = false;
            num = -num;
        }
        int temp = num;
        int quotient = num;
        int remainder = num;

        while (temp != 0) {
            quotient = temp / 7;
            remainder = temp % 7;
            base7.append(remainder);
            temp = quotient;
        }
        if (isPositive) {
            return base7.reverse().toString();
        } else {
            base7.append('-');
            return base7.reverse().toString();
        }
    }
}


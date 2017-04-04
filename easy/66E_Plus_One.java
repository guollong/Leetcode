/**
 * Question description: Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * 		You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 		The digits are stored such that the most significant digit is at the head of the list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 04/03/2017
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        int carry = 0;
        if (digits[length - 1] == 9) {
            digits[length - 1] = 0;
            carry = 1;
        } else {
            digits[length - 1] = digits[length - 1] + 1;
        }
        for (int i = length - 2; i >= 0; i--) {
            if (digits[i] + carry > 9) {
                digits[i] = (digits[i] + carry) % 10;
                carry = 1;
            } else {
                digits[i] = digits[i] + carry;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] result = new int[length + 1];
            result[0] = 1;
            for (int i = 0; i < length; i++) {
                result[i+1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}

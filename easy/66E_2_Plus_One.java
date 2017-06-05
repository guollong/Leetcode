/**
 * Question description: Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * 		You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 		The digits are stored such that the most significant digit is at the head of the list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 04/03/2017
 * Update date: 06/05/2017
 */

public class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        if (digits[digits.length - 1] == 9) {
            digits[digits.length - 1] = 0;
            carry = 1;
        } else {
            digits[digits.length - 1]++;
            return digits;
        }
        for (int i = digits.length - 2; i >= 0; i--) {
            int sum = digits[i] + carry;
            if (sum == 10) {
                digits[i] = 0;
                carry = 1;
            } else {
                digits[i] = sum;
                carry = 0;
            }
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}


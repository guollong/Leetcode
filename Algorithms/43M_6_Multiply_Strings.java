/**
 * Question description: Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2.
 * 
 * Note: The length of both num1 and num2 is < 110.
 *	  Both num1 and num2 contains only digits 0-9.
 *	  Both num1 and num2 does not contain any leading zero.
 *	  You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Facebook, Twitter.
 */

/**
 * Progress...
 * Create Date: 08/23/2017
 */

class Solution {
    // Start from right to left, perform multiplication on every pair of digits, and add them together.
    // 'num1[i] * num2[j]' will be placed at indices '[i + j, i + j + 1]'
    public String multiply(String num1, String num2) {
        int length1 = num1.length();
        int length2 = num2.length();
        int[] pos = new int[length1 + length2];
        
        for (int i = length1 - 1; i >= 0; i--) {
            for (int j = length2 -1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2];
                
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            // The first number must be greater than 0.
            if (sb.length() != 0 || p != 0) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}





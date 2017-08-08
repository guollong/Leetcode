/**
 * Question description: Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * 
 * Note: The length of both num1 and num2 is < 5100.
 * 		 Both num1 and num2 contains only digits 0-9.
 * 		 Both num1 and num2 does not contain any leading zero.
 *		 You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google, Airbnb.
 * Create Date: 03/27/2017
 * Update Date: 06/02/2017
 */

// The string number may exceed the range of an integer. In order to avoid exceed the boundary of the integer, 
// we would add two numbers bit by bit. (Decimal bit)
public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int number1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int number2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int temp = number1 + number2 + carry;
            carry = temp >= 10 ? 1 : 0;
            res.append(temp % 10);
        }
        if (carry == 1) {
            res.append(1 + "");
        }
        return res.reverse().toString();
    }
}



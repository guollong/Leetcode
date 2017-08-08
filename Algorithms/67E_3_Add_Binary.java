/**
 * Question description: Given two binary strings, return their sum (also a binary string).
 *
 * Example: a = "11", b = "1", Return "100".
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 */

// Simpler version. Start from the last element and use "index > 0" to check if the string still has element to add.
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() -1, carry = 0;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (j >= 0) sum += b.charAt(j--) - '0';
            if (i >= 0) sum += a.charAt(i--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if (carry != 0) sb.append(carry);
        return sb.reverse().toString();
    }
}

// My own solution. The same idea with previous solution but more complex.
public class Solution {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int minlength = Math.min(a.length(), b.length());
        int i = 0;
        for (; i < minlength; i++) {
            int add = carry + (a.charAt(a.length() - i - 1) - '0') + (b.charAt(b.length() - i - 1) - '0');
            carry = add / 2;
            add = add % 2;
            result.append(add + "");
        }
        String temp = a.length() > b.length() ? a : b;
        while (i < temp.length()) {
            int add = carry + (temp.charAt(temp.length() - i - 1) - '0');
            carry = add / 2;
            add = add % 2;
            result.append(add + "");
            i++;
        }
        if (carry == 1) {
            result.append("1");
        }
        return result.reverse().toString();
    }
}






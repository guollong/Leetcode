/**
 * Question description: Implement a basic calculator to evaluate a simple expression string.
 *		The expression string contains only non-negative integers, +, -, *, / operators and empty spaces. 
 *		The integer division should truncate toward zero. You may assume that the given expression is always valid.
 * 
 * Examples: "3+2*2" = 7
 *			 " 3/2 " = 1
 *			 " 3+5 / 2 " = 5
 *
 * Note: Do not use the eval built-in library function.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Airbnb. 
 */

/**
 * Progress...
 * Create Date: 08/07/2017
 */


public class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int number = 0;
        char sign = '+';
        char[] sArray = s.toCharArray();
        for(int i = 0; i < s.length(); i++) {
            char c = sArray[i];
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            }
            // If it is an operator or the last character of the string.
            if ((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-number);
                }
                if (sign == '+') {
                    stack.push(number);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * number);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / number);
                }
                sign = c;
                number = 0;
            }
        }

        int result = 0;
        for(int element : stack) {
            result += element;
        }
        return result;
    }
}





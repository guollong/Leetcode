/**
 * Question description: Implement a basic calculator to evaluate a simple expression string.
 * 
 * 		The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, 
 *		non-negative integers and empty spaces. You may assume that the given expression is always valid.
 * 
 * Examples: "1 + 1" = 2
 *			 " 2-1 + 2 " = 3
 *			 "(1+(4+5+2)-3)+(6+8)" = 23
 *
 * Note: Do not use the eval built-in library function.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google. 
 */

/**
 * Progress...
 * Create Date: 08/07/2017
 */

// Idea: 5 possible input:
//	1. digit: one digit from the current number.
//	2. '+': number is over, add the previous number and start a new number, set the sign.
//	3. '-': same as '+'.
//	4. '(': push the previous result and the sign into the stack, set result to 0, just calculate the new result 
//			within the parenthesis.
//	5. ')': pop out the top two numbers from stack, first one is the sign before this pair of parenthesis, second 
//			is the temporary result before this pair of parenthesis. We add them together.
public class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int number = 0;
        int sign = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char c = charArray[i];
            if (Character.isDigit(c)) {
                number = number * 10 + (int) (c - '0');
            } else if (c == '+') {
                result += sign * number;
                number = 0;
                sign = 1;
            } else if (c == '-') {
                result += sign * number;
                number = 0;
                sign = -1;
            } else if (c == '(') {
                // Because the character before ')' would always be a operator or nothing, so
                //      we don't need to set the number to be 0.
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                // Because the character behind ')' would always be a operator or nothing, so
                //      we don't need to set the sign.
                result += sign * number;
                result *= stack.pop();
                result += stack.pop();
                number = 0;
            }
        }
        return result + sign * number;
    }
}





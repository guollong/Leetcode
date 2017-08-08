/**
 * Question description: Given a string representing arbitrarily nested ternary expressions, calculate the result of 
 *		the expression. You can always assume that the given expression is valid and only consists of digits 0-9, ?, :, T and F 
 *		(T and F represent True and False respectively).
 * 
 * Note: The length of the given string is ≤ 10000.
 *		 Each number will contain only one digit.
 *		 The conditional expressions group right-to-left (as usual in most languages).
 *		 The condition will always be either T or F. That is, the condition will never be a digit.
 * 		 The result of the expression will always evaluate to either a digit 0-9, T or F.
 *
 * Example 1: Input: "T?2:3"; Output: "2"
 * Example 2: Input: "F?1:T?4:5"; Output: "4"
 * Example 3: Input: "T?T?F:5:3"; Output: "F"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Snapchat. 
 */

/**
 * Progress...
 * Create Date: 08/08/2017
 */

// Solution 1: DFS.
public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return expression;
        }
        char[] exp = expression.toCharArray();
        
        return DFS(exp, 0, exp.length - 1) + "";
    }
    
    // Return the result of ternary expression which start from "start" and end up to "end".
    private char DFS(char[] c, int start, int end) {
        if (start == end) {
            return c[start];
        }
        int count = 0;
        // find the ":" pairs with the first operator c[start].
        int i = start;
        for (; i <= end; i++) {
            if (c[i] == '?') {
                count++;
            } else if (c[i] == ':') {
                count--;
                if (count == 0) {
                    break;
                }
            }
        }
        return (c[start] == 'T') ? DFS(c, start + 2, i - 1) : DFS(c, i + 1, end);
    }
}

// Solution 2: Using stack.
// Idea: From right to left, when encounter an operator, pop two values from stack and push the result
//       back to the stack.
public class Solution {
    public String parseTernary(String expression) {
        if (expression == null || expression.length() == 0) {
            return "";
        }
        
        Stack<Character> stack = new Stack<>();
        char[] expArray = expression.toCharArray();
        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expArray[i];
            if (stack.size() != 0 && stack.peek() == '?') {
                stack.pop(); //pop '?'
                char first = stack.pop();
                stack.pop(); //pop ':'
                char second = stack.pop();

                if (c == 'T') {
                    stack.push(first);
                } else {
                    stack.push(second);
                }
            } else {
                stack.push(c);
            }
        }

        return stack.peek() + "";
    }
}












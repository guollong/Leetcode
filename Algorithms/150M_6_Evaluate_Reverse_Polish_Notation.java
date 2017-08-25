/**
 * Question description: Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *			 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operand = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String s : tokens) {
            if (!operand.contains(s)) {
                stack.push(Integer.parseInt(s));
            } else {
                int number1 = stack.pop();
                int number2 = stack.pop();
                if (s.equals("+")) {
                    stack.push(number1 + number2);
                } else if (s.equals("-")) {
                    stack.push(number2 - number1);
                } else if (s.equals("*")) {
                    stack.push(number1 * number2);
                } else {
                    stack.push(number2 / number1);
                }
            }
        }
        return stack.peek();
    }
}


/**
 * Question description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google, Airbnb, Facebook, Twitter, Zenefits, Amazon, Microsoft, Bloomberg.
 * Create Date: 04/05/2017
 * Update date: 06/14/2017
 * Update date: 09/12/2017
 */

// General solution.
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        String left = "({[";
        String right = ")}]";
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int index1 = left.indexOf(c);
            int index2 = right.indexOf(c);
            if (index1 >= 0) {
                stack.push(c);
            }
            if (index2 >= 0) {
                if (stack.isEmpty() || stack.pop() != left.charAt(index2)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// More effective method.
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

// 09.12.2017 version.
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        List<Character> left = Arrays.asList(new Character[]{'{', '[', '('});
        
        for (char c : s.toCharArray()) {
            if (left.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == '}' && top != '{') || (c == ']' && top != '[') || (c == ')' && top != '(')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

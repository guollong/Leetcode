/**
 * Question description: Given a string containing just the characters '(' and ')', find the length of the longest 
 *		valid (well-formed) parentheses substring.
 * 
 * Example: For "(()", the longest valid parentheses substring is "()", which has length = 2.
 *		For ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 08/11/2017
 */

// Solution 1: Brute force method (Time Limit Exceeded)
//      For every even length substring, check the validity of parentheses 
//      in this substring, and update the length of longest valid parentheses.
// Running time complexity: O(n ^ 3).
// Java 7 and later: the time complexity of substring is O(n), while before java 7, it's O(1).
public class Solution {
    public int longestValidParentheses(String s) {
        int maxValidLength = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j++) {
                if (isValid(s.substring(i, j))) {
                    maxValidLength = Math.max(maxValidLength, j - i);
                }
            }
        }
        return maxValidLength;
    }
    
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            if (sArray[i] == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }
}

// Solution 2: Dynamic programming: The most effective.
public class Solution {
    public int longestValidParentheses(String s) {
        // State: dp[i]: the longest valid parentheses which ends at ith index.
        int[] dp = new int[s.length()];
        int maxLength = 0;
        
        // Function: 
        // Only update the dp array when the character is ')'.
        // If s.charAt(i - 1) == '(', dp[i] = dp[i - 2] + 2;
        // If s.charAt(i - 1) == ')' and s.charAt(i - dp[i - 1] - 1) == '(', dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2].
        char[] sArray = s.toCharArray();
        for (int i = 1; i < s.length(); i++) {
            if (sArray[i] == ')') {
                if (sArray[i - 1] == '(') {
                    dp[i] = (i == 1) ? 2 : dp[i - 2] + 2;
                } else if (i - dp[i - 1] > 0 && sArray[i - dp[i - 1] - 1] == '(') {
                    if (i - dp[i - 1] - 2 >= 0) {
                        dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
                    } else {
                        dp[i] = dp[i - 1] + 2;
                    }
                }
                maxLength = Math.max(maxLength, dp[i]);
            }
        }
        
        return maxLength;
    }
}

// Solution 3: Stack.
public class Solution {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                	// "i - stack.peek()" get the current length of the valid parentheses.
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}

// Solution 4: Two passes using two pointers left and right without extra space.
// Idea: In this approach, we make use of two counters leftleft and rightright. First, we start traversing the string 
//		from the left towards the right and for every \text{‘(’}‘(’ encountered, we increment the leftleft counter and 
//		for every \text{‘)’}‘)’ encountered, we increment the rightright counter. Whenever leftleft becomes equal to 
//		rightright, we calculate the length of the current valid string and keep track of maximum length substring found 
//		so far. If rightright becomes greater than leftleft we reset leftleft and rightright to 00. Next, we start 
//		traversing the string from right to left and similar procedure is applied.
public class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxlength = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * right);
            } else if (right >= left) {
                left = right = 0;
            }
        }
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                maxlength = Math.max(maxlength, 2 * left);
            } else if (left >= right) {
                left = right = 0;
            }
        }
        return maxlength;
    }
}










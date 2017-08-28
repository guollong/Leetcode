/**
 * Question description: Given an encoded string, return it's decoded string.
 * 		The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being 
 *		repeated exactly k times. Note that k is guaranteed to be a positive integer.
 * 
 * 		You may assume that the input string is always valid; No extra white spaces, square brackets are 
 *		well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and 
 *		that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * 
 * Examples: s = "3[a]2[bc]", return "aaabcbc".
 * 			 s = "3[a2[c]]", return "accaccacc".
 *			 s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google. 
 */

/**
 * Progress...
 * Create Date: 08/28/2017
 */

// Using recursion and stack.
class Solution {
    public String decodeString(String s) {
        // base case.
        if (!s.contains("[")) {
            return s;
        }
        
        // recursive case.
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        int number = 0;
        
        while (index < s.length()) {
            
            // Not all strings start from a number, there may be characters before numbers.
            while (index < s.length() && !Character.isDigit(s.charAt(index))) {
                result.append(s.charAt(index));
                index++;
            }
            
            // Get the number that used to repeat the string.
            number = 0;
            while (index < s.length() && Character.isDigit(s.charAt(index))) {
                number = number * 10 + s.charAt(index) - '0';
                index++;
            }
            
            // get the start index and end index of the repeated string.
            stack = new Stack<>();
            int indexTemp = index + 1;
            stack.push('[');
            while (!stack.empty() && indexTemp < s.length()) {
                if (s.charAt(indexTemp) == '[') {
                    stack.push('[');
                } else if (s.charAt(indexTemp) == ']') {
                    stack.pop();
                }
                indexTemp++;
            }
            
            // append repeated string to the result.
            for (int i = 0; i < number; i++) {
                result.append(decodeString(s.substring(index + 1, indexTemp - 1)));  
            }
            index = indexTemp;
        }
        return result.toString();
    }
}



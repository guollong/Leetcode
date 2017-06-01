/**
 * Question description: Given a string, you need to reverse the order of characters in each 
 *		word within a sentence while still preserving whitespace and initial word order.
 *
 * Example: Input: "Let's take LeetCode contest"; Output: "s'teL ekat edoCteeL tsetnoc"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

// Approach 1: reverse the head and tail of the array.
// Initialize a string could take a char array as argument.
public class Solution {
    public String reverseWords(String s) {
        char[] ca = s.toCharArray();
        for (int i = 0; i < ca.length; i++) {
        	// Start from the begining of a string.
            if (ca[i] != ' ') {
                int j = i;
                // Find the end of the string.
                while (j + 1 < ca.length && ca[j + 1] != ' ') { 
                	j++; 
                }
                // reverse the string which is a part of the array.
                reverse(ca, i, j);
                i = j;
            }
        }
        return new String(ca);
    }

    private void reverse(char[] ca, int i, int j) {
        for (; i < j; i++, j--) {
            char tmp = ca[i];
            ca[i] = ca[j];
            ca[j] = tmp;
        }
    }
}

// Approach 2: split the string to a string array. Build a stringbuilder and append
// 		the reverse of string to that stringbuilder.
public class Solution {
    public String reverseWords(String s) {
        String[] arrayWords = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < arrayWords.length; i++) {
            String sub = arrayWords[i];
            StringBuilder temp = new StringBuilder(sub);
            res.append(temp.reverse().toString());
            if (i != arrayWords.length - 1) {
                res.append(" ");
            }
        }
        return res.toString();
    }
}








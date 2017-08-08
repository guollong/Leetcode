/**
 * Question description: Given a string s consists of upper/lower-case alphabets and empty space 
 *		characters ' ', return the length of last word in the string.
 *		If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * 
 * Example: Given s = "Hello World", return 5.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 */

public class Solution {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] sArray = s.split("\\s+");
        int length = sArray.length;
        if (length == 0) {
            return 0;
        }
        return sArray[length - 1].length();
    }
}


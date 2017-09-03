/**
 * Question description: Given an input string, reverse the string word by word. 
 *		A word is defined as a sequence of non-space characters.
 * 
 * The input string does not contain leading or trailing spaces and the words are always 
 *		separated by a single space.
 * 
 * Example: Given s = "the sky is blue", return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Uber.
 */

/**
 * Progress...
 * Create Date: 06/27/2017
 * Update Date: 09/03/2017
 */

// Idea: reverse each word seperately and finally reverse the whole string.
public class Solution {
    public void reverseWords(char[] s) {
        int start = 0;
        int end = 0;
        while (end < s.length) {
            if (s[end] == ' ') {
                inplaceReverse(s, start, end - 1);
                start = end + 1;
                end = start;
            } else {
                end++;
            }
        }
        inplaceReverse(s, start, end - 1);
        inplaceReverse(s, 0, s.length - 1);
    }
    
    private void inplaceReverse(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

// Another version: reverse the whole string first and each word later.
public class Solution {
    public void reverseWords(char[] s) {
        // reverse the whole array.
        reverseWordsHelper(s, 0, s.length - 1);
        
        // reverse each word.
        int start = 0;
        int end = 0;
        while (end < s.length) {
            // find the boundary of a word. (start and end)
            while (end < s.length && s[end] != ' ') {
                end++;
            }
            reverseWordsHelper(s, start, end - 1);
            start = end + 1;
            end = end + 1;
        }
    }
    
    // reverse the element in the array between index1 and index2 (all inclusive).
    private void reverseWordsHelper(char[] s, int start, int end) {
        while (start < end) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
}

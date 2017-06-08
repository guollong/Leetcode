/**
 * Question description: Given a string, determine if it is a palindrome, considering only 
 *		alphanumeric characters and ignoring cases.
 * 
 * Example: "A man, a plan, a canal: Panama" is a palindrome.
 *	 		"race a car" is not a palindrome.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/07/2017
 */

// Two pointers.
public class Solution {
    public boolean isPalindrome(String s) {
        int front = 0;
        int rear = s.length() - 1;
        while (front < rear) {
            while (front < rear && !isAlphanumeric(s.charAt(front))) {
                front++;
            }
            while (front < rear && !isAlphanumeric(s.charAt(rear))) {
                rear--;
            }
            char frontChar = Character.toLowerCase(s.charAt(front));
            char rearChar = Character.toLowerCase(s.charAt(rear));
            if (frontChar != rearChar) {
                return false;
            }
            front++;
            rear--;
        }
        return true;
    }
    
    private boolean isAlphanumeric(char c) {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9');
    }
}


/**
 * Question description: Given a string S, you are allowed to convert it to a palindrome by adding characters 
 *		in front of it. Find and return the shortest palindrome you can find by performing this transformation.
 *
 * Example: Given "aacecaaa", return "aaacecaaa".
 *			Given "abcd", return "dcbabcd".
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems, Google. 
 */

/**
 * Progress...
 * Create Date: 08/03/2017
 */


// Solution 1: Two pointers.
// Average running time for finding the longest palindrome is n / 2.
// Thus the overral running time complexity is O(n^2).
public class Solution {
    public String shortestPalindrome(String s) {
        
        int pos = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == s.charAt(pos)) 
                pos++;
        }
        
        if (pos == s.length())
            return s;
        
        String suffix = s.substring(pos);
        return new StringBuilder(suffix).reverse().toString() + shortestPalindrome(s.substring(0, pos)) + suffix;
    }
}

// Solution 2: Brute force method.
// Thus the overral running time complexity is O(n^2).
public class Solution {
    public String shortestPalindrome(String s) {
        StringBuilder result = new StringBuilder();
        
        // Find the longest palindrome in string s.
        int i = s.length() - 1;
        for (; i >= 0; i--) {
            if (isPalindrome(s.substring(0, i + 1))) {
                break;
            }
        }
        
        // append the added string and intial string to the result.
        result.append(s.substring(i + 1));
        result.reverse();
        result.append(s.substring(0, i + 1));
        result.append(s.substring(i + 1));
        return result.toString();
    }
    
    private boolean isPalindrome(String s) {
        int length = s.length();
        int threshold = length / 2;
        for (int i = 0; i <= threshold; i++) {
            if (s.charAt(i) != s.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }
}


// Solution 3: KMP. 需要掌握吗？？？？？


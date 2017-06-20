/**
 * Question description: Given a string s, find the longest palindromic substring in s. 
 *		You may assume that the maximum length of s is 1000.
 * 
 * Example: Input: "babad"; Output: "bab" (Note: "aba" is also a valid answer.)
 *			Input: "cbbd"; Output: "bb"
 *
 * Follow up: Could be solved by dynamic programming (DP)?? HOW ??
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg.
 */

/**
 * Progress...
 * Create Date: 06/19/2017
 */

// Solution 1: Take the element i as the center, extend palindrome based on this element.
public class Solution {
    private int left = 0, maxLength = 0;

    public String longestPalindrome(String s) {
    	int len = s.length();
    	if (len < 2) {
    	    return s;
    	}
    	
        for (int i = 0; i < len - 1; i++) {
         	extendPalindrome(s, i, i);   // assume odd length, try to extend Palindrome as possible
         	extendPalindrome(s, i, i+1); // assume even length.
        }
        return s.substring(left, left + maxLength);
    }

    private void extendPalindrome(String s, int l, int r) {
    	while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
    		l--;
    		r++;
    	}
    	if (maxLength < r - l - 1) {
    		left = l + 1;
    		maxLength = r - l - 1;
    	}
    }
}

// Solution 2: Key idea, every time we move to right, we only need to consider whether 
// 		using this new character as tail could produce new palindrome string of length 
//		(current length +1) or (current length +2).
public class Solution {
    public String longestPalindrome(String s) {
        String res = "";
        int currLength = 0;
        for (int i = 0; i < s.length(); i++){
            if (isPalindrome(s, i - currLength - 1, i)) {
                res = s.substring(i - currLength - 1, i + 1);
                currLength = currLength + 2;
            } else if (isPalindrome(s, i - currLength, i)) {
                res = s.substring(i - currLength, i + 1);
                currLength = currLength + 1;
            }
        }
        return res;
    }
    
    public boolean isPalindrome(String s, int begin, int end) {
        if (begin < 0) {
            return false;
        }
        while (begin < end) {
        	if (s.charAt(begin++) != s.charAt(end--)) {
        	    return false;
        	}
        }
        return true;
    }
}







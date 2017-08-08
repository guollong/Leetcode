/**
 * Question description: Given a non-empty string check if it can be constructed by taking 
 *		a substring of it and appending multiple copies of the substring together. 
 *		You may assume the given string consists of lowercase English letters only.
 *
 * Example 1: Input: "abab", Output: True;
 * Example 2: Input: "aba", Output: False;
 */


// There is also a complicate algorithm called KMP to solve this problem. (But just need to know that.)
// KMP algorithm: searches for occurrences of a "word" W within a main "text string" S

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon, Google.
 * Create Date: 04/03/2017
 * Update date: 06/05/2017
 */

// My solution.
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        int halflength = s.length() / 2;
        for (int i = halflength; i >= 1; i--) {
            if (length % i == 0) {
                int count = length / i;
                String sub = s.substring(0, i);
                StringBuilder test = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    test.append(sub);
                }
                if (test.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}

// The similiar idea with me, but use stringbuilder to check the whole string.
public class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int length = s.length();
        int halflength = s.length() / 2;
        for (int i = halflength; i >= 1; i--) {
            if (length % i == 0) {
                int count = length / i;
                String sub = s.substring(0, i);
                StringBuilder test = new StringBuilder();
                for (int j = 0; j < count; j++) {
                    test.append(sub);
                }
                if (test.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}





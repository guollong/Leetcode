/**
 * Question description: Implement strStr().
 * 		Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Pocket Gems, Microsoft, Apple, Facebook.
 */

/**
 * Progress...
 * Create Date: 06/09/2017
 */

// Solution 1: use built-in api.
public class Solution {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
}

// Solution 2: not use built-in api.
public class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int length = needle.length();
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            if (needle.equals(haystack.substring(i, i + length))) {
                return i;
            }
        }
        return -1;
    }
}
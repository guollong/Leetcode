/**
 * Question description: Given a group of two strings, you need to find the longest uncommon subsequence
 *      of this group of two strings. The longest uncommon subsequence is defined as the longest subsequence
 *      of one of these strings and this subsequence should not be any subsequence of the other strings.
 *
 *      A subsequence is a sequence that can be derived from one sequence by deleting some characters without
 *      changing the order of the remaining elements. Trivially, any string is a subsequence of itself and an
 *      empty string is a subsequence of any string.
 *
 *      The output needs to be the length of the longest uncommon subsequence. 
 *      If the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example: Input: "aba", "cdc"; Output: 3
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

// Approach 1: If longest uncommon subsequence doesn't exist, that is two strings are equal, return -1;
//      Otherwise, return the maximum length;
public class Solution {
    public int findLUSlength(String a, String b) {
        return a.equals(b) ? -1 : Math.max(a.length(), b.length());
    }
}

// Approach 2: 2-layer loop. Take the substring of a, check if the substring is part of string b. If it 
//      is not, return the length of the substring.
public class Solution {
    public int findLUSlength(String a, String b) {
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        for (int i = a.length(); i > 0; i--) {
            for (int j = 0; j <= a.length() - i; j++) {
                String subSequence = a.substring(j, j + i);
                if (!b.contains(subSequence)) {
                    return subSequence.length();
                }
            }
        }
        return -1;
    }
}


















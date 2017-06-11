/**
 * Question description: Write a function to find the longest common prefix string amongst an array of strings.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Yelp.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 */

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String s = strs[i];
            while (s.indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}



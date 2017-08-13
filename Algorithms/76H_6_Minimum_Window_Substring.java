/**
 * Question description: Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *
 * Example: S = "ADOBECODEBANC", T = "ABC", Minimum window is "BANC".
 *
 * Note: If there is no such window in S that covers all characters in T, return the empty string "".
 *	  If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Linkedin, Snapchat, Uber, Facebook.
 */

/**
 * Progress...
 * Create Date: 08/12/2017
 */

// Solution 1: Brute force method: Time Limited Exceeded.
// Running time complexity: O(n ^ 3)
public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        int lengthS = s.length();
        int lengthT = t.length();
        
        // k represents for the length of the substring.
        for (int k = lengthT; k <= lengthS; k++) {
            for (int i = 0; i < lengthS - k + 1; i++) {
                String sub = s.substring(i, i + k);
                if (isWindow(sub, t)) {
                    return sub;
                }
            }
        }
        return "";
    }
    
    private boolean isWindow(String window, String s) {
        Map<Character, Integer> mapTemplate = new HashMap<>();
        for (int i = 0; i < window.length(); i++) {
            mapTemplate.put(window.charAt(i), mapTemplate.getOrDefault(window.charAt(i), 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!mapTemplate.containsKey(c)) {
                return false;
            } else if (mapTemplate.get(c) == 1) {
                mapTemplate.remove(c);
            } else {
                mapTemplate.put(c, mapTemplate.get(c) - 1);
            }
        }
        return true;
    }
}

// Solution 2: Using hashtable and two pointers. (Very hard to understand, need to come back to it later)
// Running time complexity: <= O(n ^ 2)
public class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        char[] sArray = s.toCharArray();
        int start = 0, end = 0;
        int leftMin = 0;
        int minLen = Integer.MAX_VALUE;
        // "count" represents the number of characters in string t that have been matched in substring of s.
        int count = 0;
        
        while (end != s.length()) {
            if (map.containsKey(sArray[end])) {
                int n = map.get(sArray[end]) - 1;
                map.put(sArray[end], n);
                if (n >= 0) {
                    count++;
                }
            }
            
            // When we found a valid window, move start to find smaller window.
            while (count == t.length()) {
                if (end - start + 1 < minLen) {
                    minLen = end - start + 1;
                    leftMin = start;
                }
                // sArray[start] will not belong to the substring, and since we substract 1 before, so we need to add 1 back.
                if (map.containsKey(sArray[start])) {
                    int n = map.get(sArray[start]) + 1;
                    map.put(sArray[start], n);
                    // if map.get(sArray[start]) >= 0 means that sArray[start] used to count into "count", now it no longer belongs to the substring, so we should substract 1 from the "count".
                    if (n >= 1) {
                        count--;
                    }
                }
                start++;
            }
            end++;
        }
        if (minLen != Integer.MAX_VALUE) {
            return s.substring(leftMin, leftMin + minLen);
        }
        return "";
    }

}









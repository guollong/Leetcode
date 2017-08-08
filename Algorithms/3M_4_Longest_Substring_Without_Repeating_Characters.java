/**
 * Question description: Given a string, find the length of the longest substring without repeating characters.
 * 
 * Example: Given "abcabcbb", the answer is "abc", which the length is 3.
 *			Given "bbbbb", the answer is "b", with the length of 1.
 *			Given "pwwkew", the answer is "wke", with the length of 3.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Adobe, Bloomberg, Yelp.
 */

/**
 * Progress...
 * Create Date: 06/19/2017
 */

// Solution 1: HashMap.
// Idea: Use a hashmap and two pointers. Right pointer for looping the whole string and used to 
//		store the character and position into the map. While looping, if duplicate was found, update
//		the left pointer to be the index of last occurance plus 1. No matter there is duplicate
//		or not, put the right pointer and cooresponding character into the map and update the maxLength
//		if necessary.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int right = 0, left = 0; right < s.length(); right++) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            // update the position of character checked to have duplicates.
            map.put(s.charAt(right), right);
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}


// Solution 2: Hashset.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, max = 0;
        Set<Character> set = new HashSet<>();
        
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }
}


// Brute Force method: time limit exceeded.
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int maxLength = 1;
        // i represents for the length of the substring.
        for (int i = 2; i <= s.length(); i++) {
            for (int j = 0; j <= s.length() - i; j++) {
                String sub = s.substring(j, j + i);
                if (!withDuplicates(sub)) {
                    maxLength = i;
                }
            }
        }
        return maxLength;
    }
    
    private boolean withDuplicates(String s) {
        char[] charArrayS = new char[256];
        for (int i = 0; i < s.length(); i++) {
            int index = (int) s.charAt(i);
            charArrayS[index]++;
            if (charArrayS[index] > 1) {
                return true;
            }
        }
        return false;
    }
}
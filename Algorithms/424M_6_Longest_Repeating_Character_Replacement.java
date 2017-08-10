/**
 * Question description: Given a string that consists of only uppercase English letters, you can replace any letter 
 *		in the string with another letter at most k times. Find the length of a longest substring containing all 
 *		repeating letters you can get after performing the above operations.
 * 
 * Example 1: Input: s = "ABAB", k = 2; Output: 4
 * Example 2: Input: s = "AABABBA", k = 1; Output: 4
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems.
 */

/**
 * Progress...
 * Create Date: 08/09/2017
 */

// Sliding window: Using sliding window to take the substring. Keep track of the maxCount in the substring. 
//		If the len(substring) - maxCount > k, the substring cannot form a string with all repeating letters.
// 		So increase the start index util it can form a repeating-letter string. Update the maxLength every iteration.
public class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        // The beginning of the substring.
        int start = 0;
        // The maxCount of elements in the substring.
        int maxCount = Integer.MIN_VALUE;
        
        int maxConLength = 0;
        char[] sArray = s.toCharArray();
        
        for (int end = 0; end < s.length(); end++) {
            count[sArray[end] - 'A']++;
            maxCount = Math.max(maxCount, count[sArray[end] - 'A']);
            while (end - start + 1 - maxCount > k) {
                // remove the start element from the substring and update the count array.
                count[sArray[start] - 'A']--;
                start++;
            }
            maxConLength = Math.max(maxConLength, end - start + 1);
        }
        return maxConLength;
    }
}






/**
 * Question description: Given a non-empty string s and a dictionary wordDict containing a list 
 *		of non-empty words, determine if s can be segmented into a space-separated sequence of 
 *		one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * 
 * Example: given s = "leetcode", dict = ["leet", "code"]
 *		Return true because "leetcode" can be segmented as "leet code".
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Uber, Facebook, Amazon, Yahoo, Bloomberg, Pocket Gems.
 */

/**
 * Progress...
 * Create Date: 07/05/2017
 */

// Dynamic programming: Sequence DP.
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Step1: State: f[i]: if the substring could be segmented as words in dictionary.
        boolean[] couldSegment = new boolean[s.length() + 1];
        
        // Step2: Initialization.
        couldSegment[0] = true;
        
        // Step3: Function: dp[i]: Or(dp[j] && substring(j + 1, i) in the dictionary)
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                String sub = s.substring(j, i);
                if (couldSegment[j] && wordDict.contains(sub)) {
                    couldSegment[i] = true;
                    break;
                }
            }
        }
        return couldSegment[s.length()];
    }
}

// Improved version: could use the max length of word in the dictionary to liminate searching area.
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // Step1: State: f[i]: if the substring could be segmented as words in dictionary.
        boolean[] couldSegment = new boolean[s.length() + 1];
        
        // Step2: Initialization.
        couldSegment[0] = true;
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < wordDict.size(); i++) {
            maxLength = Math.max(maxLength, wordDict.get(i).length());
        }
        
        // Step3: Function: dp[i]: Or(dp[j] && substring(j + 1, i) in the dictionary)
        // Be careful of taking the indices of substring and dp array.
        for (int i = 1; i <= s.length(); i++) {
            // "j" represents for the length of the substring.
            for (int j = 1; j <= i && j <= maxLength; j++) {
                String sub = s.substring(i - j, i);
                if (couldSegment[i - j] && wordDict.contains(sub)) {
                    couldSegment[i] = true;
                    break;
                }
            }
        }
        return couldSegment[s.length()];
    }
}


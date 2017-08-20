/**
 * Question description: Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, 
 *		add spaces in s to construct a sentence where each word is a valid dictionary word. You may assume the dictionary
 *		does not contain duplicate words. Return all such possible sentences.
 * 
 * Example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand", "dog"].
 * 		A solution is ["cats and dog", "cat sand dog"].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Dropbox, Google, Uber, Snapchat, Twitter. 
 */

/**
 * Progress...
 * Create Date: 08/18/2017
 */

// Solution 1: Improved brute force method (memorized recursion).
class Solution {
    private Map<Integer, List<String>> map = new HashMap<>();
        
    public List<String> wordBreak(String s, List<String> wordDict) {
        return wordBreakHelper(s, wordDict, 0);
    }
    
    private List<String> wordBreakHelper(String s, List<String> wordDict, int start) {
    	// Memorization.
        if (map.containsKey(start)) {
            return map.get(start);
        }

        List<String> result = new ArrayList<>();

        // base case.
        if (start == s.length()) {
            result.add("");
        }

        // for each prefix of s.substring(start), if the prefix is in the word dictionary, find word
        // list that could be broken in terms of remaining string, and concantenate them together.
        for (int end = start + 1; end <= s.length(); end++) {
            String prefix = s.substring(start, end);
            if (wordDict.contains(prefix)) {
                List<String> list = wordBreakHelper(s, wordDict, end);
                for (String l : list) {
                    result.add(prefix + (l == "" ? "" : " ") + l);
                }
            }
        }
        map.put(start, result);
        return result;
    }
}

// Solution 2: Dynamic programming (time limit exceeded).
// Maybe because the program costs a lot of space.
// Dynamic programming is always used to solve one of these problems: Maximum or minimum, yes or no, count number.
public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {

    	// State: dp[i]: Construct a sentence (list) from substring(0, i) where each word is a valid dictionary word.
        List<String> dp[] = new LinkedList[s.length() + 1];
        List<String> initial = new LinkedList<>();
        initial.add("");
        dp[0] = initial;

        // Function: dp[i]: 对于每个小于i的j，如果substring(j, i)在dictionary中，concantenate the elements in the list in 
        // position j and the substring.
        for (int i = 1; i <= s.length(); i++) {
            LinkedList<String> list = new LinkedList<>();
            for (int j = 0; j < i; j++) {
                if (dp[j].size() > 0 && wordDict.contains(s.substring(j, i))) {
                    for (String l : dp[j]) {
                        list.add(l + (l.equals("") ? "" : " ") + s.substring(j, i));
                    }
                }
            }
            dp[i] = list;
        }
        return dp[s.length()];
    }
}







/**
 * Question description: Given a digit string, return all possible letter combinations that the number could represent.
 * 		A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 		The letters 0 to 9 represent for: {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"}
 *
 * Example: Input:Digit string "23"; Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Dropbox, Google, Uber, Facebook.
 */

/**
 * Progress...
 * Create Date: 06/21/2017
 */

// Solutions are all from discussion.

// Solution 1: Recursive method. Don't need to build a new string, just use the original string and
//		offset. Check if the length of the prefix equals to the length of the digits.
public class Solution {
    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    public List<String> letterCombinations(String digits) {
    	List<String> result = new LinkedList<String>();
        
    	if (digits == null || digits.length() == 0) {
    	    return result;
    	}
    	combination("", digits, 0, result);
    	return result;
    }
    
    private void combination(String prefix, String digits, int offset, List<String> result) {
    	if (offset == digits.length()) {
    		result.add(prefix);
    		return;
    	}
    	String letters = KEYS[(digits.charAt(offset) - '0')];
    	for (int i = 0; i < letters.length(); i++) {
    		combination(prefix + letters.charAt(i), digits, offset + 1, result);
    	}
    }
}

// Solution 2: Iterative method: Using queue. The elements in the queue are prefix of the result.
public class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<String>();
        
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        String[] mapping = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        result.add("");
        for (int i = 0; i < digits.length(); i++){
            int x = digits.charAt(i) - '0';
            if (x == 0 || x == 1) {
                return new LinkedList<String>();
            }
            while (result.peek().length() == i){
                String t = result.remove();
                for (char s : mapping[x].toCharArray()) {
                    result.add(t + s);
                }
            }
        }
        return result;
    }
}





/**
 * Question description: Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * Example: given n = 3, a solution set is:
 * 
 *	[
 *	  "((()))",
 * 	  "(()())",
 *	  "(())()",
 *	  "()(())",
 *	  "()()()"
 *	]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Uber, Zenefits.
 */

/**
 * Progress...
 * Create Date: 07/22/2017
 */

// Solution 1: Backtracking.
// Similiar question: subset, permutation, etc...
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // The ranges of open and close are all 0 ~ 2.
    private void backtrack(List<String> result, String str, int open, int close, int max) {
        if (str.length() == max * 2) {
            result.add(str);
            return;
        }
        if (open < max) {
            backtrack(result, str + "(", open + 1, close, max);
        }
        if (close < open) {
            backtrack(result, str + ")", open, close + 1, max);
        }
    }
}

// Solution 2: DP Solution: First consider how to get the result f(n) from previous result f(0)...f(n-1). Actually, the 
// 		result f(n) will be put an extra () pair to f(n-1). Let the "(" always at the first position, to produce a valid 
// 		result, we can only put ")" in a way that there will be i pairs () inside the extra () and n - 1 - i pairs () 
//		outside the extra pair.
// Let us consider an example to get clear view: 
// f(0): ""
// f(1): "("f(0)")"
// f(2): "("f(0)")"f(1), "("f(1)")"
// f(3): "("f(0)")"f(2), "("f(1)")"f(1), "("f(2)")"
// f(n): "("f(0)")"f(n-1) , "("f(1)")"f(n-2) "("f(2)")"f(n-3) ... "("f(i)")"f(n-1-i) ... "("f(n-1)")"; 0 <= i <= n - 2;
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        List<String> init = new ArrayList<>();
        init.add("");
        result.add(init);
        
        for (int i = 1; i <= n; i++) {
            List<String> sublist = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String first : result.get(j)) {
                    for (String second : result.get(i - 1 - j)) {
                        sublist.add("(" + first + ")" + second);
                    }
                }
            }
            result.add(sublist);
        }
        return result.get(result.size() - 1);
    }
}












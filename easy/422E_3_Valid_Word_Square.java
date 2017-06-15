/**
 * Question description: Given a sequence of words, check whether it forms a valid word square.
 * 		A sequence of words forms a valid word square if the kth row and column read the exact 
 * 		same string, where 0 ≤ k < max(numRows, numColumns).
 *
 * Example1: Input: ["abcd", "bnrt", "crmy", "dtye"]; Output: true;
 * Example2: Input: ["abcd", "bnrt", "crm", "dt"]; Output: true
 * Example3: Input: ["ball", "area", "read", "lady"]; Output: false
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 04/05/2017
 * Update date: 06/15/2017
 */

// 首先应该保证长度相同, 如果列中字母的数目不等于单词的长度(防止list.get()出错)，返回false；
public class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String s = words.get(i);
            for (int j = 0; j < s.length(); j++) {
                // if the length of the word is not equal to the number of characters of that column.
                if (j >= words.size() || i >= words.get(j).length()) {
                    return false;
                }
                if (s.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

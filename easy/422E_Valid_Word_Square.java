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
 * Difficulty: Easy; Company: .
 * Date: 04/05/2017
 */

// 首先应该保证长度相同，如果单词长度大于单词数，直接返回false， 如果列中字母的数目不等于单词的
// 长度(防止list.get()出错)，返回false；
public class Solution {
    public boolean validWordSquare(List<String> words) {
        int wordNum = words.size();
        for (int i = 0; i < wordNum; i++) {
            String rowS = words.get(i);
            if (rowS.length() > wordNum) {
                return false;
            }
            StringBuilder columnS = new StringBuilder();
            for (int j = 0; j < rowS.length(); j++) {
                if (i > words.get(j).length() - 1) {
                    return false;
                } else {
                    columnS.append(words.get(j).charAt(i));
                }
            }
            if (!rowS.equals(columnS.toString())) {
                return false;
            }
        }
        return true;
    }
}
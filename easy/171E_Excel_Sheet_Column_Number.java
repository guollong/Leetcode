/**
 * Question description: Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * Example: A -> 1; B -> 2; AA -> 27; AB -> 28 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        int length = s.length();
        char[] title = s.toCharArray();
        for (int i = 0; i < length; i++) {
            sum = sum * 26 + title[i] - 65 + 1;
        }
        return sum;
    }
}
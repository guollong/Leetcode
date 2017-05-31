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

// 貌似从char array中取元素比从string中charAt的效率高，有待验证。。。
public class Solution {
    public int titleToNumber(String s) {
        int sum = 0;
        char[] sArray = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            sum = sum * 26 + sArray[i] - 'A' + 1;
        }
        return sum;
    }
}

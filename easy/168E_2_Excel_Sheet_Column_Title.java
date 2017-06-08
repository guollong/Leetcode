/**
 * Question description: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * Example: 1 -> A; 2 -> B; 27 -> AA; 28 -> AB.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 03/25/2017
 * Update date: 06/07/2017
 */

// ascii to char: 直接强制类型转换(char)65即可。
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        int temp = n;
        int remainder = 0;
        while (temp != 0) {
            remainder = (temp - 1) % 26;
            result.append((char) (remainder + 'A'));
            temp = (temp - 1) / 26;
        }
        return result.reverse().toString();
    }
}


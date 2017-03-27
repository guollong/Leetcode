/**
 * Question description: Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * Example: 1 -> A; 2 -> B; 27 -> AA; 28 -> AB.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

// ascii to char: 直接强制类型转换(char)65即可。
// StringBuilder有reverse() method。
public class Solution {
    public String convertToTitle(int n) {
        StringBuilder title = new StringBuilder();
        int temp = n;
        int quotient = n;
        int remainder = n;
        while (temp != 0) {
            quotient = (temp - 1) / 26;
            remainder = (temp - 1) % 26;
            title.append((char)('A' + remainder));
            temp = quotient;
        }
        return title.reverse().toString();
    }
}
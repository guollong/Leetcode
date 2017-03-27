/**
 * Question description: Given a string which consists of lowercase or uppercase letters, 
 *			find the length of the longest palindromes that can be built with those letters.
 * Example: Input: "abccccdd"; Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

// 如果output不等于输入字符串的长度，说明有的字母有奇数个，而回文中只允许有一个个数为奇数的字母存在。
// 回文：正读和反渎是一样的。
public class Solution {
    public int longestPalindrome(String s) {
        int[] frequency = new int[26 * 2];
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            // upper letter.
            if (temp < 97) {
               frequency[temp - 'A']++;
            } else {
                // lower letter.
                frequency[temp - 'a' + 26]++;
            }
        }
        
        int output = 0;
        for (int i = 0; i < 52; i++) {
            output += frequency[i] % 2 == 0 ? frequency[i] : frequency[i] - 1;
        }
        return output == s.length() ? output : output + 1;
    }
}


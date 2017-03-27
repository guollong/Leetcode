/**
 * Question description: Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting 
 * 		from the start of the string. If there are less than k characters left, reverse all of them. If there are less than 2k but 
 *		greater than or equal to k characters, then reverse the first k characters and left the other as original.
 * Example:
 *  	Input: s = "abcdefg", k = 2; Output: "bacdfeg"
 * Restrictions:
 *      The string consists of lower English letters only.
 * 		Length of the given string and k will in the range [1, 10000]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/26/2017
 */

// 学到的东西： StringBuilder可以直接append一个substring。
public class Solution {
    StringBuilder output = new StringBuilder();
    public String reverseStr(String s, int k) {
        int length = s.length();
        // if there are less than k characters left, reverse all of them.
        if (length <= k) {
            StringBuilder tempString = new StringBuilder();
            tempString.append(s.substring(0, length));
            output.append(tempString.reverse().toString());
            return output.toString();
        } else {
            // reverse first k elements.
            StringBuilder tempString = new StringBuilder();
            tempString.append(s.substring(0, k));
            output.append(tempString.reverse().toString());

            if (length > k && length <= 2 * k) {
                // append the left element and then return the output.
                output.append(s.substring(k, length));
                return output.toString();
            } else {
                // recursively reverse the left substring.
                output.append(s.substring(k, 2 * k));
                String temp = s.substring(2 * k, length);
                return reverseStr(temp, k);
            }
        }
    }
}
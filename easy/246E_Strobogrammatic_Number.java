/**
 * Question description: A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * 			Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 *
 * Example: the numbers "69", "88", and "818" are all strobogrammatic.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

// 是某种程度上的对称，所以除了其本身是对称的数字以外，还要求在对称位置上的值相等，（6和9除外，要互为对方的值）。
public class Solution {
    public boolean isStrobogrammatic(String num) {
        int length = num.length();
        for (int i = 0; i < length; i++) {
            int number = num.charAt(i) - '0';
            if (number == 2 || number == 3 || number == 4 || number == 5 || number == 7) {
                return false;
            } else if (number == 6) {
                if (num.charAt(length - 1 - i) - '0' != 9) {
                    return false;
                }
            } else if (number == 9) {
                if (num.charAt(length - 1 - i) - '0' != 6) {
                    return false;
                }
            } else if (num.charAt(length - 1 - i) - '0' != number) {
                return false;
            }
        }
        return true;
    }
}
/**
 * Question description: Given an integer, return its base 7 string representation.
 *
 * Example 1: Input: 100; Output: "202"
 * Example 2: Input: -7; Output: "-10"
 * Example 3: Input: 0; Output: "0"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 * Date: 03/25/2017
 * Modified date: 05/29/2017
 */

// 注意事项：corner case： num为0, 考虑正负数。
public class Solution {
    public String convertToBase7(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder output = new StringBuilder();
        int temp = Math.abs(num);
        while (temp != 0) {
            output.append(temp % 7);
            temp = temp / 7;
        }
        if (num < 0) {
            output.append('-');
        }
        return output.reverse().toString();
    }
}

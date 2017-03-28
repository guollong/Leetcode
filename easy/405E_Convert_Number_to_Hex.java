/**
 * Question description: Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * Note: All letters in hexadecimal (a-f) must be in lowercase.
 * 		 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * 		 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 *		 You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * Example: Input: 26; Output: "1a"
 *			Input: -1; Output: "ffffffff"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/27/2017
 */

/*
Basic idea: each time we take a look at the last four digits of
            binary verion of the input, and maps that to a hex char
            shift the input to the right by 4 bits, do it again
            until input becomes 0.
*/

// solution from discussion.
// 自己想得太复杂了。直接讲input看作是二进制数即可，不用从十进制到16进制转换。
public class Solution {
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    public String toHex(int num) {
        if(num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        // 把num看成是2进制数，每次取4位，直接转换即可。
        while(num != 0){
            result.insert(0, map[(num & 0xf)]);
            num = (num >>> 4);
        }
        return result.toString();
    }
}
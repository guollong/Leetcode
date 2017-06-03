/**
 * Question description: Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * Note: All letters in hexadecimal (a-f) must be in lowercase.
 * 		 The hexadecimal string must not contain extra leading 0s. If the number is zero, it is represented by a single zero character '0'; otherwise, the first character in the hexadecimal string will not be the zero character.
 * 		 The given number is guaranteed to fit within the range of a 32-bit signed integer.
 *		 You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * Example: Input: 26; Output: "1a"
 *	Input: -1; Output: "ffffffff"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 03/27/2017
 * Update date: 06/02/2017
 */

// Notes: The difference between >> and >>> would only show up when shifting negative numbers. 
// The >> operator shifts a 1 bit into the most significant bit if it was a 1, and 
// the >>> shifts in a 0 regardless.

// Approach 1: Using stringbuilder.
public class Solution {
    public String toHex(int num) {
        if (num == 0) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        int temp = num;
        while (temp != 0) {
            int t = (temp & 0xf) > 9 ? (temp & 0xf) - 10 + 'a' : (temp & 0xf) + '0';
            result.append((char)t);
            temp = temp >>> 4;
        }
        return result.reverse().toString();
    }
}

// Approach 2: Using hex array.
public class Solution {
    
    char[] map = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    public String toHex(int num) {
        if(num == 0) return "0";
        String result = "";
        while(num != 0){
            result = map[(num & 15)] + result; 
            num = (num >>> 4);
        }
        return result;
    }
}



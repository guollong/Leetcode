/**
 * The digital root(also repeated digital sum) of a non-negative integer is the value obtained by an iterative process
 * of summing digits, on each iteration using the result from the previous iteration to compute a digit sum.
 * For example, the digital root of 65,536 is 7, because 6 + 5 + 5 + 3 + 6 = 25 and 2 + 5 = 7.
 */

// 很巧妙。。。。。。。。。。。。

/**
 * Question description: Calculate the digital root of one non-negative number.
 * Example: Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/08/2017
 */

public class Solution {
    public int addDigits(int num) {
        return num - 9 * ((num - 1) / 9);
        // return 1 + (num - 1) % 9;
    }
}
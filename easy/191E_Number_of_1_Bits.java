/**
 * Question description: Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * 
 * Example: the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

// >>> is logical right shift and >> is arithmetic shift. Since here we treat the input number as an unsigned integer,
// we should use logical right shift.
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        int temp = n;
        while (temp != 0) {
            count += (temp & 0x1);
            temp = temp >>> 1;
        }
        return count;
    }
}

// Jinglong's original solution.
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
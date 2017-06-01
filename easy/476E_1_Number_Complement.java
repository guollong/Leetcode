/**
 * Question description: Given a positive integer, output its complement number. 
 *						 The complement strategy is to flip the bits of its binary representation.
 * Note: The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 *    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * 
 * Example 1: Input: 5; Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010. So you need to output 2.
 * Example 2: Input: 1; Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0. So you need to output 0.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 02/24/2017
 */

public class Solution {
    public int findComplement(int num) {
        return ~num & ((Integer.highestOneBit(num) << 1) - 1);
        // return (Integer.highestOneBit(num) << 1) - 1 - num;
    }
}



/**
 * Question description: Given an array of numbers nums, in which exactly two elements appear 
 *		only once and all the other elements appear exactly twice. Find the two elements that appear only once.
 * 
 * Example: Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 
 * Note: The order of the result is not important. So in the above example, [5, 3] is also correct.
 *		Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Palantir, Airbnb.
 */

/**
 * Progress...
 * Create Date: 07/09/2017
 */

// Bit manipulation.

// Solution 1.
public class Solution {
    public int[] singleNumber(int[] nums) {
        // First pass: get the xor value of two elements appear only once.
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        
        // Second pass: Note that since the two numbers are distinct, so there must be a set bit 
        //      (that is, the bit with value '1') in the XOR result. In the second pass, we divide
        //      all numbers into two groups, one with the aforementioned bit set, another with the 
        //      aforementinoed bit unset. 
        int diff = xor & (-xor);
        int[] result = new int[]{0, 0};
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & diff) == 0) {
                // bit unset.
                result[0] ^= nums[i];
            } else {
                // bit set.
                result[1] ^= nums[i];
            }
        }
        return result;
    }
}










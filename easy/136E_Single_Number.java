/**
 * Question description: Given an array of integers, every element appears twice except for one. Find that single one.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/02/2017
 */

// 异或可以抵消两个相同的数。
public class Solution {
    public int singleNumber(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}
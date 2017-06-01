/**
 * Question description: Given an array of 2n integers, your task is to group these 
 *      integers into n pairs of integer, say (a1, b1), (a2, b2), ..., (an, bn) which
 *      makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example: Input: [1,4,3,2]; Output: 4.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

public class Solution {
    public int arrayPairSum(int[] nums) {
        int i, sum = 0;
        Arrays.sort(nums);
        int length = nums.length;
        for (i = 0; i < length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}








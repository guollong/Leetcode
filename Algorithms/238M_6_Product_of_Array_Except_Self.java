/**
 * Question description: Given an array of n integers where n > 1, nums, return an array output such that output[i] 
 *		is equal to the product of all the elements of nums except nums[i]. Solve it without division and in O(n).
 * 
 * Example: given [1,2,3,4], return [24,12,8,6].
 * 
 * Follow up: Could you solve it with constant space complexity? 
 *		(Note: The output array does not count as extra space for the purpose of space complexity analysis.)
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, LinkedIn, Apple, Facebook, Microsoft.
 */

/**
 * Progress...
 * Create Date: 08/08/2017
 */

// Input array: [1,2,3,4]
// Two passes.
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // corner case.
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        
        int[] result = new int[nums.length];
        result[0] = 1;
        // After first pass: [1, 1, 2, 6]
        int tempMulti = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = tempMulti * nums[i - 1];
            tempMulti = tempMulti * nums[i - 1];
        }
        
        // After second pass: [24, 12, 4, 1] .* [1, 1, 2, 6] = [24, 12, 8, 6]
        tempMulti = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = tempMulti * nums[i + 1] * result[i];
            tempMulti = tempMulti * nums[i + 1];
        }
        return result;
    }
}


// Simpler version.
public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        // First pass.
        int temp = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }
        
        // Second pass.
        temp = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}




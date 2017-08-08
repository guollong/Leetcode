/**
 * Question description: Find the contiguous subarray within an array (containing at least one number) which has 
 *		the largest product.
 * 
 * Example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: . 
 */

/**
 * Progress...
 * Create Date: 08/08/2017
 */

// Dynamic programming.
public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tempMax = max;
            max = Math.max(Math.max(min * nums[i], max * nums[i]), nums[i]);
            min = Math.min(Math.min(min * nums[i], tempMax * nums[i]), nums[i]);
            if (max > result) {
                result = max;
            }
        }
        return result;
    }
}






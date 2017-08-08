/**
 * Question description: Given an array of n integers where n > 1, nums, return an array output such that output[i]
 * is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 *
 * Example: given [1,2,3,4], return [24,12,8,6].
 * Notes: Could you solve it with constant space complexity?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/11/2017
 */

// Explaination: Given numbers [2, 3, 4, 5], regarding the third number 4, the product of array except 4 is 2*3*5 
// 		which consists of two parts: left 2*3 and right 5. The product is left*right. We can get lefts and rights:
// 
// Numbers:     2    3    4     5
// Lefts:            2  2*3 2*3*4
// Rights:  3*4*5  4*5    5      

// Let’s fill the empty with 1:

// Numbers:     2    3    4     5
// Lefts:       1    2  2*3 2*3*4
// Rights:  3*4*5  4*5    5     1


public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] result = new int[length];
        // Calculate lefts and store in result.
        // compute the multiplications and avoid taking itself into consideration.
        int start = 1;
        result[0] = 1;
        for (int i = 1; i < length; i++) {
            start = start * nums[i - 1];
            result[i] = start; 
        }
        
        // Calculate rights and the product from the end of the array.
        int right = 1;
        for (int i = length - 1; i >= 0; i--) {
            if (i < length - 1) {
                right = right * nums[i + 1];
            }
            result[i] = result[i] * right;
        }
        return result;
    }
}
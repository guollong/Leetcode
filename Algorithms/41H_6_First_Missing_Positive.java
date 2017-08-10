/**
 * Question description: Given an unsorted integer array, find the first missing positive integer.
 * 
 * Example: Given [1,2,0], return 3; Given [3,4,-1,1], return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems.
 */

/**
 * Progress...
 * Create Date: 08/09/2017
 */


// Idea: put all elements within the range to its right place, and then find out the first element that is not in
//		its right place.
public class Solution {
    public int firstMissingPositive(int[] nums) {
        // put each number in its right place.
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        
        // Find out the first missing positive number.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}



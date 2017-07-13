/**
 * Question description: Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * 
 * Example: Given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 07/12/2017
 */

public class Solution {
    public void wiggleSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) {
                    swap(nums, i, i - 1);
                }
            } else {
                if (i != 0 && nums[i - 1] < nums[i]) {
                    swap(nums, i, i - 1);
                }
            }
        }
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}



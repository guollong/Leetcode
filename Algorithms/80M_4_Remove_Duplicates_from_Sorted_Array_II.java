/**
 * Question description: Follow up for "Remove Duplicates": What if duplicates are allowed at most twice?
 *
 * Example: Given sorted array nums = [1,1,1,2,2,3],
 * 	Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. 
 *		It doesn't matter what you leave beyond the new length.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 06/25/2017
 */

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int index = 1;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            
            if (nums[i] == nums[i - 1] && count >= 2) {
                continue;
            } else if (nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }
            nums[index++] = nums[i];
        }
        return index;
    }
}



/**
 * Question description: Given an array of integers sorted in ascending order, find the 
 *		starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example: Given [5, 7, 7, 8, 8, 10] and target value 8, return [3, 4].
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn.
 */

/**
 * Progress...
 * Create Date: 06/24/2017
 */

public class Solution {
    /** 
     *@param A : an integer sorted array
     *@param target :  an integer to be inserted
     *return : a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        // Find the first occurrance index. 
        // Use "start + 1 < end" avoid trapping into a infinite loop.
        int[] result = new int[2];
        int start1 = 0;
        int end1 = nums.length - 1;
        int mid1;
        while (start1 + 1 < end1) {
            mid1 = start1 + (end1 - start1) / 2;
            if (nums[mid1] >= target) {
                end1 = mid1;
            } else {
                start1 = mid1 + 1;
            }
        }
        if (nums[start1] == target) {
            result[0] = start1;
        } else if (nums[end1] == target){
            result[0] = end1;
        } else {
            result[0] = -1;
        }
        
        // Find the first occurrance index.
        int start2 = 0;
        int end2 = nums.length - 1;
        int mid2;
        while (start2 + 1 < end2) {
            mid2 = start2 + (end2 - start2) / 2;
            if (nums[mid2] > target) {
                end2 = mid2 - 1;
            } else {
                start2 = mid2;
            }
        }
        if (nums[end2] == target) {
            result[1] = end2;
        } else if (nums[start2] == target){
            result[1] = start2;
        } else {
            result[1] = -1;
        }
        
        return result;
    }
}


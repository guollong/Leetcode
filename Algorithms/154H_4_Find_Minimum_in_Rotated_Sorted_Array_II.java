/**
 * Question description: Follow up for "Find Minimum in Rotated Sorted Array": What if duplicates are allowed?
 *		Would this affect the run-time complexity? How and why?
 * 
 *	Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * 
 * The array may contain duplicates.
 *
 * Similiar questions: 33, 81, 153, 154
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/25/2017
 */

// Binary search. However, the worst case is O(n). 
public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // Notes if statements.
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else if (nums[mid] > nums[start]) {
                end = mid;
            } else {
                start++;
            }
        }
        if (nums[start] < nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}




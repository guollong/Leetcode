/**
 * Question description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2). Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Follow up: question 154 (belongs to hard problems). Have duplicates.
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
 * Update Date: 10/29/2017
 */

// Binary search.
public class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            // Note the if statement.
            if (nums[mid] > nums[start] && nums[mid] > nums[end]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        return nums[end];
    }
}

// Simpler method.
class Solution {
    public int findMin(int[] nums) {
        // We have assumption that the input array is not an empty array.
        int start = 0;
        int end = nums.length - 1;
        
        while (start < end) {
            int mid = start + (end - start) / 2;
            // The array is rotated and mid is in the first part of the rotated array.
            if (nums[mid] > nums[end] && nums[mid] >= nums[start]) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return nums[start];
    }
}



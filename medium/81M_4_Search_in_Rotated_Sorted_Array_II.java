/**
 * Question description: Follow up for "Search in Rotated Sorted Array": What if duplicates are allowed?
 * 		Would this affect the run-time complexity? How and why?
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * Write a function to determine if a given target is in the array. The array may contain duplicates.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg, Uber, Facebook, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/25/2017
 */

// Follow up: With duplicates, the worst case is O(n).
// Reason: Consider this sorted array 1111115, which is rotated to 1151111.
// 		Assume left = 0 and mid = 3, and the target we want to search for is 5. Therefore, 
//		the condition A[left] == A[mid] holds true, which leaves us with only two possibilities:
//			All numbers between A[left] and A[right] are all 1's.
//			Different numbers (including our target) may exist between A[left] and A[right].
// 		As we cannot determine which of the above is true, the best we can do is to move left one 
//		step to the right and repeat the process again. Therefore, we are able to construct a worst 
//		case input which runs in O(n)

public class Solution {
    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            // The mid is in the second half of the array.
            if (nums[mid] < nums[start]) {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            } else if (nums[mid] > nums[start]) {
                // The mid is in the first half of the array.
                if (nums[mid] >= target && target >= nums[start]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                start++;
            }
        }
        if (nums[start] == target || nums[end] == target) {
            return true;
        }
        return false;
    }
}





/**
 * Question description: Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *		(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 *
 * Follow up: Search in a rotated sorted array 2.....
 * Similiar questions: 33, 81, 153, 154
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

// Binary search.
public class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // The mid is in the first half of the sorted array.
            if (nums[mid] > nums[start]) {
                if (target >= nums[start] && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                // The mid is in the second half of the sorted array.
                if (target <= nums[end] && target >= nums[mid]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        } // while

        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }
}
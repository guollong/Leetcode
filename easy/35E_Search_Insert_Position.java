/**
 * Question description: Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *		You may assume no duplicates in the array.
 *
 * Examples: [1,3,5,6], 5 → 2
 * 			 [1,3,5,6], 2 → 1
 *			 [1,3,5,6], 7 → 4
 *			 [1,3,5,6], 0 → 0
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
 */

// binary search needs two three pointers, left, right and mid.
// if else 语句比多个if语句有效率。大概是因为少了判断的次数。
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) >> 1;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
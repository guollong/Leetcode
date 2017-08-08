/**
 * Question description: A peak element is an element that is greater than its neighbors.
 * 		Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 *  	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 		You may imagine that num[-1] = num[n] = -∞.
 * 
 * Example: in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Google.
 */

/**
 * Progress...
 * Create Date: 06/25/2017
 */

// There must be a solution within one rising range and one descending range.
// Binary search.
public class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (mid - 1 >= 0 && mid + 1 < nums.length) {
                if (nums[mid] <= nums[mid - 1] && nums[mid + 1] <= nums[mid]) {
                    // if this is a descending range.
                    end = mid - 1;
                } else if (nums[mid] >= nums[mid - 1] && nums[mid + 1] <= nums[mid]) {
                    // if this is a local peek point.
                    return mid;
                } else {
                    // if this is a rising range or a trough.
                    start = mid + 1;
                }
            }
        }
        if (nums[start] > nums[end]) {
            return start;
        }
        return end;
    }
}




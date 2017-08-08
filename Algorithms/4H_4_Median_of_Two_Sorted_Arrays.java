/**
 * Question description: There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *		Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1: nums1 = [1, 3], nums2 = [2]; The median is 2.0
 * Example 2: nums1 = [1, 2], nums2 = [3, 4]; The median is (2 + 3)/2 = 2.5
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Zenefits, Microsoft, Apple, Yahoo, Dropbox, Adobe.
 */

/**
 * Progress...
 * Create Date: 06/28/2017
 */


public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        if (length % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, length / 2) + findKth(nums1, 0, nums2, 0, length / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, length / 2 + 1);
        }
    }
    
    // find kth element of two sorted array.
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
    	// base case: start1 >= nums1.length || start2 >= nums2.length || (start1 and start2 within bound, but k=1)
        if (start1 >= nums1.length) {
            return nums2[start2 + k - 1];
        }
        if (start2 >= nums2.length) {
            return nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        // Recursive case: compare the (k/2)th element of two array, if element1 < element2, move the index of
        // 		array1 to the k / 2, and find (k-k/2)th element among moved array1 and array2.
        int element1 = start1 + k / 2 - 1 < nums1.length ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
        int element2 = start2 + k / 2 - 1 < nums2.length ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;
        if (element1 < element2) {
            return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }
}



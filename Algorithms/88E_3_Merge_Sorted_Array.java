/**
 * Question description: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional 
 *		elements from nums2. The number of elements initialized in nums1 and nums2 are m and n respectively.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Microsoft, Bloomberg, Facebook.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 * Update Date: 08/30/2017
 */

// Idea: Loop over the nums2 array, for each element, find the insertion index in the nums1 array.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int insertIndex = 0;
        for (int i = 0; i < n; i++) {
            int j = insertIndex;
            // Find the position that the nums2[i] should be inserted.
            for (; j < m + i; j++) {
                if (nums2[i] < nums1[j]) {
                    break;
                }
            }
            
            shift(nums1, j, m + i);
            nums1[j] = nums2[i];
            insertIndex = j + 1;
        }
    }
    
    private void shift(int[] nums, int start, int total) {
        for (int i = total; i > start; i--) {
            nums[i] = nums[i - 1];
        }
    }
}

// Improved version:
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0) {
            if (nums1[m - 1] > nums2[n - 1]) {
                nums1[m + n - 1] = nums1[m - 1];
                m--;
            } else {
                nums1[m + n - 1] = nums2[n - 1];
                n--;
            }
        }
        while (n > 0) {
            nums1[n - 1] = nums2[n - 1];
            n--;
        }
    }
}



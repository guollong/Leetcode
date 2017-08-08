/**
 * Question description: Given an integer array, you need to find one continuous subarray 
 *		that if you only sort this subarray in ascending order, then the whole array will 
 *		be sorted in ascending order, too.
 *		You need to find the shortest such subarray and output its length.
 * 
 * Example 1: Input: [2, 6, 4, 8, 10, 9, 15]; Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LiveRamp, Google.
 */

/**
 * Progress...
 * Create Date: 06/10/2017
 */

// Running time complexity: O(n)
// From left to right, find temporary max value and get the index whose value are smaller than the temporary max value.
// From right to left, find temporary min value and get the index whose value are greater than the temporary min value.
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int start = -1;
        int end = -2;
        int length = nums.length;
        int maxTemp = nums[0];
        int minTemp = nums[length - 1];
        for (int i = 1; i < length; i++) {
            maxTemp = Math.max(maxTemp, nums[i]);
            if (nums[i] < maxTemp) {
                end = i;
            }
            minTemp = Math.min(minTemp, nums[length - i - 1]);
            if (minTemp < nums[length - i - 1]) {
                start = length - i - 1;
            }
        }
        return end - start + 1;
    }
}

// Running time complexity: O(n * logn)
// Sort and compare. (实在想不出来时，可以采用传统方法，先实现为主)
public class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 0; i < n; i++) temp[i] = nums[i];
        Arrays.sort(temp);
        
        int start = 0;
        while (start < n  && nums[start] == temp[start]) start++;
        
        int end = n - 1;
        while (end > start  && nums[end] == temp[end]) end--;
        
        return end - start + 1;
    }
}




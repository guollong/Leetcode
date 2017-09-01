/**
 * Question description: Given an array of n positive integers and a positive integer s, find the minimal length of a 
 *		contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * 
 * Example: given the array [2,3,1,2,4,3] and s = 7, the subarray [4,3] has the minimal length under the problem constraint.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: . 
 */

/**
 * Progress...
 * Create Date: 08/31/2017
 */

// Solution 1: Two pointers.
// Idea: find the rear first and move the front pointer to see if there is any substring 
//      shorter than the current substring.
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int front = 0;
        int rear = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (rear < nums.length) {
            sum += nums[rear++];
            while (sum >= s) {
                min = Math.min(min, rear - front);
                sum -= nums[front++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}


// Solution 2: Binary search.
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // The sum of the array are in ascending order.
        int[] sums = new int[nums.length + 1];
        for (int i = 1; i < nums.length + 1; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < sums.length; i++) {
            int end = Arrays.binarySearch(sums, i + 1, sums.length, s + sums[i]);
            end = end < 0 ? -(end + 1) : end;
            if (end == sums.length) {
                break;
            }
            if (end - i < minLen) {
                minLen = end - i;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}





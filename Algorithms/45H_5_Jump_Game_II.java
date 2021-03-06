/**
 * Question description: Given an array of non-negative integers, you are initially positioned at the first 
 *		index of the array. Each element in the array represents your maximum jump length at that position.
 *		Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example: Given array A = [2,3,1,1,4], The minimum number of jumps to reach the last index is 2. 
 *			(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
 *
 * Note: You can assume that you can always reach the last index.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Microsoft.
 */

/**
 * Progress...
 * Create Date: 07/03/2017
 */


// For this question, dynamic programming is not the best solution. The best solution is greedy algorithm.
// However, greedy is relatively not very important in interview. If you found it is necessary to know the
// greedy solution of this problem, figure it out later.

// Sadly, in this problem, using dynamic programming will cause time limit exceed (pass in lintcode, but 
//		fail in leetcode). Maybe need to do it using greedy algorithm. 

// Dynamic programming: Sequence DP. 特别巧妙的解法。。
public class Solution {
    public int jump(int[] nums) {
        // f[i]: The minimum number of jumps to reach the position i.
        int[] jumps = new int[nums.length];
        
        // The begining index of elements that need to be updated.
        int start = 0;
        
        // For each element, update to the furthest point the element could reach with minimum jump steps.
        for (int i = 0; i < nums.length; i++) {
            for (int j = start + 1; j <= i + nums[i] && j < nums.length; j++) {
                jumps[j] = jumps[i] + 1;
            }
            start = Math.max(i + nums[i], start);
            if (i + nums[i] >= nums.length - 1) {
                break;
            }
        }
        
        return jumps[nums.length - 1];
    }
}


// Dynamic programming solution: Sequence DP. Time limit exceeded. 传统解法。。。
public class Solution {
    public int jump(int[] nums) {
        // Step1: f[i]: The minimum number of jumps to reach the position i.
        int[] jumps = new int[nums.length];
        
        // Step2: Intialization.
        jumps[0] = 0;
        
        // Step3: Function: f[i] = if (nums[j] >= j - i)  {Min(dp[j])} + 1;
        for (int i = 1; i < nums.length; i++) {
            jumps[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (jumps[j] != Integer.MAX_VALUE && nums[j] >= i - j) {
                    jumps[i] = jumps[j] + 1;
                    break;
                }
            }
        }
        
        // Step4: Result.
        return jumps[nums.length - 1];
    }
}



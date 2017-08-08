/**
 * Question description: Given an array of non-negative integers, you are initially positioned 
 *		at the first index of the array. Each element in the array represents your maximum jump 
 *		length at that position. Determine if you are able to reach the last index.
 * 
 * Example: A = [2,3,1,1,4], return true.
 *			A = [3,2,1,0,4], return false.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft.
 */

// For this question, dynamic programming is not the best solution. The best solution is greedy algorithm.
// However, greedy is relatively not very important in interview. If you found it is necessary to know the
// greedy solution of this problem, figure it out later.

// Dynamic programming: Sequence DP.
public class Solution {
    public boolean canJump(int[] nums) {

        int length = nums.length;
        if (length == 1 && nums[0] == 0) {
            return true;
        }

        // Step1: f[i]: Whether you are able to reach the position i.
        boolean[] dp = new boolean[length];

        // Step2: Intialization.
        dp[0] = nums[0] == 0 ? false: true;
        
        // Step3: Function: f[i] = Or(dp[j] && nums[j] >= i - j)
        for (int i = 0; i < length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        // Step4: Result.
        return dp[length - 1];
    }
}


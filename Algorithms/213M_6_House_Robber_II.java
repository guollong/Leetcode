/**
 * Question description: Note: This is an extension of House Robber. Instead of robbing houses along a street, 
 *		this time the houses form a circle, that is the last house is the neighbor of the first house. The same 
 *		as the first question, return the maximum amount of money that the robber could rob.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft. 
 */

/**
 * Progress...
 * Create Date: 08/19/2017
 */

// Solution 1: Original dynamic programming method. (O(n) space complexity).
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    
    
    private int robHelper(int[] num, int index1, int index2) { // include index2.
        // base case;
        if (index1 > index2) {
            return 0;
        } else if (index1 == index2) {
            return num[index1];
        }
        
        // Initialization.
        int[] dp = new int[index2 - index1 + 1];
        dp[0] = num[index1];
        dp[1] = Math.max(num[index1], num[index1 + 1]);
        
        // Function.
        for (int i = 2; i <= index2 - index1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i + index1]);
        }
        return dp[index2 - index1];
    }
}

// Solution 2: Improved dynamic programming method. (constant space complexity).
public class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(nums, 0, nums.length - 2), robHelper(nums, 1, nums.length - 1));
    }
    
    
    private int robHelper(int[] num, int index1, int index2) { // include index2.
        int robPre = 0;
        int notRobPre = 0;
        
        for (int i = index1; i <= index2; i++) {
            int temp = notRobPre;
            notRobPre = Math.max(notRobPre, robPre); // not rob the current house.
            robPre = temp + num[i];
        }
        return Math.max(robPre, notRobPre);
    }
}







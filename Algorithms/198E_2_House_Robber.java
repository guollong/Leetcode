/**
 * Question description: You are a professional robber planning to rob houses along a street. 
 *		Each house has a certain amount of money stashed, the only constraint stopping you from 
 *		robbing each of them is that adjacent houses have security system connected and it will 
 *		automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * 		Given a list of non-negative integers representing the amount of money of each house, 
 *		determine the maximum amount of money you can rob tonight without alerting the police.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LinkedLi, Airbnb.
 */

/**
 * Progress...
 * Create Date: 06/04/2017
 * Update Date: 08/19/2017
 */

// Dynamic programming.
public class Solution {
    public int rob(int[] num) {
        // base case;
        if (num == null || num.length == 0) {
            return 0;
        } else if (num.length == 1) {
            return num[0];
        }
        
        // Initialization.
        int[] dp = new int[num.length];
        dp[0] = num[0];
        dp[1] = Math.max(num[0], num[1]);
        
        // Function.
        for (int i = 2; i < num.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
        }
        return dp[num.length - 1];
    }
}

// Solution with explanation. (This version is not easy to make mistakes.)
public class Solution {
    public int rob(int[] nums) {
	    int ifRobbedPrevious = 0; 	// max money can get if rob current house
	    int ifDidntRobPrevious = 0; // max money can get if not rob current house
	    
	    for(int i = 0; i < nums.length; i++) 
	    {
	    	// If we rob current cell, previous cell shouldn't be robbed. So, add the current value to previous one.
	        int currRobbed = ifDidntRobPrevious + nums[i];
	        
	        // If we don't rob current cell, then the count should be max of the previous cell robbed and not robbed
	        int currNotRobbed = Math.max(ifDidntRobPrevious, ifRobbedPrevious); 
	        
	        // Update values for the next round
	        ifDidntRobPrevious  = currNotRobbed;
	        ifRobbedPrevious = currRobbed;
	    }
	    return Math.max(ifRobbedPrevious, ifDidntRobPrevious);
	}
}

// Simpler solution.
public class Solution {
    public int rob(int[] num) {
        int prevNo = 0;
        int prevYes = 0;
        for (int n : num) {
            int temp = prevNo;
            prevNo = Math.max(prevNo, prevYes);
            prevYes = n + temp;
        }
        return Math.max(prevNo, prevYes);
    }
}




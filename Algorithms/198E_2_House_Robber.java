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
 */

// Dynamic programming. Could I say the idea of dynamic programming is much similiar to recursion??
// They are all split the problem into sub problems. DP takes the result of previous computation and 
// could save lots of time. 认识还不够。。。。。。。。。。。。。。。。

// 该题目思路错误，time limit exceeded.。。。。。。。。。。。。。。。。

// Solution with explanation. (This version is not easy to make mistakes.)
public class Solution {
    public int rob(int[] nums) {
		int ifRobbedPrevious = 0; 	// max monney can get if rob current house
	    int ifDidntRobPrevious = 0; // max money can get if not rob current house
	    
	    for(int i=0; i < nums.length; i++) 
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


// Recursive time limit exceeded version.
public class Solution {
    public int rob(int[] nums) {
        return robHelper(nums, 0, nums.length - 1);
    }
    
    private int robHelper(int[] nums, int start, int end) {
        // base case: 
        if (start == end) {
            return nums[start];
        }
        if (end - start == 1) {
            return Math.max(nums[start], nums[end]);
        }
        if (start > end) {
            return 0;
        }
        // recursive case.
        return Math.max(nums[start] + robHelper(nums, start + 2, end), robHelper(nums, start + 1, end));
    }
}




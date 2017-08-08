/**
 * Question description: Given a non-empty integer array of size n, find the minimum number of moves required
 * 		to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 *
 * Example:
 * 		Input:[1,2,3]; Output:3
 * Explanation: Only three moves are needed (remember each move increments two elements):
 * 		[1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Indeed, Coursera.
 * Create Date: 03/13/2017
 * Update date: 06/01/2017
 */

// A move is incrementing n - 1 elements by 1. This could be converted to "decrement 1 element by 1".
public class Solution {
    public int minMoves(int[] nums) {
        int res = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            min = Math.min(nums[i], min);
        }
        for (int i = 0; i < nums.length; i++) {
            res += (nums[i] - min);
        }
        return res;
    }
}
 

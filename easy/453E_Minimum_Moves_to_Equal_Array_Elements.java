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
 * Difficulty: Easy; Company: .
 * Date: 03/13/2017
 */

// Solution from discussion.
// 给n-1个元素加1可以转换成给1个元素减1， 所以只需要计算需要最小值，
// 让所有的元素最终等于min，即累加每个元素变成min所需要的总操作次数。
public class Solution {
    public int minMoves(int[] nums) {
        int length = nums.length;
        int count = 0;
        int min = nums[0];
        for (int i = 1; i < length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        for (int i = 0; i < length; i++) {
            count = count + nums[i] - min;
        }
        return count;
    }
}
 
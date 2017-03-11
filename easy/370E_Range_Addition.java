/**
 * Question description: Assume you have an array of length n initialized with all 0's and are given k update operations.
 * 		Each operation is represented as a triplet: [startIndex, endIndex, inc] which increments each element of subarray 
 * 		A[startIndex ... endIndex] (startIndex and endIndex inclusive) with inc.
 * 		Return the modified array after all k operations were executed.
 * Example: 
 *	 Given:
 *	    length = 5,
 *	    updates = [
 *	        [1,  3,  2],
 *	        [2,  4,  3],
 *	        [0,  2, -2]
 *	    ]
 *
 *	 Output: [-2, 0, 3, 5, 3]
 *
 * Explanation:
 *	Initial state: [ 0, 0, 0, 0, 0 ]
 *	After applying operation [1, 3, 2]: [ 0, 2, 2, 2, 0 ]
 *	After applying operation [2, 4, 3]: [ 0, 2, 5, 5, 3 ]
 *	After applying operation [0, 2, -2]: [-2, 0, 3, 5, 3 ]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/10/2017
 */

// Hint:
// For each update operation, do you really need to update all elements between i and j?
// Update only the first and end element is sufficient.
// The optimal time complexity is O(k + n) and uses O(1) extra space.
// 这道题的提示说了我们肯定不能把范围内的所有数字都更新，而是只更新开头结尾两个数字就行了，
// 那么我们的做法就是在开头坐标startIndex位置加上inc，而在结束位置加1的地方加上-inc.

// Solution from discussion.
public class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int row = updates.length;
        int[] result = new int[length];
        for (int i = 0; i < row; i++) {
            int start = updates[i][0];
            int end = updates[i][1];
            int addition = updates[i][2];
            result[start] += addition;
            if (end < length - 1) {
                result[end + 1] += -addition;
            }
        }
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += result[i];
            result[i] = sum;
        }
        return result;
    }
}


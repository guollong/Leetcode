/**
 * Question description: Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example: Input: [1,1,0,1,1,1]; Output: 3
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int tempCount = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tempCount++;
                if (tempCount > maxCount) {
                    maxCount = tempCount;
                }
            } else {
                tempCount = 0;
            }
        }
        return maxCount;
    }
}



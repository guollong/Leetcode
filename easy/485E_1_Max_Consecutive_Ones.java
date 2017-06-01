/**
 * Question description: Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example: Input: [1,1,0,1,1,1]; Output: 3
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

// 在 nums[i] = 1 时判断 maxCount.
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

// 在 nums[i] = 0 时判断 maxCount.
public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int maxCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (maxCount < count) {
                    maxCount = count;
                }
                count = 0;
            } else {
                count++;
            }
        }
        if (maxCount < count) {
            maxCount = count;
        }
        return maxCount;
    }
}

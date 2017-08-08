/**
 * Question description: Given an array S of n integers, find three integers in S such that 
 *		the sum is closest to a given number, target. Return the sum of the three integers. 
 *		You may assume that each input would have exactly one solution.
 *
 * Example, given array S = {-1 2 1 -4}, and target = 1.
 *		The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg.
 */

/**
 * Progress...
 * Create Date: 06/20/2017
 */

// Similiar to question 15 (3sum).
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int resSum = 0;
        int minDiff = Integer.MAX_VALUE;
        // Compute the triplets sum which contains element i and has the closest sum with target.
        for (int i = 0; i < nums.length - 2; i++) {
        	// Actually, there is no need to avoid duplicate in this question.
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0;
                while (left < right) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum == target) {
                        return sum;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                    if (minDiff > Math.abs(sum - target)) {
                        minDiff = Math.abs(sum - target);
                        resSum = sum;
                    }
                }
            }
        }
        return resSum;
    }
}


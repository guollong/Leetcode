/**
 * Question description: Given an array of n integers nums and a target, find the number of index triplets i, j, k 
 *		with 0 <= i < j < k < n that satisfy the condition nums[i] + nums[j] + nums[k] < target.
 *
 * Example, given nums = [-2, 0, 1, 3], and target = 2. Return 2. 
 *		Because there are two triplets which sums are less than 2:
 *	 	[-2, 0, 1]
 *	 	[-2, 0, 3]
 * Follow up: Could you solve it in O(n2) runtime?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 09/05/2017
 */

// Two pointers. The similiar as the 3 sum.
class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            // For given left, find the most right index that satisfy the requirement.
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    count += (right - left);
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return count;
    }
}


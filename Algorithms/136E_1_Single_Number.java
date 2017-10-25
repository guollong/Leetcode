/**
 * Question description: Given an array of integers, every element appears twice except for one. Find that single one.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Palantir, Airbnb.
 */


/**
 * Progress...
 * Create Date: 03/02/2017
 * Update Date: 05/30/2017
 * Update Date: 10/25/2017
 */

// Method 1: bit manipulation.
public class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}

// Method 2: Arrays.sort(nums)
public class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int sum = nums[0];
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            if (nums[i] == nums[i - 1]) {
                nums[i] = -nums[i];
            }
            sum += nums[i];
        }
        return sum;
    }
}

// Method 3: HashMap (不好)





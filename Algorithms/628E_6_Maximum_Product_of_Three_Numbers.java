/**
 * Question description: Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * 
 * Example 1: Input: [1,2,3]; Output: 6
 * Example 2: Input: [1,2,3,4]; Output: 24
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Intuit.
 */

/**
 * Progress...
 * Create Date: 08/08/2017
 */

// Solution 1: Simply find out the three largest numbers and the two smallest numbers using one pass.
// Running time complexity: O(n);
public class Solution {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
}

// Solution 2: Simply find out the three largest numbers and the two smallest numbers using one pass.
// Running time complexity: O(n * logn);
public class Solution {
    public int maximumProduct(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        int length = nums.length;
        Arrays.sort(nums);
        int first = nums[0] * nums[1] * nums[length - 1];
        int second = nums[length - 1] * nums[length - 2] * nums[length - 3];
        return Math.max(first, second);
    }
}





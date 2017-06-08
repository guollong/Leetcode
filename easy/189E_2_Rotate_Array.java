/**
 * Question description: Rotate an array of n elements to the right by k steps.
 *
 * Example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * 
 * Note: Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *		(但是我只知道两种，第三种不理解)
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Microsoft, Bloomberg.
 */

/**
 * Progress...
 * Create Date: 06/07/2017
 */

// Solution1: O(n) time cost, O(1) space cost
public class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length <= 1){
            return;
        }
        int step = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, step - 1);
        reverse(nums, step, nums.length - 1);
    }
    
    //reverse int array from n to m
    public void reverse(int[] nums, int n, int m){
        while(n < m){
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
            n++;
            m--;
        }
    }
}

// Solution1: O(n) time cost, O(k) space cost
public class Solution {
    public void rotate(int[] nums, int k) {
        // Attention: when the k is greater than the length of the array.
        k = k % nums.length;
        int[] temp = new int[nums.length];
        System.arraycopy(nums, 0, temp, k, nums.length - k);
        System.arraycopy(nums, nums.length - k, temp, 0, k);
        System.arraycopy(temp, 0, nums, 0, nums.length);
    }
}



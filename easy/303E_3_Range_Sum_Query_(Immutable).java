/**
 * Question description: Given an integer array nums, find the sum of the elements between
 *		indices i and j (i ≤ j), inclusive.
 *
 * Example: Given nums = [-2, 0, 3, -5, 2, -1]
 *			sumRange(0, 2) -> 1
 *			sumRange(2, 5) -> -1
 *			sumRange(0, 5) -> -3
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Palantir.
 */

/**
 * Progress...
 * Create Date: 06/09/2017
 */

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */

// Solution 1: create a new sum array take the sum of elements before certain index.
public class NumArray {
    private int[] sums;
    
    public NumArray(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = nums[i] + sums[i - 1];
        }
    }
    
    public int sumRange(int i, int j) {
        if (i == 0) {
            return sums[j];
        }
        return sums[j] - sums[i - 1];
    }
}

// Solution 2: brute force solution. Time limit exceeded.
public class NumArray {
    
    private final int[] numbers;
    
    public NumArray(int[] nums) {
        numbers = new int[nums.length];
        int i = 0;
        for (int element : nums) {
            numbers[i++] = element;
        }
    }
    
    public int sumRange(int i, int j) {
        int count = 0;
        int threshold = i + (j - i + 1) / 2;
        for (int m = i; m < threshold; m++) {
            count += numbers[m];
            count += numbers[j - (m - i)];
        }
        if ((j - i) % 2 == 0) {
            count += numbers[threshold];
        }
        return count;
    }
}





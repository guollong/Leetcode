/**
 * Question description: Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, 
 *				find the one that is missing from the array.
 *
 * Example: Given nums = [0, 1, 3] return 2.
 *
 * Note: Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Microsoft, Bloomberg.
 * Create Date: 03/26/2017
 * Update date: 05/31/2017
 */

// Sum solution. (O(n))
public class Solution {
    public int missingNumber(int[] nums) {
        int length = nums.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        return (length + 1) * length / 2 - sum;
    }
}

// Bit manipulation: a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
// In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, 
// the index and value should be perfectly corresponding(nums[index] = index), so in a missing array, what left finally is the missing number.
public class Solution {
	public int missingNumber(int[] nums) { //xor
	    int res = nums.length;
	    for(int i=0; i<nums.length; i++){
	        res ^= i;
	        res ^= nums[i];
	    }
	    return res;
	}
}

// Binary search solution: use left and right pointer(循环条件：left < right).
// If the array is already sorted, could consider using binary search.
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length;
        int mid;
        while (left < right) {
            mid = (right + left) / 2;
            if (nums[mid] > mid) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}









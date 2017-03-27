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
 * Difficulty: Easy; Company: .
 * Date: 03/26/2017
 */

// Jinglong's original solution.
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return i;
    }
}

// Binary search solution: use left and right pointer(循环条件：left < right).
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

// XOR solution: a^b^b =a, which means two xor operations with the same number will eliminate the number and reveal the original number.
// In this solution, I apply XOR operation to both the index and value of the array. In a complete array with no missing numbers, 
// the index and value should be perfectly corresponding(nums[index] = index), so in a missing array, what left finally is the missing number.
public class Solution {
	public int missingNumber(int[] nums) { //xor
		// 因为数组中最大的数为length，而数组中的index不可能为length。能相互对应的数都可以相互抵消，最终只剩下了缺失的值。
	    int res = nums.length;
	    for(int i=0; i<nums.length; i++){
	        res ^= i;
	        res ^= nums[i];
	    }
	    return res;
	}
}

// Sum solution.
public class Solution {
	public int missingNumber(int[] nums) { //sum
	    int len = nums.length;
	    // 等差数列求和，0为第一个元素，len为最后一个元素，一共有len+1个数, (first+last) * number / 2 = (0+len)*(len+1)/2;
	    int sum = (0+len)*(len+1)/2;
	    for(int i=0; i<len; i++)
	        sum-=nums[i];
	    return sum;
	}
}














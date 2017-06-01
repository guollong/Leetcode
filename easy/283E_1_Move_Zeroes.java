/**
 * Question description: Given an array of integers, move all zeros to the end of the array
 * 				with placing the previous values.
 * Example: nums = [0, 1, 0, 3, 12]; result: nums should be [1, 3, 12, 0, 0].
 * 
 * Notes: 1. You must do this in-place without making a copy of the array.
 *        2. Minimize the total number of operations.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook, Bloomberg.
 * Create Date: 03/09/2017
 * Update date: 05/31/2017
 */

// Array replacement. (根本没有必要新建一个array)
public class Solution {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                nums[count++] = nums[i];
            }
        }
        for (;count < length; count++) {
            nums[count] = 0;
        }
    }
}

// Queue implementation.
// Note the size of the queue is always changing while poping the elements out.
public class Solution {
    public void moveZeroes(int[] nums) {
        Queue<Integer> queue = new LinkedList<>();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] != 0) {
                queue.add(nums[i]);
            }
        }
        int i;
        int lengthQueue = queue.size();
        for (i = 0; i < lengthQueue; i++) {
            nums[i] = queue.remove();
        }
        for (; i < length; i++) {
            nums[i] = 0;
        }
    }
}

// Original 2-layer for loop method. (O(N^2))
public class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if (nums[i] == 0) {
                int j = i;
                while (j < length - 1) {
                    nums[j] = nums[j + 1];
                    j++;
                }
                nums[j] = 0;
                i--;
                length = length - 1;
            }
        }
    }
}






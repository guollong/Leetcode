/**
 * Question description: Given an array of integers, move all zeros to the end of the array
 * 				with placing the previous values.
 * Example: nums = [0, 1, 0, 3, 12]; result: nums should be [1, 3, 12, 0, 0].
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/09/2017
 */

// Jinglong's another solution: array replacement.
// 其实都没有必要用高级数据结构嘛～～～不开心
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

// Jinglong's method: queue implementation.
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


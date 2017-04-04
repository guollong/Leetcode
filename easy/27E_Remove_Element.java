/**
 * Question description: Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example: Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 04/03/2017
 */

public class Solution {
    public int removeElement(int[] nums, int val) {
        int totalNum = nums.length;
        for (int i = 0; i < totalNum; i++) {
            if (nums[i] == val) {
                totalNum--;
                nums[i] = nums[totalNum];
                i--;
            }
        }
        return totalNum;
    }
}

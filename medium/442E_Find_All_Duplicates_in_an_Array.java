/**
 * Question description: Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), 
 * 		some elements appear twice and others appear once.
 * 		Find all the elements that appear twice in this array.
 * 		Could you do it without extra space and in O(n) runtime?
 * Example:
 * Input: [4,3,2,7,8,2,3,1]
 * Output: [2,3]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/10/2017
 */

// 1 ≤ a[i] ≤ n: 可以保证值和index相互对应。
// 第一次访问的时候，将value - 1对应的index的值设置成负数，
// 当再次访问到该index所对应的值时，即为duplicate value.
// Notes: 设置为负数只是一个元素是否出现过的标志。

public class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                result.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return result;
    }
}


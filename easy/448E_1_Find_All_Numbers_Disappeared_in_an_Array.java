/**
 * Question description: Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * 			Find all the elements of [1, n] inclusive that do not appear in this array.
 * Notes: Without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 * Example: Input: [4,3,2,7,8,2,3,1]; Output: [5,6]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/03/2017
 */

// index对应着从1到数组大小的有序整数-1，nums为测试数组，处理好对应关系，将出现过的value都设置为其对应的负值， 
// 最终数组中的正数即为缺失的数。
public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> output = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++) {
            // 对应到index上，因为最大值的index是其减1的值，要不然会越界。
            int val = Math.abs(nums[i]) - 1; 
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                output.add(i + 1);
            }
        }
        return output;
    }
}








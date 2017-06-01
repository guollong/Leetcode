/**
 * Question description: You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * 						 Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *    The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, output -1 for this number.
 * 
 * Example 1: Input: nums1 = [4,1,2], nums2 = [1,3,4,2]; Output: [-1,3,-1]
 * Example 2: nums1 = [2,4], nums2 = [1,2,3,4]; Output: [3,-1]
 * Note: All elements in nums1 and nums2 are unique.
 * 		 The length of both nums1 and nums2 would not exceed 1000.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 02/24/2017
 */
public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < findNums.length; i++) {
            int index = map.get(findNums[i]);
            int j = index + 1;
            for (; j < nums.length; j++) {
                if (findNums[i] < nums[j]) {
                    res[i] = nums[j];
                    break;
                }
            }
            if (j == nums.length) {
                res[i] = -1;
            }
        }
        return res;
    }
}

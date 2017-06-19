/**
 * Question description: Given a set of distinct integers, nums, return all possible subsets.
 * 
 * Example: If nums = [1,2,3], a solution is: [[3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], []]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Uber, Facebook.
 */

/**
 * Progress...
 * Create Date: 06/18/2017
 */

// Jiuzhang 算法推荐排列组合模版～
// This is a combination problem, so we have variable "pos" to avoid taking the same value.
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsHelper(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }
    
    // get the subsets starting from list.
    private void subsetsHelper(int[] nums, List<Integer> list, int pos, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(nums, list, i + 1, result);
            list.remove(list.size() - 1);
        }
    }
}




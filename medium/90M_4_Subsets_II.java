/**
 * Question description: Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 *
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example: If nums = [1,2,2], a solution is: [[2], [1], [1,2,2], [2,2], [1,2], []]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 06/18/2017
 */

// Solved by jiuzhang permutation template. 
// In case of the above example, if we use tree structure to visulize the process of this method. Because 
// the solution set cannot contain duplicate subsets, there are only two leaves (starting with 1 or 2).
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupHelper(result, nums, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void subsetsWithDupHelper(List<List<Integer>> result, int[] nums, int pos, List<Integer> list) {
        result.add(new ArrayList<Integer>(list));
        for (int i = pos; i < nums.length; i++) {
            if (i != pos && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDupHelper(result, nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}




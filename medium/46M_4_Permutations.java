/**
 * Question description: Given a collection of distinct numbers, return all possible permutations.
 * 
 * Example: If nums = [1,2,3] have the following permutations:
 * [[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/18/2017
 */

// Solved by jiuzhang permutation template.
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(result, nums, new ArrayList<>(), nums.length);
        return result;
    }
    
    private void permuteHelper(List<List<Integer>> result, int[] nums, List<Integer> list, int length) {
        if (list.size() == length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            permuteHelper(result, temp, list, length);
            list.remove(list.size() - 1);
        }
    }
}





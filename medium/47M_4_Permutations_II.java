/**
 * Question description: Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * 
 * Example: If nums = [1,1,2] have the following permutations:
 * [[1,1,2], [1,2,1], [2,1,1]]
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
// This question is the combination of the question 90(subset with duplicates) and question 46(permutations)
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        permuteUniqueHelper(result, nums, new ArrayList<>(), nums.length);
        return result;
    }
    
    private void permuteUniqueHelper(List<List<Integer>> result, int[] nums, List<Integer> list, int length) {
        if (list.size() == length) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            int[] temp = new int[nums.length - 1];
            System.arraycopy(nums, 0, temp, 0, i);
            System.arraycopy(nums, i + 1, temp, i, nums.length - i - 1);
            permuteUniqueHelper(result, temp, list, length);
            list.remove(list.size() - 1);
        }
    }
}



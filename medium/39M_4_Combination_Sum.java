/**
 * Question description: Given a set of candidate numbers (C) (without duplicates) and a target 
 *		number (T), find all unique combinations in C where the candidate numbers sums to T.
 * 
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * Example, given candidate set [2, 3, 6, 7] and target 7, 
 *	A solution set is: 
 *	[
 *	  [7],
 *	  [2, 2, 3]
 *	]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/21/2017
 */

// Backtracking problem. (jiuzhang template) 
// Similiar question: subsets, permutation, combination sum and parlindrome partition.

public class Solution {
    // Idea: Get all subsets of the candidates, return the set that sum to target.
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        combinationHelper(new ArrayList<Integer>(), candidates, 0, target, result);
        return result;
    }
    
    private void combinationHelper(List<Integer> list, int[] candidates, int pos, int target, List<List<Integer>> result) {
        // must contains this less than 0 check, otherwise, it will time limit exceeded.
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        }
        for (int i = pos; i < candidates.length; i++) {
            list.add(candidates[i]);
            // Attention: start again from i, because we can reuse the element.
            combinationHelper(list, candidates, i, target - candidates[i], result);
            list.remove(list.size() - 1);
        }
    }
}


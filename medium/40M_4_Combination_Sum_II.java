/**
 * Question description: Given a collection of candidate numbers (C) and a target number (T), 
 *		find all unique combinations in C where the candidate numbers sums to T.
 * 		Each number in C may only be used once in the combination.
 * 
 * Note: The solution set must not contain duplicate combinations.
 * 
 * Example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8, 
 * A solution set is: 
 *	[
 *	  [1, 7],
 *	  [1, 2, 5],
 *	  [2, 6],
 *	  [1, 1, 6]
 *	]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: snapchat.
 */

/**
 * Progress...
 * Create Date: 06/21/2017
 */

// Backtracking problem. (jiuzhang template) 
// Similiar question: subsets, permutation, combination sum and parlindrome partition.

public class Solution {
    // Idea: Get all subsets of the candidates, return the set that sum to target.
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            list.add(candidates[i]);
            combinationHelper(list, candidates, i + 1, target - candidates[i], result);
            list.remove(list.size() - 1);
        }
    }
}




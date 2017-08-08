/**
 * Question description: Find all possible combinations of k numbers that add up to a number n, 
 *		given that only numbers from 1 to 9 can be used and each combination should be a unique 
 *		set of numbers.
 *
 * Example 1: Input: k = 3, n = 7; Output: [[1,2,4]]
 * Example 2: Input: k = 3, n = 9; Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/21/2017
 */

// Backtracking problem. (jiuzhang template) 
// Similiar question: subsets, permutation, combination sum and parlindrome partition.

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        combinationHelper(n, k, 0, new ArrayList<>(), result);
        return result;
    }
    
    private void combinationHelper(int n, int k, int pos, List<Integer> list, List<List<Integer>> result) {
        if (list.size() > k || n < 0) {
            return;
        }
        if (n == 0 && list.size() == k) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = pos; i < 9; i++) {
            list.add(i + 1);
            combinationHelper(n - i - 1, k, i + 1, list, result);
            list.remove(list.size() - 1);
        }
    }
}



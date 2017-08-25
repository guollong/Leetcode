/**
 * Question description: Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * 
 * Example: If n = 4 and k = 2, a solution is:
 *	[
 *	  [2,4],
 *	  [3,4],
 *	  [2,3],
 *	  [1,2],
 *	  [1,3],
 *	  [1,4],
 *	]
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 08/24/2017
 */

// Solution 1: Similiar to permutation question. (Backtracking)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        combineHelper(result, n, 1, k, new ArrayList<Integer>());
        return result;
    }
    
    private void combineHelper(List<List<Integer>> result, int n, int start, int k, List<Integer> list) {
        if (k == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for (int i = start; i <= n - k + 1; i++) {
            list.add(i);
            combineHelper(result, n, i + 1, k - 1, list);
            list.remove(list.size() - 1);
        }
    }
}

// Solution 2: Com(n,k) = Com(n-1,k-1) + Com(n-1,k).
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result;

        // base case.
        if (k == n || k == 0) {
            List<Integer> row = new ArrayList<>();
            for (int i = 1; i <= k; i++) {
                row.add(i);
            }
            result = new ArrayList<>();
            result.add(row);
            return result;
        }
        
        // recursive case.
        // number n is selected, select k - 1 from n - 1 nexts;
        result = combine(n - 1, k - 1);
        for (List<Integer> list : result) {
            list.add(n);
        }
        
        // number n is not selected, select k from n - 1 nexts;
        result.addAll(combine(n - 1, k));
        
        return result;
    }
}





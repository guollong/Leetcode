/**
 * Question description: Numbers can be regarded as product of its factors. For example,
 * 		8 = 2 x 2 x 2 = 2 x 4.
 *		Write a function that takes an integer n and return all possible combinations of its factors.
 * 
 * Note: You may assume that n is always positive.
 *	     Factors should be greater than 1 and less than n.
 *
 * Example 1: input: 1; output: []
 * Example 2: input: 37; output: []
 * Example 3: input: 12
 *		output:
 *		[
 *		  [2, 6],
 *		  [2, 2, 3],
 *		  [3, 4]
 * 		]
 * Example 4: input: 32
 *		output:
 *		[
 *		  [2, 16],
 *		  [2, 2, 8],
 *		  [2, 2, 2, 4],
 *	 	  [2, 2, 2, 2, 2],
 *		  [2, 4, 4],
 *		  [4, 8]
 *		]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn, Uber.
 */

/**
 * Progress...
 * Create Date: 09/06/2017
 */

// Solution 1: backtracking.
class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<Integer>(), n, 2);
        return result;
    }
    
    private void helper(List<List<Integer>> result, List<Integer> item, int n, int start) {
        if (n <= 1) {
            if (item.size() > 1) {
                result.add(new ArrayList<Integer>(item));
                return;
            }
        }
    
        for (int i = start; i <= n; i++) {
            if (n % i == 0) {
                item.add(i);
                helper(result, item, n / i, i);
                item.remove(item.size() - 1);
            }
        }
    }
}

// Solution 2: Divide and conquer. (My own solution.)
class Solution {
    private Set<List<Integer>> set = new HashSet<>();
    private Map<Integer, List<List<Integer>>> map = new HashMap<>();
        
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        
        // base case.
        if (isPrime(n)) {
            return result;
        }
        
        // recursive case.
        int threshold = (int) Math.sqrt(n);
        for (int i = 2; i <= threshold; i++) {
            if (n % i != 0) {
                continue;
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(i);
            list.add(n / i);
            Collections.sort(list);
            if (set.add(list)) {
                result.add(list);
            }
            
            List<List<Integer>> sublist;
            if (map.containsKey(n / i)) {
                sublist = map.get(n / i);
            } else {
                sublist = getFactors(n / i);
            }
            for (List<Integer> sub : sublist) {
                list = new ArrayList<>();
                list.add(i);
                list.addAll(sub);
                Collections.sort(list);
                if (set.add(list)) {
                    result.add(list);
                }
            }
        }
        if (!map.containsKey(n)) {
            map.put(n, result);
        }
        return result;
    }
    
    private boolean isPrime(int number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}









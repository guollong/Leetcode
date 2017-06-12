/**
 * Question description: Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 *      Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Example 2: Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LinkedIn.
 */

/**
 * Progress...
 * Create Date: 02/02/2017
 * Update Date: 06/12/2017
 */


/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */

// Solution 1: recursive method.
public class Solution {
    
    public int depthSum(List<NestedInteger> nestedList) {
        return depthSumHelper(nestedList, 1);
    }
    
    private int depthSumHelper(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (int i = 0; i < nestedList.size(); i++) {
            NestedInteger temp = nestedList.get(i);
            if (temp.isInteger()) {
                sum = sum + depth * temp.getInteger();
            } else {
                List<NestedInteger> sublist = temp.getList();
                sum += depthSumHelper(sublist, depth + 1);
            }
        }
        return sum;
    }
}


// Solution 2: while loop using queue.
public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        if (nestedList == null) {
            return 0;
        }
        
        int sum = 0;
        int level = 1;
        
        Queue<NestedInteger> queue = new LinkedList<>(nestedList);
        while (queue.size() > 0){
            int size = queue.size();
            
            for (int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();
                
                if (ni.isInteger()) {
                    sum += ni.getInteger() * level;
                } else {
                    queue.addAll(ni.getList());
                }
            }
            level++;
        }
        return sum;
    }
}






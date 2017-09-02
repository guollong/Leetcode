/**
 * Question description: Given a nested list of integers, implement an iterator to flatten it. Each element is 
 *		either an integer, or a list -- whose elements may also be integers or other lists.
 * 
 * Example 1: Given the list [[1,1],2,[1,1]], the order of elements returned by next should be: [1,1,2,1,1].
 * Example 2: Given the list [1,[4,[6]]], the order of elements returned by next should be: [1,4,6].
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Facebook, Twitter.
 */

/**
 * Progress...
 * Create Date: 09/02/2017
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

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Using stack.
public class NestedIterator implements Iterator<Integer> {

    private Stack<NestedInteger> stack = new Stack<>();
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        // hasNext only returns true when the top element of the stack is an integer.
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.isEmpty()) {
            // If the top element is an integer, return true;
            NestedInteger curr = stack.peek();
            if (curr.isInteger()) {
                return true;
            }
            
            // If the top element is a list, push all elements in this list to the stack in reverse order.
            stack.pop();
            for (int i= curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
    
}




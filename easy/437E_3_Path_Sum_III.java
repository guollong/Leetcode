/**
 * Question description: You are given a binary tree in which each node contains an integer value.
 *		Find the number of paths that sum to a given value.
 *		The path does not need to start or end at the root or a leaf, but it must go downwards 
 *		(traveling only from parent nodes to child nodes).
 * 
 * Example: root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *		      10
 *		     /  \
 *		    5   -3
 *		   / \    \
 *		  3   2   11
 *		 / \   \
 *		3  -2   1
 * Return 3. The paths that sum to 8 are: 1.  5 -> 3; 2.  5 -> 2 -> 1; 3. -3 -> 11
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/15/2017
 */

// Solution 1: Simple AC Java Solution DFS
// Each time find all the path start from current node
// Then move start node to the child and repeat.
// Time Complexity should be O(N^2) for the worst case and O(NlogN) for balanced binary Tree.
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    
    // get the number of paths which start from root and its elements sum to 'sum'.
    public int findPath(TreeNode root, int sum) {
        int res = 0;
        if (root == null) {
            return 0;
        }
        if (sum == root.val) {
            res++;
        }
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }
}

// Couldn't understand.............................

// Solution 2: The idea is similar as Two sum, using HashMap to store ( key : the prefix sum, 
// 	value : how many ways get to this prefix sum) , and whenever reach a node, we check if 
// 	prefix sum - target exists in hashmap or not, if it does, we added up the ways of prefix sum - target into res.
// 	For instance : in one path we have 1,2,-1,-1,2, then the prefix sum will be: 1, 3, 2, 1, 3, 
// 	let's say we want to find target sum is 2, then we will have{2}, {1,2,-1}, {2,-1,-1,2} and {2}ways.
public class Solution {
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> preSum = new HashMap();
        preSum.put(0,1);
        return helper(root, 0, sum, preSum);
    }
    
    public int helper(TreeNode root, int currSum, int target, HashMap<Integer, Integer> preSum) {
        if (root == null) {
            return 0;
        }
        
        currSum += root.val;
        int res = preSum.getOrDefault(currSum - target, 0);
        preSum.put(currSum, preSum.getOrDefault(currSum, 0) + 1);
        
        res += helper(root.left, currSum, target, preSum) + helper(root.right, currSum, target, preSum);
        preSum.put(currSum, preSum.get(currSum) - 1);
        return res;
    }
}






/**
 * Question description: Note: This is an extension of House Robber. Instead of robbing houses along a street, 
 *		this time the houses form a circle, that is the last house is the neighbor of the first house. The same 
 *		as the first question, return the maximum amount of money that the robber could rob.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Uber. 
 */

/**
 * Progress...
 * Create Date: 08/19/2017
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1: Brute force dfs (recursion).
class Solution {
    public int rob(TreeNode root) {
        // base case.
        if (root == null) {
            return 0;
        }
        
        // recursive case.
        // Rob the root house.
        int takeRoot = root.val;
        if (root.left != null) {
            takeRoot += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            takeRoot += rob(root.right.left) + rob(root.right.right);
        }
        
        // Not rob the root house.
        int notTakeRoot = rob(root.left) + rob(root.right);

        return Math.max(takeRoot, notTakeRoot);
    }
}


// Solution 2: Memorization dfs.
class Solution {
    
    public int rob(TreeNode root) {
        return robHelper(root, new HashMap<TreeNode, Integer>());
    }
    
    private int robHelper(TreeNode root, Map<TreeNode, Integer> map) {
        // base case.
        if (root == null) {
            return 0;
        }
        if (map.containsKey(root)) {
            return map.get(root);
        }
        
        // recursive case.
        // Rob the root house.
        int takeRoot = root.val;
        if (root.left != null) {
            takeRoot += robHelper(root.left.left, map) + robHelper(root.left.right, map);
        }
        if (root.right != null) {
            takeRoot += robHelper(root.right.left, map) + robHelper(root.right.right, map);
        }
        
        // Not rob the root house.
        int notTakeRoot = robHelper(root.left, map) + robHelper(root.right, map);
        int result = Math.max(takeRoot, notTakeRoot);

        map.put(root, result);
        return result;
    }
}




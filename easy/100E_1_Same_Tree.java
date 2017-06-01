/**
 * Question description: Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Bloomberg.
 */

/**
 * Progress...
 * Create Date: 03/25/2017
 * Update Date: 05/30/2017 (final version)
 */

/**
 * Methodology: (recursion)
 * base case: 
       If two nodes are null, return true;
       If one of the nodes is null or the value of two nodes are different, return false;
 * recursive case:
       Return isSameTree(left, left) && isSameTree(right, right).
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

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // base case.
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        
        // recursive case.
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}

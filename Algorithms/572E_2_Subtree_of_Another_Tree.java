/**
 * Question description: Given two non-empty binary trees s and t, check whether tree t has 
 *		exactly the same structure and node values with a subtree of s. A subtree of s is a 
 *		tree consists of a node in s and all of this node's descendants. The tree s could 
 *		also be considered as a subtree of itself.
 *
 * Example: 
 *	Given tree s:
 *	    3
 *	   / \
 *	  4   5
 *	 / \
 *	1   2
 * Given tree t:
 *	  4 
 *	 / \
 *	1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Facebook, eBay.
 */

/**
 * Progress...
 * Create Date: 06/02/2017
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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return false;
        }
        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (t == null || s == null || s.val != t.val) {
            return false;
        }
        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}




/**
 * Question description: Given a binary search tree and a node in it, find the in-order successor of that node in the BST.
 *
 * Note: If the given node has no in-order successor in the tree, return null.
 *
 * Follow up: How to find a predecessor of a node in a tree ?? 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems, Microsoft, Facebook. 
 */

/**
 * Progress...
 * Create Date: 08/03/2017
 * Update Date: 10/25/2017
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

// Solution 1: Iterative method: 
//      Just like a binary search. Only update the successor while going left since the parent is always 
//      greater than left child, so the parent could be a successor.
public class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode succ = null;
        while (root != null) {
            if (p.val < root.val) {
                succ = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return succ;
    }
}

// Solution 2: Recursive method of finding successor.
public class Solution {
	public TreeNode successor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		if (root.val <= p.val) {
		    return successor(root.right, p);
		} else {
		    TreeNode left = successor(root.left, p);
		    return (left != null) ? left : root;
		}
	}
}

// Solution 2: Recursive method of finding perdecessor.
public class Solution {
	public TreeNode perdecessor(TreeNode root, TreeNode p) {
		if (root == null) {
			return null;
		}

		if (root.val >= p.val) {
		    return successor(root.left, p);
		} else {
		    TreeNode right = successor(root.right, p);
		    return (right != null) ? right : root;
		}
	}
}






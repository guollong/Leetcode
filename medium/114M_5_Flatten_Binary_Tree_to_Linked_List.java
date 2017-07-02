/**
 * Question description: Given a binary tree, flatten it to a linked list in-place.
 * 
 * Example: Given
 *	         1
 *	        / \
 *	       2   5
 *	      / \   \
 *	     3   4   6
 * The flattened tree should look like:
 *	   1
 *	    \
 *	     2
 *	      \
 *	       3
 *	        \
 *	         4
 *	          \
 *	           5
 *	            \
 *	             6
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft.
 */

/**
 * Progress...
 * Create Date: 07/01/2017
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

// Solution 1: Iterative method: 没看懂。。。。
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        while (root != null) {
            if (root.left == null) {
                root = root.right;
                continue;
            }
            TreeNode left = root.left;
            while (left.right != null) {
                left = left.right;
            }
            left.right = root.right;
            root.right = root.left;
            root.left = null;
            root = root.right;
        }
    }
}

// Solution 2: Recursive bottom-up reversed inorder traversal. The most right node comes out first.
public class Solution {
    private TreeNode prev = null;
    
    public void flatten (TreeNode root) {
        if (root == null) {
            return;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// Solution 3: Recursive method: 3 cases: no left node, no right node, and have both left and right nodes.
public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        flattenHelper(root);
    }
    
    private TreeNode flattenHelper(TreeNode node) {
        // base case.
        if (node == null || (node.left == null && node.right == null)) {
            return node;
        }
        
        // recursive case.
        if (node.left == null) {
            node.right = flattenHelper(node.right);
        } else if (node.right == null) {
            node.right = flattenHelper(node.left);
            node.left = null;
        } else {
            TreeNode temp = node.right;
            node.right = flattenHelper(node.left);
            node.left = null;
            TreeNode curr = node.right;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.left = null;
            curr.right = flattenHelper(temp);
        }
        return node;
    }
}



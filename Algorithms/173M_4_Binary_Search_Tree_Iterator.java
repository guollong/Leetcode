/**
 * Question description: Implement an iterator over a binary search tree (BST). 
 *		Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 *		where h is the height of the tree.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn, Google, Facebook, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/29/2017
 */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

// Solution 1: My own method.
public class BSTIterator {
    TreeNode root = null;
    
    public BSTIterator(TreeNode root) {
        this.root = root;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (root != null) {
            return true;
        }
        return false;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode resultNode = null;
        // if root doesn't have left child.
        if (root.left == null) {
            resultNode = root;
            root = root.right;
        } else {
        	// find the most left child.
            TreeNode parent = null;
            TreeNode curr = root;
            while (curr.left != null) {
                parent = curr;
                curr = curr.left;
            }
            resultNode = curr;
            parent.left = curr.right;
        }
        return resultNode.val;
    }
}

// Solution 2: Using stack.
public class BSTIterator {

    private Stack<TreeNode> stack = new Stack<>();
        
    public BSTIterator(TreeNode root) {
        pushAll(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode tempNode = stack.pop();
        pushAll(tempNode.right);
        return tempNode.val;
    }
    
    private void pushAll(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
}



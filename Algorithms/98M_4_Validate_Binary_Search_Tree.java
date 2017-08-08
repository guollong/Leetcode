/**
 * Question description: Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 * 		The left subtree of a node contains only nodes with keys less than the node's key.
 *		The right subtree of a node contains only nodes with keys greater than the node's key.
 *		Both the left and right subtrees must also be binary search trees.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg, Facebook.
 */

/**
 * Progress...
 * Create Date: 06/28/2017
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
 
// Solution from jiuzhang. Perform inorder traversal, record the last value and compare with it. 
// 		If the last value is greater than the current value, return false.
public class Solution {
    private int lastVal = Integer.MIN_VALUE;
    private boolean isFirstNode = true;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (!isFirstNode && lastVal >= root.val) {
            return false;
        }
        isFirstNode = false;
        lastVal = root.val;
        
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
}

// Solution by myself: Perform inorder traversal first and check the order by looping over the inorder list. 
public class Solution {
    public boolean isValidBST(TreeNode root) {
        List<Integer> inorder = inorderTraversal(root);
        for (int i = 1; i < inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
    
    private List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);
        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}



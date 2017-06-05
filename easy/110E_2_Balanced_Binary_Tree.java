/**
 * Question description: Given a binary tree, determine if it is height-balanced.
 * 						 For this problem, a height-balanced binary tree is defined as a binary tree in 
 * 						 which the depth of the two subtrees of every node never differ by more than 1.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 02/24/2017
 * Update date: 06/04/2017
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
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = Math.abs(height(root.left) - height(root.right));
        return diff <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }
}




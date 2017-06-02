/**
 * Question description: Given a binary tree, you need to compute the length of the diameter of the tree. 
 *		The diameter of a binary tree is the length of the longest path between any two nodes in a tree. 
 *		This path may or may not pass through the root.
 *
 * Example: Given a binary tree 
 *        1
 *       / \
 *      2   3
 *     / \     
 *    4   5    
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
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

// For every node, length of longest path which pass it = MaxDepth of its left subtree + MaxDepth of its right subtree.
public class Solution {
    int max = 0;
    
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return max;
    }
    
    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        max = Math.max(left + right, max);
        return 1 + Math.max(left, right);
    }
}




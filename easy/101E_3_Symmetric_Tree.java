/**
 * Question description: Given a binary tree, check whether it is a mirror of itself.
 * 
 * Example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *		    1
 *		   / \
 *		  2   2
 *		 / \ / \
 *		3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *		    1
 *		   / \
 *		  2   2
 *		   \   \
 *		   3    3
 * Follow up: Bonus points for both recursive method and iterative method.
 * 但是我只完成了一种。。。。。。。。。。。。。。。。
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/14/2017
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
        return isSymmetricHelper(leftNode.right, rightNode.left) && isSymmetricHelper(leftNode.left, rightNode.right);
    }
}



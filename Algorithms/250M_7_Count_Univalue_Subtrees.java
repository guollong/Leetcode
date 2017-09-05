/**
 * Question description: Given a binary tree, count the number of uni-value subtrees. A Uni-value subtree means all 
 *		nodes of the subtree have the same value.
 *
 * Example: Given binary tree,
 *             5
 *            / \
 *           1   5
 *          / \   \
 *         5   5   5
 * return 4.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 09/04/2017
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

// 树的题目老是不会。。。。。
class Solution {
    public int countUnivalSubtrees(TreeNode root) {
        int[] count = {0};
        countUnivalSubtreesHelper(root, count);
        return count[0];
    }
    
    private boolean countUnivalSubtreesHelper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = countUnivalSubtreesHelper(node.left, count);
        boolean right = countUnivalSubtreesHelper(node.right, count);
        if (left && right) {
            if (node.left != null && node.left.val != node.val) {
                return false;
            }
            if (node.right != null && node.right.val != node.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
}




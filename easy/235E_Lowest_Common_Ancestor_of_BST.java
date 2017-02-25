/**
 * Question description: Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 *         _______6______
 *        /              \
 *    ___2__          ___8__
 *   /      \        /      \
 *  0       _4       7       9
 *         /  \
 *         3   5
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, 
 * since a node can be a descendant of itself according to the LCA definition.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
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

// 如果两个node不在同一边，共同祖先就是root。
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while ((root.val - p.val) * (root.val - q.val) > 0) {
            root = root.val > p.val ? root.left : root.right;
        }
        return root;
    }
}


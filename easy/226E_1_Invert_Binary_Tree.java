/**
 * Question description: Invert a binary tree.
 *     4
 *   /   \
 *  2     7
 * / \   / \
 *1   3 6   9	to
 *     4
 *   /   \
 *  7     2
 * / \   / \
 *9   6 3   1
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 * Date: 03/09/2017
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }
}


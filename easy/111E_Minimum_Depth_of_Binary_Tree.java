/**
 * Question description: Given a binary tree, find its minimum depth.
 * 		The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/26/2017
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

// path指的是从root到叶子的距离。
public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 如果其中一个child不存在，则只需要走一边儿即可。
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }
        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
    }
}






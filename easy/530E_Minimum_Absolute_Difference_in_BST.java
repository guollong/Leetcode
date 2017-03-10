/**
 * Question description: Given a binary search tree with non-negative values, 
 *          find the minimum absolute difference between values of any two nodes.
 * Example: Input:
 *  1
 *   \
 *    3
 *   /
 *  2
 *
 * Output: 1
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
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

// Jinglong's solution. 
// Idea: Provided a BST, traverse in-order to get an ascending ordered array.
//       then compare the distance between every two adjacency node, get the minimum value.
// Notes: 密切关注到底是BST, 还是普通的二叉树。

public class Solution {
    private List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            int distance = list.get(i) - list.get(i-1);
            if (distance < min) {
                min = distance;
            }
        }
        return min;
    }
    
    private void traversal(TreeNode root) {
        if (root == null) {
            return;
        }
        traversal(root.left);
        list.add(root.val);
        traversal(root.right);
    }
}
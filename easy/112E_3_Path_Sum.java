/**
 * Question description: Given a binary tree and a sum, determine if the tree has a 
 *		root-to-leaf path such that adding up all the values along the path equals the given sum.
 * 
 * Example: Given the below binary tree and sum = 22,
 *             5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \      \
 *      7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
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
 
// 这个方法厉害了，完全想不到呢。。。。。。。。。。。。。。。。。
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
    
        if (root.left == null && root.right == null && sum - root.val == 0) {
            return true;
        }
    
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}



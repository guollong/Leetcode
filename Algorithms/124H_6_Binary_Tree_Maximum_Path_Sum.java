/**
 * Question description: Given a binary tree, find the maximum path sum. For this problem, a path is defined as any 
 *		sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path 
 *		must contain at least one node and does not need to go through the root.
 * 
 * Example: Given the below binary tree,
 *      1
 *     / \
 *    2   3, Return 6.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Baidu, Pocket Gems.
 */

/**
 * Progress...
 * Create Date: 08/09/2017
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

// DFS: Get the maximum left path sum and right path sum, the current path sum equals to left + right + node.val.
// 		Update the maximum sum if necessary. 
public class Solution {

    private int maxSum = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxSum;
    }
    
    // Return the maximum path sum with highest node is the input node. Update the maxSum if necessary.
    // Current path sum = left + right + node.val.
    private int maxPathDown(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        maxSum = Math.max(maxSum, node.val + left + right);
        return Math.max(left, right) + node.val;
    }
}



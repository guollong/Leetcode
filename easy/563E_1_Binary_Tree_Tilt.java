/**
 * Question description: Given a binary tree, return the tilt of the whole tree.
 *		The tilt of a tree node is defined as the absolute difference between the 
 *		sum of all left subtree node values and the sum of all right subtree node values. 
 *		Null node has tilt 0.
 *
 *		The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *
 * Example: Input: 
 *       1
 *     /   \
 *    2     3
 * Output: 1
 * Explanation: Tilt of node 2 : 0; Tilt of node 3 : 0; Tilt of node 1 : |2-3| = 1; 
 *			Tilt of binary tree : 0 + 0 + 1 = 1
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

// Approach 1: 
public class Solution {
    private int sum = 0;
    
    public int findTilt(TreeNode root) {
        findTiltHelper(root);
        return sum;
    }
    
    // Return the sum of the subtree. At the same time, calculate the tilt of the tree.
    private int findTiltHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = findTiltHelper(root.left);
        int rightSum = findTiltHelper(root.right);
        sum += Math.abs(leftSum - rightSum);
        return root.val + leftSum + rightSum;
    }
}

// Approach 2: Similiar idea with the approach 1, but a different implementation.
public class Solution {
    private int sum = 0;
    
    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        sum += Math.abs(sumTree(root.left) - sumTree(root.right));
        findTilt(root.left);
        findTilt(root.right);
        return sum;
    }
    
    private int sumTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return root.val + sumTree(root.left) + sumTree(root.right);
    }
}







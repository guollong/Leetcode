/**
 * Question description: Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 *
 * Explaination: There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Date: 03/13/2017
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

// Idea: When the node is null, return 0. In every iteration, check if the left node 
//       is a leaf node(if it is, add its value to the result, if it isn't, recursively
//       call the function to the left node). Call the function to the right node.
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int ans = 0;
        if(root.left != null) {
            if (root.left.left == null && root.left.right == null) {
                ans += root.left.val;
            } else {
                ans += sumOfLeftLeaves(root.left);
            }
        }
        ans += sumOfLeftLeaves(root.right);
        
        return ans;
    }
}

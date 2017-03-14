/**
 * Question description: Find the sum of all left leaves in a given binary tree.
 * Notes: Each letter in the magazine string can only be used once in your ransom note.
 *
 * Example:
 *
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
 * Difficulty: Easy; Company: .
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
// Jinglong's solution.
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // if the node is null or it is a leaf node, return 0;
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        // if the node has both left subtree and right subtree.
        if (root.left != null && root.right != null) {
            if (isLeaf(root.left)) {
                return root.left.val + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
            }
            return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
        }
        // if the node only has left subtree.
        if (root.left != null && root.right == null) {
            if (isLeaf(root.left)) {
                return root.left.val + sumOfLeftLeaves(root.left);
            }
            return sumOfLeftLeaves(root.left);
        }
        // if the the node only has right subtree.
        return sumOfLeftLeaves(root.right);
    }
    
    // check if a node is a leaf.
    private boolean isLeaf(TreeNode node) {
        if (node.left == null && node.right == null) {
            return true;
        }
        return false;
    }
}

// Solution from discussion.
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
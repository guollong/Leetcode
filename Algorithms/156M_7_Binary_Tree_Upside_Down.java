/**
 * Question description: Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node 
 *		that shares the same parent node) or empty, flip it upside down and turn it into a tree where the original right
 *		nodes turned into left leaf nodes. Return the new root.
 *
 * Example: Given a binary tree {1,2,3,4,5},
 *	    1
 *	   / \
 *	  2   3
 *	 / \
 *	4   5
 * return the root of the binary tree [4,5,2,#,#,3,1].
 *	   4
 *	  / \
 *	 5   2
 *	    / \
 *	   3   1  
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn. 
 */

/**
 * Progress...
 * Create Date: 08/26/2017
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

// Idea: 
//       null                   null
//      /   \                  /
//     1    null    -->       1 --- null    --> return new root 4;
//    / \                    /
//   2   3                  2 --- 3
//  / \                    /
// 4   5                  4 --- 5

// Solution 1: Recursive method.
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // base case.
        if (root == null || root.left == null) {
            return root;
        }
        
        // recursive case.
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
}

// Solution 2: Iterative method.
class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode temp = null;   // the right child of the parent node.
        TreeNode next = null;
        
        while (curr != null) {
            next = curr.left;
            curr.left = temp;
            temp = curr.right;
            curr.right = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}




/**
 * Question description: Given a complete binary tree, count the number of nodes.
 * 		Definition of a complete binary tree from Wikipedia: In a complete binary tree every level, 
 *		except possibly the last, is completely filled, and all nodes in the last level are as far 
 *		left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/02/2017
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
// Check whether the left and right subtree have the same height.
// 1. If yes, then the last node on the last tree row is in the right subtree and the left subtree is a full tree of height h-1. So we take the 2^h-1 nodes of the left subtree plus the 1 root node plus recursively the number of nodes in the right subtree.
// 2. If no, then the last node on the last tree row is in the left subtree and the right subtree is a full tree of height h-2. So we take the 2^(h-1)-1 nodes of the right subtree plus the 1 root node plus recursively the number of nodes in the left subtree.

// Note: A full binary tree with height h has 2^h - 1 nodes.
// 		 Iterative method often faster than recursive method.
// In Java, C, and Python, recursion is fairly expensive compared to iteration (in general) because it requires the allocation of a new stack frame.

// Solution 1: Recursive method.
class Solution {
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        int count = 0;
        if (h <= 0) {
            return 0;
        } else {
            int rightHeight = getHeight(root.right);
            count = 1 << rightHeight;
            if (rightHeight == h - 1) {
                count += countNodes(root.right);
            } else {
                count += countNodes(root.left);
            }
        }
        return count;
    }
    
    private int getHeight (TreeNode node){
        int height = 0;
        while(node != null){
            node = node.left;
            height++;
        }
        return height;
    }
}


// Solution 2: Iterative method.
class Solution {
    public int countNodes(TreeNode root) {
        int h = getHeight(root);
        int count = 0;
        while (root != null) {
            int rightHeight = getHeight(root.right);
            count += 1 << rightHeight;
            if (rightHeight == h - 1) {
                root = root.right;
            } else {
                root = root.left;
            }
            h--;
        }
        return count;
    }
    
    private int getHeight (TreeNode node){
        int height = 0;
        while(node != null){
            node = node.left;
            height++;
        }
        return height;
    }
}








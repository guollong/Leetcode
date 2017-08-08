/**
 * Question description: Given a binary search tree, write a function kthSmallest to find the 
 *		kth smallest element in it.
 * 
 * Note: You may assume k is always valid, 1 ? k ? BST's total elements.
 * 
 * Follow up: What if the BST is modified (insert/delete operations) often and you need to find 
 *		the kth smallest frequently? How would you optimize the kthSmallest routine?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg, Uber, Google.
 */

/**
 * Progress...
 * Create Date: 06/29/2017
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
        
// Solution 1: Compare the number of nodes in the half tree with k.
// Running time complexity: O(logn)
public class Solution {
    public int kthSmallest(TreeNode root, int k) {
        
        int leftCount = count(root.left);
        if (leftCount >= k) {
            return kthSmallest(root.left, k);
        } else if (leftCount + 1 < k) {
            return kthSmallest(root.right, k - 1 - leftCount);
        }
        return root.val;
    }
    
    // Helper function: Count the number of nodes in a tree.
    private int count(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + count(root.left) + count(root.right);
    }
}

// Solution 2: Perform inorder traversal and return the kth element when hit the kth element.
// Running time complexity: O(k)
public class Solution {

    private static int number = 0;
    private static int count = 0;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorderTraversal(root);
        return number;
    }
    
    private void inorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTraversal(root.left);
        count--;
        if (count == 0) {
            number = root.val;
            return;
        }
        inorderTraversal(root.right);
    }
}







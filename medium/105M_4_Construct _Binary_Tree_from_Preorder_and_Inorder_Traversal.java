/**
 * Question description: Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg.
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

// Idea: Put the elements of inorder array and corresponding indices in a map. Every time, create 
// 		 the root using the first element of preorder array. Get its corresponding index in inorder
//		 array, and get the subarray of inorder array and preorder array for building the left child 
//		 and right child.
// Note: Please attention the base case.
public class Solution {
    private Map<Integer, Integer> indexMap = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2) {
        // Please attention the base case.
        if (start1 >= preorder.length || end1 >= preorder.length || start1 > end1) {
            return null;
        }
        if (start2 >= inorder.length || end2 < 0 || start2 > end2) {
            return null;
        }
        if (start1 == end1) {
            return new TreeNode(preorder[start1]);
        }

        TreeNode root = new TreeNode(preorder[start1]);
        int index = indexMap.get(preorder[start1]);
        int count = index - start2;
        root.left = buildTreeHelper(preorder, start1 + 1, start1 + count, inorder, start2, index - 1);
        root.right = buildTreeHelper(preorder, start1 + 1 + count, end1, inorder, index + 1, end2);
        return root;
    }
}


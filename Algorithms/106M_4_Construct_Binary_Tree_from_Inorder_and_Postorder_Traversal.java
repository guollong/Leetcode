/**
 * Question description: Given inorder and postorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft.
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
// 		 the root using the last element of postorder array. Get its corresponding index in inorder
//		 array, and get the subarray of inorder array and postorder array for building the left child 
//		 and right child.
// Note: Please attention the base case.
public class Solution {
    Map<Integer, Integer> indicesMap = new HashMap<>();
    
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length || inorder.length == 0) {
            return null;
        }
        for (int i = 0; i < inorder.length; i++) {
            indicesMap.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode buildTreeHelper(int[] inorder, int start1, int end1, int[] postorder, int start2, int end2) {
        if (start1 >= inorder.length || end1 < 0 || start1 > end1) {
            return null;
        }
        if (start2 >= postorder.length || end2 < 0 || start2 > end2) {
            return null;
        }
        if (start1 == end1) {
            return new TreeNode(inorder[end1]);
        }
        TreeNode root = new TreeNode(postorder[end2]);
        int index = indicesMap.get(postorder[end2]);
        int count = index - start1;
        root.left = buildTreeHelper(inorder, start1, index - 1, postorder, start2, start2 + count - 1);
        root.right = buildTreeHelper(inorder, index + 1, end1, postorder, start2 + count, end2 - 1);
        return root;
    }
}





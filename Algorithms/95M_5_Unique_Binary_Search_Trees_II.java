/**
 * Question description: Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * Example: Given n = 3, return a total of 5 unique BST's below.
 *	   1         3     3      2      1
 *	    \       /     /      / \      \
 *	     3     2     1      1   3      2
 *	    /     /       \                 \
 *	   2     1         2                 3
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Snapchat.
 */

/**
 * Progress...
 * Create Date: 07/07/2017
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

// Solution 1: Divide and conquer method.
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        return genTrees(1, n);
    }

    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        // base case.
        if (start > end) {
            list.add(null);
            return list;
        }
        
        // Get the list of possible left tree and right tree, use 2 layer for loop to combine them with the root.
        List<TreeNode> left;
        List<TreeNode> right;
        for (int i = start; i <= end; i++) {
            left = genTrees(start, i - 1);
            right = genTrees(i + 1, end);
            
            for (TreeNode lnode: left) {
                for (TreeNode rnode: right) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        
        return list;
    }
}

// Solution 2: Dynamic programming method. 
// !!!!!!!!!!!!!!!!!!!!! 这个方法神奇了，我们真的需要掌握吗？？？
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        // State: All structurally unique BST's that store values 1...i.
        List<TreeNode>[] result = new List[n + 1];
        
        // Initialization.
        result[0] = new ArrayList<TreeNode>();
        if (n == 0) {
            return result[0];
        }
        result[0].add(null);
        
        // Function.
        for (int len = 1; len <= n; len++) {
            result[len] = new ArrayList<TreeNode>();
            for (int j = 0; j < len; j++) {
                for (TreeNode nodeL : result[j]) {
                    for (TreeNode nodeR : result[len - j - 1]) {
                        TreeNode node = new TreeNode(j + 1);
                        node.left = nodeL;
                        node.right = clone(nodeR, j + 1);
                        result[len].add(node);
                    }
                }
            }
        }
        return result[n];
    }

    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}





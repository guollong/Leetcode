/**
 * Question description: Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example: Given binary tree [1,null,2,3],
 *	   1
 * 	    \
 *	     2
 *	    /
 *	   3
 * return [1,3,2].
 *
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/28/2017
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
 
// Solution 1: Iterative method (The most important)
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
    
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
    
        while (cur != null || !stack.empty()){
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
        return list;
    }
}

// Solution 2: Recursive method.
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorderTraversalHelper(root, result);
        return result;
    }
    
    private void inorderTraversalHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorderTraversalHelper(root.left, result);
        result.add(root.val);
        inorderTraversalHelper(root.right, result);
    }
}


// Solution 3: Divide and conquer method.
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = inorderTraversal(root.left);
        List<Integer> right = inorderTraversal(root.right);

        result.addAll(left);
        result.add(root.val);
        result.addAll(right);
        return result;
    }
}






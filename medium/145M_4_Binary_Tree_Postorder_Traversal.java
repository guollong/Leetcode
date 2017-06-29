/**
 * Question description: Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Note: Recursive solution is trivial, could you do it iteratively?
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
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

// Solution 1: Iterative method. (The most important) (preorder, inorder, postorder)
public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while(!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.add(p.val);  // Add before going to children
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                p = node.right;   
            }
        }
        return result;
    }
}

public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode node = stack.pop();
                result.add(node.val);    // Add after all left children
                p = node.right;   
            }
        }
        return result;
    }
}

public class Solution {
	public List<Integer> postorderTraversal(TreeNode root) {
	    LinkedList<Integer> result = new LinkedList<>();
	    Stack<TreeNode> stack = new Stack<>();
	    TreeNode p = root;

	    while (!stack.isEmpty() || p != null) {
	        if (p != null) {
	            stack.push(p);
	            result.addFirst(p.val);  // Reverse the process of preorder
	            p = p.right;             // Reverse the process of preorder
	        } else {
	            TreeNode node = stack.pop();
	            p = node.left;           // Reverse the process of preorder
	        }
	    }
	    return result;
	}
}


// Solution 2: Divide and conquer method.
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> left = postorderTraversal(root.left);
        List<Integer> right = postorderTraversal(root.right);
        result.addAll(left);
        result.addAll(right);
        result.add(root.val);
        return result;
    }
}

// Solution 3: Recursive method.
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        postorderTraversalHelper(root, result);
        return result;
    }
    
    private void postorderTraversalHelper(TreeNode node, List<Integer> result) {
        // base case.
        if (node == null) {
            return;
        }
        
        // recursive case.
        postorderTraversalHelper(node.left, result);
        postorderTraversalHelper(node.right, result);
        result.add(node.val);
    }
}




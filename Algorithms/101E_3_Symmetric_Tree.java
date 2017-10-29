/**
 * Question description: Given a binary tree, check whether it is a mirror of itself.
 * 
 * Example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *		    1
 *		   / \
 *		  2   2
 *		 / \ / \
 *		3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *		    1
 *		   / \
 *		  2   2
 *		   \   \
 *		   3    3
 * Follow up: Bonus points for both recursive method and iterative method.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: LinkedIn, Bloomberg, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/14/2017
 * Update Date: 08/01/2017
 * Update Date: 10/29/2017
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
// Solution 1: Recursive method. It is also a DFS implementation.
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricHelper(root.left, root.right);
    }
    
    private boolean isSymmetricHelper(TreeNode leftNode, TreeNode rightNode) {
        if (leftNode == null && rightNode == null) {
            return true;
        }
        if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) {
            return false;
        }
        return isSymmetricHelper(leftNode.right, rightNode.left) && isSymmetricHelper(leftNode.left, rightNode.right);
    }
}

// Iterative method.
// Solution 2: DFS: Using stack. Initially, push the left and right child of the root to the stack. 
//      After that, every time pop two nodes from stack and check whether they are the same, at the 
//      same time push the left child of the left node into the stack, push the right child of the 
//      right node to the stack, if one of these two nodes does not exist, return false, push the right 
//      child of the left node to the stack, push the left child of the right node to the stack, if 
//      one of these two nodes does not exist, return false.
public class Solution {
    private Stack<TreeNode> stack = new Stack<>();
    
    public boolean isSymmetric(TreeNode root) {
        // corner case.
        if (root == null) {
            return true;
        }
        
        // Push the left and right child to the stack.
        if (!pushChildrenSuccess(root.left, root.right)) {
            return false;
        }
        
        // Iterative part.
        while (!stack.empty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            
            if (left.val != right.val) {
                return false;
            }
            if (!pushChildrenSuccess(left.left, right.right)) {
                return false;
            }
            if (!pushChildrenSuccess(left.right, right.left)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean pushChildrenSuccess(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            stack.push(node1);
            stack.push(node2);
            return true;
        }
        return false;
    }
}

// Iterative method.
// Solution 3: BFS: Using queue. The idea is the same as the DFS implementation. 
public class Solution {
    private Queue<TreeNode> queue = new LinkedList<>();
    
    public boolean isSymmetric(TreeNode root) {
        // corner case.
        if (root == null) {
            return true;
        }
        
        // Push the left and right child to the queue.
        if (!pushChildrenSuccess(root.left, root.right)) {
            return false;
        }
        
        // Iterative part.
        while (!queue.isEmpty()) {
            TreeNode right = queue.poll();
            TreeNode left = queue.poll();
            
            if (left.val != right.val) {
                return false;
            }
            if (!pushChildrenSuccess(left.left, right.right)) {
                return false;
            }
            if (!pushChildrenSuccess(left.right, right.left)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean pushChildrenSuccess(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 != null) {
            queue.offer(node1);
            queue.offer(node2);
            return true;
        }
        return false;
    }
}




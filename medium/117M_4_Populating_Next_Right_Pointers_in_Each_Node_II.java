/**
 * Question description: Follow up for problem "Populating Next Right Pointers in Each Node" (question 116).
 * 
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * 
 * Note: You may only use constant extra space.
 *
 * Example: Given the following perfect binary tree,
 *	         1
 *	       /  \
 *	      2    3
 *	     / \    \
 * 	    4  5     7
 * After calling your function, the tree should look like:
 *	         1 -> NULL
 *	       /  \
 *	      2 -> 3 -> NULL
 *	     / \    \
 *	    4->5---->7 -> NULL
 *
 * Follow up question: Question 117: What if the tree is not a perfect binary tree ?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/30/2017
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

// Attention please: Could only use constant extra space.

// Solution 1: Iterative method based on level order traversal using contant extra space.
public class Solution {
    public void connect(TreeLinkNode root) {
        // start from the second level.
        while (root != null) {
            // Create a tempHead for each level.
            TreeLinkNode tempChild = new TreeLinkNode(0);
            TreeLinkNode currentChild = tempChild;
            while (root != null) {
                // If the root has left child.
                if (root.left != null) { 
                    currentChild.next = root.left; 
                    currentChild = currentChild.next;
                }
                
                // If the root has right child.
                if (root.right != null) { 
                    currentChild.next = root.right; 
                    currentChild = currentChild.next;
                }
                root = root.next;
            }
            root = tempChild.next;
        }
    }
}

// Solution 2: Using queue(not constant memory space). Similiar to the level order traversal of a tree.
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
		}
       	Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode node = queue.poll();
                if (i != size - 1) {
                    node.next = queue.peek();
				}
                if (node.left != null) {
                    queue.offer(node.left);
				}
                if (node.right != null) {
                    queue.offer(node.right);
				}
			}
		}
    }
}





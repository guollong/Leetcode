/**
 * Question description: Given a binary tree, return the level order traversal of its nodes' values. 
 *		(ie, from left to right, level by level).
 *
 * Example: Given binary tree [3,9,20,null,null,15,7],
 *	    3
 *	   / \
 *	  9  20
 *	    /  \
 *	   15   7
 * return its level order traversal as: [[3], [9,20], [15,7]]
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn, Facebook, Amazon, Microsoft, Apple, Bloomberg.
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

// Idea: Take the size of queue to get the number of nodes in that level.
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int index = 0;
            List<Integer> list = new ArrayList<>();
            while (index < size) {
                TreeNode temp = queue.poll();
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
                list.add(temp.val);
                index++;
            }
            result.add(list);
        }
        return result;
    }
}


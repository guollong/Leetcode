/**
 * Question description: Given a binary tree, return the zigzag level order traversal of its nodes' 
 *		values. (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * Example: Given binary tree [3,9,20,null,null,15,7],
 *	    3
 *	   / \
 *	  9  20
 *	    /  \
 *	   15   7
 * return its zigzag level order traversal as: [[3], [20,9], [15,7]]
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: LinkedIn, Bloomberg, Microsoft.
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

// Compared to the original level order traversal, do not need to change too much.
// Simply add the elements to the head of the levellist.
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean order = true;

        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (order) {
                    tmp.add(node.val);
                } else {
                    tmp.add(0, node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
            order = !order;
        }
        return res;
    }
}



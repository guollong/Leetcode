/**
 * Question description: Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * 						 (ie, from left to right, level by level from leaf to root).
 * Example 1: Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as: [[15,7], [9,20],[3]]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 * Create Date: 02/24/2017
 * Update date: 06/14/2017
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

// Solution 1: Implement helper function to keep the "level" information.
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        levelOrderBottomHelper(root, 0, result);
        return result;
    }
    
    private void levelOrderBottomHelper(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null) {
            return;
        }
        if (level == result.size()) {
            result.add(0, new LinkedList<Integer>());
        }
        result.get(result.size()-level-1).add(root.val);
        levelOrderBottomHelper(root.left, level + 1, result);
        levelOrderBottomHelper(root.right, level + 1, result);
    }
}

 /**
  * Functions in Queue: 
  * offer: Adds the specified element as the tail (last element) of this list.
  * poll: Retrieves and removes the head (first element) of this list.
  * peek: Retrieves, but does not remove, the head (first element) of this list.
  * size(), isEmpty().
  */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> bottomPrint = new LinkedList<List<Integer>>();
        if (root == null) {
            return bottomPrint;
        }
        // Adds the specified element as the last element of this list.
        queue.offer(root);
        
        // In the 771 project, we add children nodes when the node is removed.
        // Here, we first get the queue size which is the number of nodes in that level,
        // and then adding the values to the linkedlist of that level. Remove the node 
        // and enqueue children of the removed node. 
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                sublist.add(queue.peek().val);
                TreeNode toRemove = queue.poll();
                if (toRemove.left != null) {
                    queue.offer(toRemove.left);
                }
                if (toRemove.right != null) {
                    queue.offer(toRemove.right);
                }
            }
            // Inserts the specified element at the specified position in this list.
            bottomPrint.add(0, sublist);
        }
        return bottomPrint;
    }
}





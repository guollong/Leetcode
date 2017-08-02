/**
 * Question description: Given a binary tree, imagine yourself standing on the right side of it, 
 *		return the values of the nodes you can see ordered from top to bottom.
 *
 * Example: Given the following binary tree,
 *		   1            <---
 *		 /   \
 *		2     3         <---
 *		 \     \
 *		  5     4       <---
 * You should return [1, 3, 4].
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon.
 */

/**
 * Progress...
 * Create Date: 07/01/2017
 * Update Date: 08/02/2017
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

// Solution 1: 屡试不爽的level order traversal。。。BFS
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    result.add(node.val);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
            }
        }
        return result;
    }
}

// Solution: DFS.
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(result, root, 0);
        return result;
    }
    
    public void rightView(List<Integer> result, TreeNode curr, int currDepth) {
        // base case.
        if (curr == null) {
            return;
        }
        
        // recursive case.
        // result.size() represents for the level of the tree.
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        rightView(result, curr.right, currDepth + 1);
        rightView(result, curr.left, currDepth + 1);
    }
}




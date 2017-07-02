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

// Solution 1: 屡试不爽的level order traversal。。。
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
                TreeNode temp = queue.poll();
                if (i == size - 1) {
                    result.add(temp.val);
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.right != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return result;
    }
}

// Solution 2: Recursive method.
// The core idea of this algorithm:
// 1. Each depth of the tree only select one node. So recursively call right node first.
// 2. View depth is current size of result list.
public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }
    
    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        
        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
        
    }
}




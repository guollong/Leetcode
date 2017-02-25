/**
 * Question description: Given a binary tree, determine if it is height-balanced.
 * 						 For this problem, a height-balanced binary tree is defined as a binary tree in 
 * 						 which the depth of the two subtrees of every node never differ by more than 1.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
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
 
// test case: [1,2,2,3,null,null,3,4,null,null,4]
// Note: 注意题中提到的是，对于树中的每一个subtree都需要平衡。

// 自己的解法： 
// 觉得递归用的有点儿问题，递归应该是将问题细分化，每一次都解决一个小问题， 所以下面的那种解法更好。height函数每次求的就是
// 一个subtree的高度。
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (Math.abs(height(root.left, 0) - height(root.right, 0)) < 2 && isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;
    }
    
    private int height(TreeNode node, int height) {
        if (node == null) {
            return height;
        }
        return Math.max(height(node.left, height + 1), height(node.right, height + 1));
    }
}

// better solution.
public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(Height(root.left) - Height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    public int Height(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(Height(root.left), Height(root.right)) + 1;
    }

}



/**
 * Question description: Given a non-empty binary search tree and a target value, 
 *		find the value in the BST that is closest to the target.
 * 
 * Note: Given target value is a floating point.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Microsoft, Google, SnapChat.
 */

/**
 * Progress...
 * Create Date: 06/15/2017
 */

// Solution 1: Iterative method.
public class Solution {
    public int closestValue(TreeNode root, double target) {
        double min = Double.MAX_VALUE;
        TreeNode temp = root;
        int result = root.val;
        while (temp != null) {
            if (temp.val == target) {
                return temp.val;
            }
            if (min > Math.abs(target - temp.val)) {
                min = Math.abs(target - temp.val);
                result = temp.val;
            }
            if (temp.val * 1.0 > target) {
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return result;
    }
}

// Solution 2: Recursive method.
public class Solution {
    public int closestValue(TreeNode root, double target) {
    	// Need to determine which node to compare with. 
        TreeNode child = root.val > target ? root.left : root.right;
        if (child == null) {
            return root.val;
        }
        int closestChild = closestValue(child, target);
        return Math.abs(root.val - target) < Math.abs(closestChild - target) ? root.val : closestChild;
    }
}





/**
 * Question description: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/27/2017
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

// 首先考虑corner case：如果数组为空，则直接返回null。
// recursive method：每一次都给node的value赋值，然后分别给left和right赋值，可以用index（start和end）来取subarray。
// base case：当start大于end时递归结束。
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        TreeNode root = arrayToBSTHelper(nums, 0, nums.length - 1);
        return root;
    }
    
    private TreeNode arrayToBSTHelper(int[] nums, int start, int end) {
    	// base case.
        if (start > end) {
            return null;
        }
        // recursive case.
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = arrayToBSTHelper(nums, start, mid - 1);
        node.right = arrayToBSTHelper(nums, mid + 1, end);
        return node;
    }
}

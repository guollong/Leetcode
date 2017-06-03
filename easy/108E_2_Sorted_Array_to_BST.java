/**
 * Question description: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 03/27/2017
 * Update Date: 06/02/2017
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

// My own solution. 
// Be careful of the root of the tree. (odd values: take the middle; even values: take the (length / 2 + 1) value)
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        int mid = nums.length % 2 == 1 ? nums.length / 2 : nums.length / 2 - 1;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = new int[mid];
        System.arraycopy(nums, 0, left, 0, mid);
        int[] right = new int[nums.length - mid - 1];
        System.arraycopy(nums, mid + 1, right, 0, nums.length - mid - 1);
        
        root.left = sortedArrayToBST(left);
        root.right = sortedArrayToBST(right);
        return root;
    }
}

// Improved method from discussion. No need to create a temporary array. 
// Build a helper function which could take the start and end of the subarray.
public class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    
    private TreeNode helper(int[] nums, int start, int end){
        if(start > end) {
        	return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid - 1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}


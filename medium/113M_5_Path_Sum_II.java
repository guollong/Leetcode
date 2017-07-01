/**
 * Question description: Given a binary tree and a sum, find all root-to-leaf paths where each 
 *		path's sum equals the given sum.
 * 
 * Example: Given the below binary tree and sum = 22,
 *             5
 *            / \
 *           4   8
 *          /   / \
 *         11  13  4
 *        /  \    / \
 *       7    2  5   1
 * return [[5,4,11,2], [5,8,4,5]]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Bloomberg.
 */

/**
 * Progress...
 * Create Date: 07/01/2017
 */

/**
 * Definition for a binary tree node.
 * public class Treeode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1: Only create new list when add to the result.
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        pathSumHelper(root, sum, result, list);
        return result;
    }
    
    private void pathSumHelper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        // base case.
        if (node.left == null && node.right == null) {
            if (sum == node.val) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        
        // recursive case.
        if (node.left != null) {
            list.add(node.left.val);
            pathSumHelper(node.left, sum - node.val, result, list);
            list.remove(list.size() - 1);
        }
        if (node.right != null) {
            list.add(node.right.val);
            pathSumHelper(node.right, sum - node.val, result, list);
            list.remove(list.size() - 1);
        }
    }
}

// Solution 2: My original method. Every time adding a node, create a new list for not influence the original list.
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        pathSumHelper(root, sum, result, new ArrayList<>());
        return result;
    }
    
    private void pathSumHelper(TreeNode node, int sum, List<List<Integer>> result, List<Integer> list) {
        // base case.
        if (node == null) {
            return;
        }
        
        List<Integer> templist = new ArrayList<>(list);
        if (node.left == null && node.right == null && sum == node.val) {
            templist.add(node.val);
            result.add(templist);
            return;
        }
        
        // recursive case.
        templist.add(node.val);
        pathSumHelper(node.left, sum - node.val, result, templist);
        pathSumHelper(node.right, sum - node.val, result, templist);
    
    }
}




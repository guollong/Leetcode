/**
 * Question description: Given a binary search tree (BST) with duplicates, find all the mode(s) 
 *		(the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 * 		The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * 		The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * 		Both the left and right subtrees must also be binary search trees.
 * 
 * Example: Given BST [1,null,2,2], return [2].
 */

// Follow up: Could you do that without using any extra space? (Assume that the implicit stack space 
// 		incurred due to recursion does not count).

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/05/2017
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

// First version with hashmap. Not take advantage of the propoties of a BST, which is return 
// ordered result while perform in-order traversal.
public class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    private int maxCount = 1;
    
    public int[] findMode(TreeNode root) {
        // put element in a map while doing traversal.
        inOrderTraversal(root);
        List<Integer> res = new LinkedList<>();
        for (int element : map.keySet()) {
            if (map.get(element) == maxCount) {
                res.add(element);
            }
        }
        int[] result = new int[res.size()];
        int i = 0;
        for (int element : res) {
            result[i++] = element;
        }
        return result;
    }
    
    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        if (map.containsKey(root.val)) {
            int count = map.get(root.val) + 1;
            maxCount = Math.max(count, maxCount);
            map.put(root.val, count);
        } else {
            map.put(root.val, 1);
        }
        inOrderTraversal(root.right);
    }
}

// Better solution (But this is wrong, could understand why). 
// Steps: 1. in-order traversal return ordered list.
//		  2. get the mode from this ordered list.
public class Solution {
    List<Integer> list = new ArrayList<>();
    public int[] findMode(TreeNode root) {
        inOrderTraversal(root);
        if (list.size() == 0) {
            return new int[]{};
        }
        List<Integer> res = new ArrayList<>();
        int maxCount = 1;
        int count = 1;
        int i = 1;
        for (; i < list.size(); i++) {
            if (list.get(i) == list.get(i - 1)) {
                count++;
            } else {
                count = 1;
            }
            if (count == maxCount) {
                res.add(list.get(i - 1));
            } else if (count > maxCount) {
                maxCount = count;
                res.clear();
                res.add(list.get(i - 1));
            }
        }
        if (maxCount == 1 && count == 1) {
            res.add(list.get(i - 1));
        }
        int[] result = new int[res.size()];
        i = 0;
        for (int element : res) {
            result[i++] = element;
        }
        return result;
    }
    
    // This is a BST, in order traversal return ordered list.
    private void inOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        list.add(root.val);
        inOrderTraversal(root.right);
    }
}








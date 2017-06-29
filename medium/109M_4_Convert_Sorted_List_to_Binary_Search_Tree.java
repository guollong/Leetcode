/**
 * Question description: Given a singly linked list where elements are sorted in ascending order, 
 *		convert it to a height balanced BST.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/29/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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


public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return sortedListToBSTHelper(head, size - 1);
    }
    
    private TreeNode sortedListToBSTHelper(ListNode node, int number) {
        // base case.
        if (node == null || number < 0) {
            return null;
        }
        if (number == 0) {
            return new TreeNode(node.val);
        }
        
        // recursive case.
        int count = number / 2;
        ListNode temp = node;
        for (int i = 0; i < count; i++) {
            temp = temp.next;
        }
        
        TreeNode root = new TreeNode(temp.val);
        root.left = sortedListToBSTHelper(node, count - 1);
        root.right = sortedListToBSTHelper(temp.next, number - count - 1);
        return root;
    }
}



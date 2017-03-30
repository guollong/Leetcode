/**
 * Question description: Merge two sorted linked lists and return it as a new list. 
 *		The new list should be made by splicing together the nodes of the first two lists.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/29/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Simple recursive method from discussion.
// 自己老是想不到这种方法，要多总结。
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
}

// Jinglong's solution.
// 遍历两个list。
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode root = null;
        ListNode temp = null;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (root == null) {
                    root = l1;
                    temp = root;
                } else {
                    temp.next = l1;
                    temp = temp.next;
                }
                l1 = l1.next;
            } else {
                if (root == null) {
                    root = l2;
                    temp = root;
                } else {
                    temp.next = l2;
                    temp = temp.next;
                }
                l2 = l2.next;
            }
        }
        if (l1 != null) {
            while (l1 != null) {
                temp.next = l1;
                temp = temp.next;
                l1 = l1.next;
            }
        } else {
            while (l2 != null) {
                temp.next = l2;
                temp = temp.next;
                l2 = l2.next;
            }
        }
        return root;
    }
}




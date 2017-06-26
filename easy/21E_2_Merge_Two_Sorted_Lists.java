/**
 * Question description: Merge two sorted linked lists and return it as a new list. 
 *		The new list should be made by splicing together the nodes of the first two lists.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon, LinkedIn, Apple, Microsoft.
 * Create Date: 03/29/2017
 * Update date: 06/05/2017
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
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        
        ListNode mergeHead;
        if (l1.val < l2.val) {
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        } else {
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
        
        ListNode pointer1 = l1;
        ListNode pointer2 = l2;
        ListNode result;
        if (l1.val > l2.val) {
            result = l2;
            pointer2 = pointer2.next;
        } else {
            result = l1;
            pointer1 = pointer1.next;
        }
        ListNode temp = result;
        while (pointer1 != null && pointer2 != null) {
            if (pointer1.val > pointer2.val) {
                temp.next = pointer2;
                pointer2 = pointer2.next;
            } else {
                temp.next = pointer1;
                pointer1 = pointer1.next;
            }
            temp = temp.next;
        }
        while (pointer1 != null) {
            temp.next = pointer1;
            pointer1 = pointer1.next;
            temp = temp.next;
        }
        while (pointer2 != null) {
            temp.next = pointer2;
            pointer2 = pointer2.next;
            temp = temp.next;
        }
        return result;
    }
}



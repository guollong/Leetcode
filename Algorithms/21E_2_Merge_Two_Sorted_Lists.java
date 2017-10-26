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
 * Update date: 10/25/2017
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

// Jinglong's solution: Traverse two list.
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Cannot determine the head of the list.
        ListNode head = new ListNode(-1);
        ListNode temp = head;
        
        while (l1 != null || l2 != null) {
            if (l1 == null) {
                temp.next = l2;
                break;
            }
            if (l2 == null) {
                temp.next = l1;
                break;
            }
            
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        
        return head.next;
    }
}



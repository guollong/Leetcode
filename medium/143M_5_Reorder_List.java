/**
 * Question description: Given a singly linked list L: L0?L1?…?Ln-1?Ln,
 *		reorder it to: L0?Ln?L1?Ln-1?L2?Ln-2?…
 * 
 * You must do this in-place without altering the nodes' values.
 * 
 * Example: Given {1,2,3,4}, reorder it to {1,4,2,3}.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/13/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Similiar question: reverse list.
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        
        // using slow-fast pointers to find the middle of the list.
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse the second half of the list. 1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode preMiddle = slow;
        ListNode preCurrent = slow.next;
        while (preCurrent.next != null) {
            ListNode current = preCurrent.next;
            preCurrent.next = current.next;
            current.next = preMiddle.next;
            preMiddle.next = current;
        }
        
        // Start reorder one by one from 1->2->3->6->5->4 to 1->6->2->5->3->4.
        slow = head;
        fast = preMiddle.next;
        while (slow != preMiddle) {
            preMiddle.next = fast.next;
            fast.next = slow.next;
            slow.next = fast;
            slow = fast.next;
            fast = preMiddle.next;
        }
    }

}





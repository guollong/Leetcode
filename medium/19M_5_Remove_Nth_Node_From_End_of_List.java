/**
 * Question description: Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * Example: Given linked list: 1->2->3->4->5, and n = 2.
 *		After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note: Given n will always be valid.
 *		 Try to do this in one pass.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 07/14/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }
        
        // Could not determine the head of the list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Use slow and fast pointers to get the node that gonna be deleted.
        ListNode fast = dummy;
        ListNode slow = dummy;
        int count = 0;
        while (count < n) {
            fast = fast.next;
            count++;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}



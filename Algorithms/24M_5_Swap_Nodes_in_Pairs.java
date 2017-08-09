/**
 * Question description: Given a linked list, swap every two adjacent nodes and return its head.
 *
 * Example: Given 1->2->3->4, you should return the list as 2->1->4->3.
 * 
 * Note: Your algorithm should use only constant space. You may not modify the values in the list, 
 *		only nodes itself can be changed.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Bloomberg, Uber.
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


public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Could not determine the head of the list.
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        ListNode temp = head;
        while (temp != null && temp.next != null) {
            ListNode tobeInsert = temp.next;
            // Remember to delete the inserted node in the list, otherwise, 
            // it will cause memory limit exception.
            temp.next = temp.next.next;
            tobeInsert.next = temp;
            pre.next = tobeInsert;
            
            // remember to update the pre node.
            pre = temp;
            temp = temp.next;
        }
        return dummy.next;
    }
}



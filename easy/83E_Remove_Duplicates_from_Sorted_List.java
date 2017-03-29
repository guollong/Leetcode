/**
 * Question description: Given a sorted linked list, delete all duplicates such that each element appear only once.
 * 
 * Example: Given 1->1->2, return 1->2.
 *			Given 1->1->2->3->3, return 1->2->3.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/28/2017
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode parent = head;
        ListNode current = head.next;
        while (current != null) {
            if (current.val != parent.val) {
                parent = current;
                current = current.next;
            } else {
                parent.next = current.next;
                current = current.next;
            }
        }
        return head;
    }
}
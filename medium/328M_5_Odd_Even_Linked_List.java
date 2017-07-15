/**
 * Question description: Given a singly linked list, group all odd nodes together followed by the even nodes. 
 *		Please note here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 * 
 * Example: Given 1->2->3->4->5->NULL, return 1->3->5->2->4->NULL.
 * 
 * Note: The relative order inside both the even and odd groups should remain as it was in the input. 
 *		 The first node is considered odd, the second node even and so on ...
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
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

// Remember to update the previous node and cut the node that has been moved forward.
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = head;
        ListNode temp = head.next;
        while (temp != null && temp.next != null) {
            ListNode next = temp.next.next;
            temp.next.next = pre.next;
            pre.next = temp.next;
            temp.next = next;
            pre = pre.next;
            temp = next;
        }
        return head;
    }
}




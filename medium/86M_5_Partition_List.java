/**
 * Question description: Given a linked list and a value x, partition it such that all nodes 
 *		less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Example: Given 1->4->3->2->5->2 and x = 3, return 1->2->2->4->3->5.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/10/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// The basic idea is that we store two groups(greater and less) of node in two different lists.
// When we cannot determine the head of the list, we could use dummy node to represent it.
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0);
        ListNode dummy2 = new ListNode(0);
        ListNode curr1 = dummy1;
        ListNode curr2 = dummy2;
        while (head != null) {
            if (head.val >= x) {
                curr2.next = head;
                curr2 = head;
            } else {
                curr1.next = head;
                curr1 = head;
            }
            head = head.next;
        }
        curr2.next = null;
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}




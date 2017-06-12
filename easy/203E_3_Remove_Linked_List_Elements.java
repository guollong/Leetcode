/**
 * Question description: Remove all elements from a linked list of integers that have value val.
 * 
 * Example: Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 *			Return: 1 --> 2 --> 3 --> 4 --> 5
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/12/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Attention when the head's value is equal to "val".
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode pre = head;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == val) {
                if (curr == head) {
                    head = curr.next;
                } else {
                    pre.next = curr.next;
                }
            } else {
                pre = curr;
            }
            curr = curr.next;
        }
        return head;
    }
}



/**
 * Question description: Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * Example: Given 1->2->3->4->5->NULL, m = 2 and n = 4, return 1->4->3->2->5->NULL.
 * 
 * Note: Given m, n satisfy the following condition: 1 <= m <= n <= length of list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/28/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution 1: My own solution. Get the start node and end node, reverse the middle nodes and 
// concantenate three pieces of nodes together.
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        
        ListNode start = head;
        ListNode end = head;
        
        // get the start node.
        int index = 2;
        while (index < m) {
            start = start.next;
            index++;
        }
        
        // get the end node.
        index = 0;
        while (index < n) {
            end = end.next;
            index++;
        }
        
        // reverse the list from start to end.
        index = 0;
        ListNode reverseHead = null;
        ListNode node = m == 1 ? head : start.next;
        while (index < n - m + 1) {
            ListNode temp = node.next;
            node.next = reverseHead;
            reverseHead = node;
            node = temp;
            index++;
        }
        if (m == 1) {
            head = reverseHead;
        } else {
            start.next = reverseHead;
        }
        
        // concatenate the left node to the end of the reversed list.
        index = 0;
        ListNode temp = reverseHead;
        while (index < n - m) {
            temp = temp.next;
            index++;
        }
        temp.next = end;
        return head;
    }
}

// Solution 2: from discussion: Simply just reverse the list along the way using 4 pointers: dummy, pre, start, then
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
        dummy.next = head;
        ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        
        ListNode start = pre.next;  // a pointer to the beginning of a sub-list that will be reversed
        ListNode then = start.next; // a pointer to a node that will be reversed
        // 1 - 2 -3 - 4 - 5 ; m = 2; n = 4 ---> pre = 1, start = 2, then = 3
        // dummy-> 1 -> 2 -> 3 -> 4 -> 5
        
        // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
        // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
        for (int i = 0; i < n - m; i++) {
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
        return dummy.next;
    }
}




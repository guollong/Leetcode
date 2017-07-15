/**
 * Question description: Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * 		k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not 
 *		a multiple of k then left-out nodes in the end should remain as it is.
 * 
 * Notes: You may not alter the values in the nodes, only nodes itself may be changed. Only constant memory is allowed.
 * 
 * Example: Given this linked list: 1->2->3->4->5,
 *		For k = 2, you should return: 2->1->4->3->5
 *		For k = 3, you should return: 3->2->1->4->5
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Microsoft, facebook.
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

// Solution 1: Recursive method.
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        // find the k+1 node or reach the end when k is greater than the length of the list.
        while (curr != null && count != k) { 
            curr = curr.next;
            count++;
        }
        
        // if k+1 node is found
        if (count == k) {
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part, 
            // curr - head-pointer to reversed part;
            
            // !!!!!!!!!!!!! A simple nice way to reverse part of a list.
            // reverse current k-node group.
            while (count-- > 0) { 
                ListNode tmp = head.next; 
                head.next = curr; 
                curr = head; 
                head = tmp;
            }
            head = curr;
        }
        return head;
    }

}

// Solution 2: The worst case running time complexity is O(n ^ 2). Combine with the idea of reverse list ii.
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) {
            return head;
        }
        
        // get the length of the list.
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }

        // reverse the list partially for "threshold" times. So the running time complexity is O((n / k) * n)
        ListNode result = head;
        int threshold = length / k;
        int index = 0;
        while (index < threshold) {
            result = reverseListII(result, k * index + 1, k * (index + 1));
            index++;
        }
        
        return result;
    }
    
    // Reverse part of the list.
    private ListNode reverseListII(ListNode head, int start, int end) {
        // Precondition: end - start >= 2.
        // Could not determine the head of the list.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        int index = 0;
        ListNode pre = dummy;
        while (index < start - 1) {
            pre = pre.next;
            index++;
        }
        
        ListNode begin = pre.next;   // a pointer to the beginning of a sub-list that will be reversed.
        ListNode then = begin.next;  // a pointer to a node that will be reversed.
        
        for (int i = 0; i < end - start; i++) {
            begin.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = begin.next;
        }
        return dummy.next;
    }

}
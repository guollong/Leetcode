/**
 * Question description: Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * Example: Given 1->2->3->4->5->NULL and k = 2, return 4->5->1->2->3->NULL.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 06/26/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 3步翻转法。1->2->3->4->5->NULL and k = 2 ------> 1->2->3->NULL; 4->5->NULL ------> 
//		3->2->1->NULL; 5->4->NULL ------> 3->2->1->5->4->NULL ------> 4->5->1->2->3->NULL
public class Solution {
    
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // Get the rotate size less than the size of the list.
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        k = k % size;
        
        // Find the first half (begins with head) and second half (begins with walker) of the list.
        ListNode runner = head;
        ListNode prewalker = head;
        ListNode walker = head;
        int index = 0;
        while (index < k) {
            runner = runner.next;
            index++;
            if (runner == null) {
                runner = head;
            }
        }
        while (runner != null) {
            prewalker = walker;
            walker = walker.next;
            runner = runner.next;
        }
        prewalker.next = null;
        
        // reverse first and second half of the list.
        ListNode firsthalf = reverseList(head);
        ListNode secondhalf = reverseList(walker);
        
        // concatenate two reversed list and reverse the combined list.
        temp = firsthalf;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = secondhalf;
        return reverseList(firsthalf);
    }
    
    private ListNode reverseList(ListNode node) {
        ListNode head = null;
        while (node != null) {
            ListNode temp = node.next;
            node.next = head;
            head = node;
            node = temp;
        }
        return head;
    }
}

// Solution 2: Get the length of the list and move the head to the (l - n % l)th node
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
    
        // Get the total length.
        int count;
        for (count = 0; fast.next != null; count++) {
        	fast = fast.next;
        }
        
        // Get the (count - n % count)th node.
        for (int j = count - n % count; j > 0; j--) {
        	slow = slow.next;
        }
        
        // Do the rotation.
        fast.next = dummy.next; 
        dummy.next = slow.next;
        slow.next = null;
        return dummy.next;
    }
}





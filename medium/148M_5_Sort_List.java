/**
 * Question description: Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/12/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution: Sort the list using merge sort.
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // step 1. cut the list to two halves which begins from head and slow.
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
    
        // fast and low pointer.
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
    
        prev.next = null;
    
        // step 2. sort each half
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(slow);
    
        // step 3. merge l1 and l2
        return merge(l1, l2);
    }
  
    // Use while-loop to implement this merge helper function.
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        if (l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }
        return dummy.next;
    }

    // Using recursion to implement this merge helper function.
    // private ListNode merge(ListNode l1, ListNode l2) {
    //     ListNode head = null;
    //     if (l1 == null) {
    //         return l2;
    //     } 
    //     if (l2 == null) {
    //         return l1;
    //     }
    //     if (l1.val >= l2.val) {
    //         head = l2;
    //         head.next = merge(l1, l2.next);
    //     } else {
    //         head = l1;
    //         head.next = merge(l1.next, l2);
    //     }
    //     return head;
    // }

}


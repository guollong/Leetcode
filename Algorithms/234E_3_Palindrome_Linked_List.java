/**
 * Question description: Given a singly linked list, determine if it is a palindrome.
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon, Facebook.
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

// (1) Move: fast pointer goes to the end, and slow goes to the middle.
// (2) Reverse: the right half is reversed, and slow pointer becomes the 2nd head.
// (3) Compare: run the two pointers head and slow together and compare.

public class Solution {
    public boolean isPalindrome(ListNode head) {
        // fast pointer goes to the end, and slow goes to the middle.
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes: let right half smaller
            slow = slow.next;
        }
        
        // the right half is reversed, and slow pointer becomes the 2nd head.
        slow = reverse(slow);
        fast = head;
        
        // run the two pointers head and slow together and compare.
        while (slow != null) {
            if (fast.val != slow.val) {
                return false;
            }
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}


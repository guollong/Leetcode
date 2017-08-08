/**
 * Question description: You are given two non-empty linked lists representing two non-negative 
 *		integers. The digits are stored in reverse order and each of their nodes contain a single 
 *		digit. Add the two numbers and return it as a linked list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Example: Input: (2 -> 4 -> 3) + (5 -> 6 -> 4); Output: 7 -> 0 -> 8
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg, Airbnb, Adobe.
 */

/**
 * Progress...
 * Create Date: 06/18/2017
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        
        // The temporary node that indicates the tail of the current list.
        ListNode toInsert = null;
        
        int carry = 0, sum = 0;
        while (l1 != null || l2 != null) {
            sum = carry;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            
            ListNode temp = new ListNode(sum);
            if (result == null) {
                result = temp;
            } else {
                toInsert.next = temp;
            }
            toInsert = temp;
        }
        
        if (carry == 1) {
            toInsert.next = new ListNode(1);
        }
        return result;
    }
}

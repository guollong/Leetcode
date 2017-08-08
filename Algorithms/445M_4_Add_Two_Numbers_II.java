/**
 * Question description: You are given two non-empty linked lists representing two non-negative 
 *		integers. The most significant digit comes first and each of their nodes contain a single
 *		digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * 
 * Follow up: What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 * 
 * Example: Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4); Output: 7 -> 8 -> 0 -> 7
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Bloomberg.
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

// Solution 1: reverse two lists first and then each time add the sum to the head of the result list.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode reversel1 = reverseList(l1);
        ListNode reversel2 = reverseList(l2);
        ListNode result = null;
        int carry = 0;
        while (reversel1 != null || reversel2 != null) {
            int sum = carry;
            if (reversel1 != null) {
                sum += reversel1.val;
                reversel1 = reversel1.next;
            }
            if (reversel2 != null) {
                sum += reversel2.val;
                reversel2 = reversel2.next;
            }
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            temp.next = result;
            result = temp;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = result;
            result = temp;
        }
        return result;
    }
    
    private ListNode reverseList(ListNode l1) {
        ListNode head = null;
        while (l1 != null) {
            ListNode temp = l1.next;
            l1.next = head;
            head = l1;
            l1 = temp;
        }
        return head;
    }
}


// Follow-up solution: not reverse the list. Stack is another way to reverse the list.
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Stack could also be used to reverse the list.
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode head = null;
        
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }        
        int carry = 0, sum = 0;
        while ((!stack1.empty()) || (!stack2.empty())) {
            sum = carry;
            if (!stack1.empty()) {
                sum += stack1.pop();
            }
            if (!stack2.empty()) {
                sum += stack2.pop();
            }
            carry = sum > 9 ? 1 : 0;
            sum = sum % 10;
            ListNode temp = new ListNode(sum);
            temp.next = head;
            head = temp;
        }
        if (carry == 1) {
            ListNode temp = new ListNode(1);
            temp.next = head;
            head = temp;
        }
        return head;
    }
}
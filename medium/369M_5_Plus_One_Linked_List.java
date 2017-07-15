/**
 * Question description: Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.
 * 
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * 
 * The digits are stored such that the most significant digit is at the head of the list.
 * 
 * Example: Input: 1->2->3; Output:1->2->4
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
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

// Solution 0: Intuitive method: Reverse the list, add one to the reversed list and reverse it again.

// Solution 1: Iterative Two-Pointers with dummy node: O(n) time, O(1) space.
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // i stands for the most significant digit that is going to be incremented if there exists a carry.
        ListNode i = dummy;
        ListNode j = dummy;
        
        // j ends up to the end of the list and i ends up being the right-most node that is not equal to 9.
        while (j.next != null) {
            j = j.next;
            if (j.val != 9) {
                i = j;
            }
        }
        
        // If the value of right-most node is not 9, just add 1 to its value and return.
        if (j.val != 9) {
            j.val++;
        } else {
            // If the value of right-most node is 9, add 1 to the value of node i and change the values of nodes 
            // after i to be 0.
            i.val++;
            i = i.next;
            while (i != null) {
                i.val = 0;
                i = i.next;
            }
        }
        
        if (dummy.val == 0) {
            return dummy.next;
        }
        
        return dummy;
    }
}

// Solution 2: Recursive solution: running time complexity: O(N)????
public class Solution {
    public ListNode plusOne(ListNode head) {
        if (DFS(head) == 0) {
            return head;
        } else {
            ListNode newHead = new ListNode(1);
            newHead.next = head;
            return newHead;
        }
    }

    // Return the carry of a list.
    private int DFS(ListNode head) {
        // base case: this may represent the right-most bit, it needs to plus one.
        if (head == null) {
            return 1;
        }

        int carry = DFS(head.next);
        if (carry == 0) {
            return 0;
        }

        // 有进位。。。
        int val = head.val + 1;
        head.val = val % 10;
        return val / 10;
    }
}

// Solution 3: Jinglong's method: The running time complexity is O(n^2)
public class Solution {
    public ListNode plusOne(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Get the length of the list.
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        
        int carry = 0;
        int count = length;
        while (count > 0) {
            // find the last bit we need to manipulate.
            temp = head;
            int index = 1;
            while (index < count) {
                temp = temp.next;
                index++;
            }
            
            // If it is the last bit of the number.
            if (count == length) {
                carry = (temp.val + 1) / 10;
                temp.val = (temp.val + 1) % 10;
            } else {
                int tempCarry = carry;
                carry = (temp.val + carry) / 10;
                temp.val = (temp.val + tempCarry) % 10;
            }
            count--;
        }
        
        // If the carry is 1 in the end.
        if (carry == 1) {
            ListNode newhead = new ListNode(1);
            newhead.next = dummy.next;
            dummy.next = newhead;
        }
        return dummy.next;
    }
}



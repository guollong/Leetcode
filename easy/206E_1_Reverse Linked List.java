/**
 * Question description: Reverse a singly linked list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 03/25/2017
 * Update Date: 05/31/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// My solution: store the values of nodes in an array and inverse the value of nodes.
public class Solution {
    public ListNode reverseList(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }
        temp = head;
        for (int i = values.size() - 1; i >= 0; i--) {
            temp.val = values.get(i);
            temp = temp.next;
        }
        return head;
    }
}

 /**
  * Top solution: Iterative method.
  * Intitally, newHead is null.After each iteration, newHead becomes current head.
  * Each iteration, record previous node and next node of current head.
  */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while(head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }
}

/**
 *Top solution: Recursive method.
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        return reverseListRecur(head, null);
    }
    /**
     * Input parameter: leftHead: the head of left linked list.
     *                  resultHead: the head of result linked list
     */
    private ListNode reverseListRecur(ListNode leftHead, ListNode resultHead) {
        //base case.
        if (leftHead == null) {
            return resultHead;
        }
        
        //recursive case.
        ListNode next = leftHead.next;
        leftHead.next = resultHead;
        // next becomes the head of the left linked list.
        // leftHead becomes becomes the head of the result linked list.
        return reverseListRecur(next, leftHead);
    }
}

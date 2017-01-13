/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
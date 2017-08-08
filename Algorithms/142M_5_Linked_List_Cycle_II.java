/**
 * Question description: A linked list is given such that each node contains an additional random pointer which 
 *		could point to any node in the list or null. Return a deep copy of the list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg, Yahoo.
 */

/**
 * Progress...
 * Create Date: 07/13/2017
 */


/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/** 
 * Idea: Suppose the distance between the first node with the cycle begining point is A, when runner catches up 
 * 		the walker, the walker moves B steps again. At this point, the runner totally moves 2 * (A + B), we could 
 * 		then get the cycle size which is (A + B). Since the walker already walks B steps in the cycle, we start 
 * 		initially from the head and walk towards the walker, when they encounter with each other, we get the 
 *		starting point of the cycle.
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        // Note the while condition. (not "fast.next != null && fast.next.next != null")
        // We could directly check if two nodes are equal.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head; 
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}


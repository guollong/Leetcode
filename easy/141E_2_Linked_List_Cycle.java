/**
 * Question description: Given a linked list, determine if it has a cycle in it.
 * Follow up: Can you solve it without using extra space?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon, Microsoft, Bloomberg, Yahoo.
 * Create Date: 04/05/2017
 * Update date: 06/06/2017
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
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode walker = head, runner = head;
        // 注意这里的循环条件不是(walker.next != null && runner.next.next != null)。
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}

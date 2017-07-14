/**
 * Question description: A linked list is given such that each node contains an additional random pointer which 
 *		could point to any node in the list or null. Return a deep copy of the list.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Bloomberg, Uber.
 */

/**
 * Progress...
 * Create Date: 07/13/2017
 */

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

// 1st round: make copy of each node and link them together with the original nodes in a single list.
// 2nd round: assign random pointers for the copy nodes.
// 3rd: restore the orginal list and extract the copy list.
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        
        // 1st round: make copy of each node and link them together with the original nodes in a single list.
        RandomListNode iter = head;
        while (iter != null) {
            RandomListNode next = iter.next;
            RandomListNode copy = new RandomListNode(iter.label);
            iter.next = copy;
            copy.next = next;
            iter = next;
        }
        
        // 2nd round: assign random pointers for the copy nodes.
        iter = head;
        while (iter != null) {
            if (iter.random != null) {
                iter.next.random = iter.random.next;
            }
            iter = iter.next.next;
        }
        
        // 3rd: restore the orginal list and extract the copy list.
        iter = head;
        RandomListNode result = new RandomListNode(0);
        RandomListNode resultiter = result;
        
        while (iter != null) {
            RandomListNode next = iter.next.next;
            
            // extract the copy node.
            resultiter.next = iter.next;
            resultiter = resultiter.next;
            
            // restore the original list.
            iter.next = next;
            iter = next;
        }
        return result.next;
    }
}




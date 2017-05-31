/**
 * Question description: Write a function to delete a node (except the tail) in a singly linked list, 
 * 			given only access to that node.
 *
 * Example: Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, 
 *			the linked list should become 1 -> 2 -> 4 after calling your function. 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/25/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Generally, we know the head of the linkedlist and when we want to delete one specific node, we just 
// need to change the pointers. However, in this question, we only have the node that is going to be deleted
// and cannot get its previous node. Thus, we find another way. That is changing the value of current node
// to the value of next node and delete the next node.
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

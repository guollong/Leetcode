/**
 * Question description: Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * Example: the following two linked lists:
 * A:          a1 → a2
 *	                  ↘
 *	                    c1 → c2 → c3
 *	                  ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes: If the two linked lists have no intersection at all, return null.
 *		The linked lists must retain their original structure after the function returns.
 *		You may assume there are no cycles anywhere in the entire linked structure.
 *		Your code should preferably run in O(n) time and use only O(1) memory.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon, Microsoft, Bloomberg, Airbnb.
 */

/**
 * Progress...
 * Create Date: 06/11/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

// Solution from discussion. 
// Idea: If two lists have different size, we just reset the pointer to the head of another linkedlist when any
// 		of them hit the end. 
// 有点儿像快慢指针，相同的元素总会遇上的。。（check the circle in a linkeded list）
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
        
        ListNode a = headA;
        ListNode b = headB;
        
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;    
        }
        
        return a;
    }
}


// My solution: check the difference between the sizes of two lists. Modify two lists and let them have the same size.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode tempA = headA;
        ListNode tempB = headB;
        int diff = lenDiff(headA, headB);
        int index = 0;
        if (diff > 0) {
            while (index < diff) {
                tempA = tempA.next;
                index++;
            }
        } else {
            while (index < Math.abs(diff)) {
                tempB = tempB.next;
                index++;
            }
        }
        
        while (tempA != null && tempB != null && tempA.val != tempB.val) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        return tempA;
    }
    
    private int lenDiff(ListNode nodeA, ListNode nodeB) {
        int length1 = 0;
        while (nodeA != null) {
            length1++;
            nodeA = nodeA.next;
        }
        int length2 = 0;
        while (nodeB != null) {
            length2++;
            nodeB = nodeB.next;
        }
        return length1 - length2;
    }
}





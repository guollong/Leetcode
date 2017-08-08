/**
 * Question description: Sort a linked list using insertion sort.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/11/2017
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// Solution 1.
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // pre 和 curr 两个list是分开的，所以不用将dummy.next 指向head。
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;       // Insert node between pre and pre.next;
        ListNode curr = head;       // The node will be inserted.
        
        while (curr != null) {
            ListNode next = curr.next;      // The next node will be inserted.
            
            // Find the right place to insert.
            while (pre.next != null && pre.next.val < curr.val) {
                pre = pre.next;
            }
            
            // Insert curr node between pre and pre.next;
            // 先断开curr node的连接，将其插入到pre和pre.next之间，然后
            curr.next = pre.next;
            pre.next = curr;
            pre = dummy;
            curr = next;
        }

        return dummy.next;
    }
}

// Solution 2: 效率有点儿高啊，好好学习一下。。。。。
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        
        // Create a dummy node before head.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        while (head != null) {
            
            // Find the node that doesn't in the ascending order.
            while (head.next != null && head.val <= head.next.val) {
                head = head.next;
            }
            
            // If it is not the end of the list.
            if (head.next != null) {
                
                // Find an insertion place.
                ListNode prev = dummy;
                ListNode changeNode = head.next;
                for (ListNode p = dummy.next; p.val <= changeNode.val; p = p.next, prev = prev.next);
                
                // Insert the node between prev and prev.next.
                head.next = changeNode.next;
                changeNode.next = prev.next;
                prev.next = changeNode;
            } else {
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}



// 思考: In terms of thoughts from a Google interviewer, For God's sake, don't try 
//		sorting a linked list during the interview. So it might be better to actually copy 
//		the values into an array and sort them there.

/**
 * Question: What's the fastest algorithm for sorting a linked list?
 *
 * Answer: It may actually be faster to copy the list to an array and then use a Quicksort.
 * 
 * Reason: This might be faster is because that an array has much better cache performance than a linked list. 
 *		If the nodes in the list are dispersed in memory, you may be generating cache misses all over the place. 
 *		Then again, if the array is large you will get cache misses anyway. Mergesort parallelises better, so 
 *		it may be a better choice if that is what you want. It is also much faster if you perform it directly 
 *		on the linked list.
 * 
 * Experiment: quick sort V.S merge sort in this problem.
 *		N = 100000000: Fragmented list with merge sort: 364.797000 seconds
 *					   Array with qsort: 61.166000 seconds
 *					   Packed list with merge sort: 16.525000 seconds
 * 
 * Conclusion: Copying into an array is well worth it to improve the cache performance, since you rarely have 
 *		a completely packed linked list in real life.
 */


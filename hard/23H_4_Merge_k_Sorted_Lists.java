/**
 * Question description: Merge k sorted linked lists and return it as one sorted list. 
 *		Analyze and describe its complexity.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company:  Google, Uber, Airbnb, Facebook, Twitter, Amazon, Microsoft.
 */

/**
 * Progress...
 * Create Date: 06/26/2017
 */


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
// 这他妈都可以用binary search的思想。。。。。。
// Solution 1: The running time complexity is O(n*logn), the idea is similiar to merge sort.
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        return partition(lists, 0, lists.length - 1);
    }
    
    private ListNode partition(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int mid = 0;
        if (start < end) {
            mid = start + (end - start) / 2;
            ListNode l1 = partition(lists, start, mid);
            ListNode l2 = partition(lists, mid + 1, end);
            return mergeTwoLists(l1, l2);
        } else {
            return null;
        }
    }
    
    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = null;
        if (list1.val < list2.val) {
            head = list1;
            head.next = mergeTwoLists(list1.next, list2);
        } else {
            head = list2;
            head.next = mergeTwoLists(list1, list2.next);
        }
        return head;
    }
}

// Solution 2: Using priority queue.
 
// Suppose the total number of nodes is n. The total time complexity is (n * logK).
// For a priority queue, insertion takes logK time
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val < o2.val) {
                    return -1;
                } else if (o1.val == o2.val) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        
        // push all first nodes of the lists into the priority queue.
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }
        
        // If one node in certain list pop from the queue, push a new node from that list into the queue.
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!queue.isEmpty()){
            tail.next = queue.poll();
            tail = tail.next;
            if (tail.next != null) {
                queue.add(tail.next);
            }
        }
        return dummy.next;
    }
}








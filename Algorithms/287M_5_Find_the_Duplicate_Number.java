/**
 * Question description: Given a linked list, remove the nth node from the end of list and return its head.
 * 
 * Example: Given linked list: 1->2->3->4->5, and n = 2.
 *		After removing the second node from the end, the linked list becomes 1->2->3->5.
 *
 * Note: Given n will always be valid.
 *		 Try to do this in one pass.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Bloomberg.
 */

/**
 * Progress...
 * Create Date: 07/14/2017
 */

// Solution 1: Linked List Cycle II. Use two pointers the fast and the slow. The fast one goes forward two steps 
// 		each time, while the slow one goes only step each time. They must meet the same item when slow == fast. 
//		In fact, they meet in a circle, the duplicate number must be the entry point of the circle when visiting 
//		the array from nums[0]. Next we just need to find the entry point. We use a point(we can use the fast one 
//		before) to visit form begining with one step each time, do the same job to slow. When fast==slow, they 
//		meet at the entry point of the circle.
// Running time complexity: O(n)
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        
        fast = 0;
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }
        return slow;
    }
}


// Solution 2: At first the search space is numbers between 1 to n. Each time I select a number mid 
//		(which is the one in the middle) and count all the numbers equal to or less than mid. Then if 
//		the count is more than mid, the search space will be [1 mid] otherwise [mid+1 n].
// Running time complexity: O(n * logn)
public class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length <= 1) {
            return -1;
        }
        int low = 1;
        int high = nums.length - 1;
        int mid = 0, count = 0;
        
        // Perform the binary search between 1 to n.
        while (low < high) {
            count = 0;
            mid = low + (high - low) / 2;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}





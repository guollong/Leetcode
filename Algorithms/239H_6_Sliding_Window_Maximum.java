/**
 * Question description: Given an array nums, there is a sliding window of size k which is moving from the very left 
 *		of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves 
 *		right by one position.
 *
 * Example: Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 *		Window position                Max
 *		---------------               -----
 *		[1  3  -1] -3  5  3  6  7       3
 *		 1 [3  -1  -3] 5  3  6  7       3
 *		 1  3 [-1  -3  5] 3  6  7       5
 *		 1  3  -1 [-3  5  3] 6  7       5
 *		 1  3  -1  -3 [5  3  6] 7       6
 *		 1  3  -1  -3  5 [3  6  7]      7
 * Therefore, return the max sliding window as [3,3,5,5,6,7].
 * 
 * Follow up: Could you solve it in linear time?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Amazon, Google, Zenefits.
 */

/**
 * Progress...
 * Create Date: 08/08/2017
 */

// Solution 1: Using maxHeap. Running time complexity: O(n * logk)
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        
        // Create a maxHeap.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        // Put first three elements into the heap.
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        result[0] = maxHeap.peek();
        for (int i = k; i < nums.length; i++) {
            maxHeap.remove(nums[i - k]);
            maxHeap.add(nums[i]);
            result[i - k + 1] = maxHeap.peek();
        }
        return result;
    }
}


// Solution 2: Using deque. Running time complexity: O(n)
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        
        // store the indices in the array.
        Deque<Integer> deque = new ArrayDeque<>();
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            // remove indices out of range.
            while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                deque.poll();
            }
            
            // remove smaller numbers in k range as they are useless
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            
            deque.offer(i);
            if (i >= k - 1) {
                result[index++] = nums[deque.peek()];
            }
        }
        return result;
    }
}











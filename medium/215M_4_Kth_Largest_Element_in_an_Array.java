 /**
 * Question description: Find the kth largest element in an unsorted array. 
 *		Note that it is the kth largest element in the sorted order, not the kth distinct element.
 * 
 * Example: Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Apple, Bloomberg, Pocket Gems.
 */

/**
 * Progress...
 * Create Date: 06/26/2017
 * Update Date: 08/03/2017
 */

// Solution 1: simply sort and take the element.
// O(N lg N) running time + O(1) memory
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}


// Solution 2: priority queue.
// O(N lg K) running time + O(K) memory.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int element : nums) {
            queue.add(element);
        }
        int number = nums.length - k;
        while (number-- > 0) {
            queue.poll();
        }
        return queue.peek();
    }
}

// Solution 3: // Selection algorithm (based on the partition method -- the same one as used in quicksort).
// O(N) best case / O(N^2) worst case running time + O(1) memory.
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j == k) {
                break;
            } else if (j > k) {
                high = j - 1;
            } else {
                low = j + 1;
            }
        }
        return nums[k];
    }
    
    // Take the first element as the pivot, and perform partition, let all elements less than
    // the pivot in the left and greater than the pivot in the right, finally return the parition position.
    private int partition(int[] nums, int low, int high) {
        int i = low + 1;
        int j = high;
        // Attention the while condition is not "i < j".
        while (true) {
            while (i <= high && nums[i] <= nums[low]) {
                i++;
            }
            while (j >= low && nums[j] > nums[low]) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, j, low);
        return j;
    }
    
    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}





/**
 * Question description: Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 * 
 * Example: (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6]. 
 *			(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 * 
 * Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra space?
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 07/13/2017
 */

// This problem contains two kinds of questions：sort color with linear time and find kth element in an unsorted array within linear time.
// Learn it later carefully.
public class Solution {
    public void wiggleSort(int[] nums) {
        // Find the median of the array (average O(n) time and O(1) space). After performing this method, the array is sorted..
        int median = findKthLargest(nums, (nums.length + 1) / 2);

        // Arrange the numbers using three-way partitioning (the similiar to the question 75 sort color), so that larger values
        // come first, median comes then and smaller values come last. (corresponding to the virtual indices).
        // Because the requirement is nums[0] < nums[1] > nums[2] < nums[3]...., so we use virtual indexing to let the values
        // smaller than median in the odd position, values larger than median in the even position(odd indices)
        int length = nums.length;
        int left = 0, i = 0, right = length - 1;

        while (i <= right) {
            if (nums[newIndex(i, length)] > median) {
                swap(nums, newIndex(left, length), newIndex(i, length));
                left++;
                i++;
            } else if (nums[newIndex(i, length)] < median) {
                swap(nums, newIndex(right, length), newIndex(i, length));
                right--;
            } else {
                i++;
            }
        }
        
    }
    
    // Virtual indexing: i --> newIndex ((1 + 2 * i) % (n | 1)).
    private int newIndex(int index, int n) {
        return (1 + 2 * index) % (n | 1);
    }
    
    // Based on quick sort.
    private int findKthLargest(int[] nums, int k) {
        k = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int j = partition(nums, low, high);
            if (j < k) {
                low = j + 1;
            } else if (j > k) {
                high = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }
    
    // Take the first element as the pivot and perform partition, let all elements less than pivot in the left and larger than pivot in the right.
    private int partition(int[] nums, int low, int high) {
        int i = low;
        int j = high + 1;
        while (true) {
            while (i < high && nums[++i] < nums[low]);
            while (j > low && nums[--j] > nums[low]);
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        swap(nums, low, j);
        return j;
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}



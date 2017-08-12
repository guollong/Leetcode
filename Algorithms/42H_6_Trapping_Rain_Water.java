/**
 * Question description: Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 *		compute how much water it is able to trap after raining.
 *
 * Example: Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google, Twitter, Zenefits, Amazon, Apple, Bloomberg.
 */

/**
 * Progress...
 * Create Date: 08/12/2017
 */

// Solution 1: Brute force method: For each element, find the max_left and max_right of the element (including the element itself), 
//      the rain traped by this element is equal to min(max_left, max_right) - height[i].
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        int trappedWater = 0;
        int max_left = 0;
        int max_right = 0;
        for (int i = 1; i < height.length - 1; i++) {
            max_left = 0;
            max_right = 0;
            for (int j = i; j >= 0; j--) {
                max_left = Math.max(max_left, height[j]);
            }
            for (int k = i; k < height.length; k++) {
                max_right = Math.max(max_right, height[k]);
            }
            trappedWater += Math.min(max_left, max_right) - height[i];
        }
        return trappedWater;
    }
}

// Solution 2: Dynamic programming: Precompute the max_left and max_right with two passes, and get the trapped water
//      while the third pass.
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        // Precompute the max_left and max_right array.
        int length = height.length;
        int[] max_left = new int[length];
        int[] max_right =  new int[length];
        max_left[0] = height[0];
        for (int i = 1; i < length; i++) {
            max_left[i] = Math.max(height[i], max_left[i - 1]);
        }
        max_right[length - 1] = height[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            max_right[i] = Math.max(height[i], max_right[i + 1]);
        }

        // Third pass: compute the amount of trapped water.
        int trappedWater = 0;
        for (int i = 1; i < length - 1; i++) {
            trappedWater += Math.min(max_left[i], max_right[i]) - height[i];
        }
        return trappedWater;
    }
}


// Solution 3: Using stack with one pass: (stack is used to store the indices of the array). 
//  while the stack is not empty and the current bar is taller than the top bar of the stack, pop one 
//      element from the stack and label it to "top", and the trapped water is equal to 
//      (min(current, stack.peek()) - height) * (current_index - stack.peek()_index - 1);
//  Push the index of current element to the stack.
public class Solution {

    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int trappedWater = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // If the current element is greater than the top element of the stack, it could trap water.
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (!stack.empty()) {
                    int distance = i - stack.peek() - 1;
                    trappedWater += (Math.min(height[i], height[stack.peek()]) - height[top]) * distance;
                }
            }
            stack.push(i);
        }
        return trappedWater;
    }
}

// Solution 4: Two pointers with constant space.
public class Solution {
    public int trap(int[] height) {
        if (height == null || height.length <= 2) {
            return 0;
        }
        
        int trappedWater = 0;
        int left = 0;
        int right = height.length - 1;
        int max_left = 0;
        int max_right = 0;
        while (left < right) {
            // Water could be trapped at position left, however, only when the height[left] <= max_left, 
            //      the water could be trapped.
            if (height[left] < height[right]) {
                if (height[left] > max_left) {
                    max_left = height[left];
                } else {
                    trappedWater += (max_left - height[left]);
                }
                left++;
            } else {
                // Water could be trapped at position right.
                if (height[right] > max_right) {
                    max_right = height[right];
                } else {
                    trappedWater += (max_right - height[right]);
                }
                right--;
            }
        }
        return trappedWater;
    }
}















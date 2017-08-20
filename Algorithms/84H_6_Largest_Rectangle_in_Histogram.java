/**
 * Question description: Given n non-negative integers representing the histogram's bar height where the width of each 
 *		bar is 1, find the area of largest rectangle in the histogram.
 * 
 * Example: Given heights = [2,1,5,6,2,3], return 10.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Facebook.
 */

/**
 * Progress...
 * Create Date: 08/13/2017
 */

// Solution 1: Improved brute force method.
// Running time complexity: O(n ^ 2). Utilize the minheight of the previous bar.
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        if (heights.length == 1) {
            return heights[0];
        }
        
        int largestArea = 0;
        int minheight = Integer.MAX_VALUE;
        for (int i = 0; i < heights.length; i++) {
            minheight = Integer.MAX_VALUE;
            for (int j = i; j < heights.length; j++) {
                minheight = Math.min(minheight, heights[j]);
                largestArea = Math.max(largestArea, minheight * (j - i + 1));
            }
        }
        return largestArea;
    }
}

// Solution 2: Divide and conquer method. (Time limit exceeded)
// Running time complexity: Average time complexity: O(n * logn). 
//			Worst time complexity: O(n ^ 2), when the array is already sorted.
// Improved divide and conquer method, using segment tree to find the minimum value every time. 
//		See the link of implementation: https://discuss.leetcode.com/topic/45822/segment-tree-solution-just-another-idea-o-n-logn-solution
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        return calculateArea(heights, 0, heights.length - 1);
    }
    
    private int calculateArea(int[] heights, int index1, int index2) {
        if (index1 > index2) {
            return 0;
        }
        // Find the index of minValue between positon index1 and index2 of the array.
        int minIndex = index1;
        for (int i = index1 + 1; i <= index2; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        
        // Get the area based on this minHeight, get the leftMax and rightMax, take the maximum value of these
        // three values.
        int area = heights[minIndex] * (index2 - index1 + 1);
        int leftMax = calculateArea(heights, index1, minIndex - 1);
        int rightMax = calculateArea(heights, minIndex + 1, index2);
        return Math.max(area, Math.max(leftMax, rightMax));
    }
}

// Solution 3: Using stack. (Need to review it later.)
// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
// Running time complexity: O(n): n elements are pushed and poped.
public class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - stack.peek() - 1));
            }
            stack.push(i);
        }
        
        while (stack.peek() != -1) {
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - stack.peek() - 1));
        }
        return maxArea;
    }
}





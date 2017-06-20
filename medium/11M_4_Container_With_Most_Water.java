/**
 * Question description: Given n non-negative integers a1, a2, ..., an, where each represents a 
 *		point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of 
 *		line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, 
 *		such that the container contains the most water.
 * 
 * Note: You may not slant the container and n is at least 2
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/20/2017
 */

// Solution from discussion. 有点儿巧妙啊～～～～
public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
    	int maxArea = Integer.MIN_VALUE;
    
    	while (left < right) {
    		maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));
    		if (height[left] < height[right]){
    		    left++;
    		} else {
    		    right--;
    		}
    	}
    	return maxArea;
    }
}

// Brute force method: Time limit exceeded.
public class Solution {
    public int maxArea(int[] height) {
        int length = height.length;
        int maxarea = Integer.MIN_VALUE;
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                maxarea = Math.max(maxarea, (j - i) * Math.min(height[i], height[j]));
            }
        }
        return maxarea;
    }
}




/**
 * Question description: Find the total area covered by two rectilinear rectangles in a 2D plane. Each rectangle is 
 *		defined by its bottom left corner and top right corner as shown in the figure.
 * 
 * Input: Bottom left corner of two rectangles: (A, B), (E, F).
 * 		  Top right corner of two rectangles: (C, D), (G, H).
 * 
 * Assume that the total area is never beyond the maximum possible value of int.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 09/01/2017
 */

// Idea: sum area of two rectangles and substract intersection of two rectangles.
class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1 = (A - C) * (B - D);
        int area2 = (E - G) * (F - H);
        
        if (C < E || A > G || B > H || F > D) {
            return area1 + area2;
        }
        
        int left = Math.max(A, E);
        int right = Math.min(C, G);
        int down = Math.max(B, F);
        int up = Math.min(D, H);
        return area1 + area2 - (right - left) * (up - down);
    }
}



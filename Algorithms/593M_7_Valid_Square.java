/**
 * Question description: Given the coordinates of four points in 2D space, return whether the four points could 
 *		construct a square. The coordinate (x,y) of a point is represented by an integer array with two integers.
 * 
 * Example: Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]; Output: True.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pure Storage. 
 */

/**
 * Progress...
 * Create Date: 08/31/2017
 */

// Solution 1: brute force method.
// Idea: get all possible permutations of four points, check if the combination could constitute a square.
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};
        return checkAllPermutations(p, 0);
    }
    
    // "l" represents for the level.
    // Get all permutations of four points, check if the combination could constitute a square.
    private boolean checkAllPermutations(int[][] p, int l) {
        if (l == 4) {
            return check(p[0], p[1], p[2], p[3]);
        } else {
            boolean res = false;
            for (int i = l; i < 4; i++) {
                swap(p, l, i);
                res |= checkAllPermutations(p, l + 1);
                swap(p, l, i);
            }
            return res;
        }
    }
    
    private void swap(int[][] p, int x, int y) {
        int[] temp = p[x];
        p[x] = p[y];
        p[y] = temp;
    }
    
    // Conditions of constituting a square: four edges have same length, two diagonals have the same length and the length of edges are not zeros.
    private boolean check(int[] p1, int[] p2, int[] p3, int[] p4) {
        return dist(p1, p2) != 0 && dist(p1, p2) == dist(p2, p3) && dist(p2, p3) == dist(p3, p4) && dist(p3, p4) == dist(p4, p1) && dist(p1, p3) == dist(p2, p4);
    }
    
    private double dist(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}


// Solution 2: Sort the points based on x coordinate first and y coordinate second, check validation of a square.
class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int[][] p = {p1, p2, p3, p4};

        Arrays.sort(p, new Comparator<int[]>(){
            @Override
            public int compare(int[] p1, int[] p2) {
                if (p1[0] == p2[0]) {
                    return p1[1] - p2[1];
                }
                return p1[0] - p2[0];
            }
        });
        
        return dist(p[0], p[1]) != 0 && dist(p[0], p[1]) == dist(p[1], p[3]) && dist(p[1], p[3]) == dist(p[3], p[2]) && dist(p[3], p[2]) == dist(p[2], p[0]) && dist(p[2], p[0]) == dist(p[0], p[1]) && dist(p[0], p[3]) == dist(p[1], p[2]);
    }
    
    private double dist(int[] p1, int[] p2) {
        return (p2[1] - p1[1]) * (p2[1] - p1[1]) + (p2[0] - p1[0]) * (p2[0] - p1[0]);
    }
}




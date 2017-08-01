/**
 * Question description: Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 *		An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 *		You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example: 11000
 *			11000
 *			00100
 *			00011, Answer: 3
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, Microsoft, Google, Facebook, Zenefits.
 */

/**
 * Progress...
 * Create Date: 07/30/2017
 */

// Solution 1: Union find (Weighted quick union and path compression).
public class Solution {    
    private int[] parent;
    private int[] size;
    
    // count is the number of components in the grid, that is the number of islands.
    private int count = 0;
    
    public int numIslands(char[][] grid) {
        // corner case.
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int column = grid[0].length;
        
        // Initialization: Initialially, the parents of elements are themselves.
        parent = new int[row * column];
        size = new int[row * column];
        for (int i = 0; i < row * column; i++) {
            parent[i] = i;
        }
            
        // For each land, build union with its nearby lands.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '1') {
                	count++;
                    int index = i * column + j;
                    if (i > 0 && grid[i - 1][j] == '1') {
                        union(index, (i - 1) * column + j);
                    }
                    if (i + 1 < row && grid[i + 1][j] == '1') {
                        union(index, (i + 1) * column + j);
                    }
                    if (j > 0 && grid[i][j - 1] == '1') {
                        union(index, i * column + j - 1);
                    }
                    if (j + 1 < column && grid[i][j + 1] == '1') {
                        union(index, i * column + j + 1);
                    }
                }
            }
        }
        return count;
        
    }
    
    // Find the parent of element index and update the parents of non-root elements (make flat).
    private int find(int index) {
        if (parent[index] == index) {
            return index;
        }
        parent[index] = parent[parent[index]];
        return find(parent[index]);
    }
    
    // Build union with two elements.
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) {
            return;
        }
        
        int sizeA = size[rootA];
        int sizeB = size[rootB];
        
        if (sizeA > sizeB) {
            parent[rootB] = rootA;
            size[rootA] = sizeA + sizeB;
        } else {
            parent[rootA] = rootB;
            size[rootB] = sizeA + sizeB;
        }
        count--;
    }
}



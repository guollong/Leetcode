/**
 * Question description: A 2d grid map of m rows and n columns is initially filled with water. 
 *		We may perform an addLand operation which turns the water at position (row, col) into a land. 
 *		Given a list of positions to operate, count the number of islands after each addLand operation. 
 *		An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 *		You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example: Given m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]].
 * 	Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *		0 0 0
 *		0 0 0
 *		0 0 0
 *	Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 *		1 0 0
 *		0 0 0   Number of islands = 1
 *		0 0 0
 *	Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 *		1 1 0
 *		0 0 0   Number of islands = 1
 *		0 0 0
 *	Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 *		1 1 0
 *		0 0 1   Number of islands = 2
 *		0 0 0
 *	Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 *		1 1 0
 *		0 0 1   Number of islands = 3
 *		0 1 0
 *	We return the result as an array: [1, 1, 2, 3]
 *
 * Running time complexity: O(k log mn), where k is the length of the positions.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 07/30/2017
 */

// Union find (Weighted quick union and path compression).
public class Solution {

    private int[] parent;
    private int[] size;
    // count: number of islands.
    private int count = 0;
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> list = new ArrayList<Integer>();
        int[][] grid = new int[m][n];
        
        // corner case.
        if (positions == null || positions.length == 0) {
            return list;
        }

        // Initialization.
        parent = new int[m * n];
        size = new int[m * n];
        for (int i = 0; i < m * n; i++) {
            parent[i] = i;
        }
        
        // Every time filling a new land, intially add 1 to the total count, set the value in the grid,
        // and build union with its nearby land.
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            int index = x * n + y;
            grid[x][y] = 1;
            count++;
            
            if (x + 1 < m && grid[x + 1][y] == 1) { 
                // If the element is not at the bottom of the grid.
                union(index, (x + 1) * n + y);
            }
            if (x > 0 && grid[x - 1][y] == 1) { 
                // If the element is not at the top of the grid.
                union(index, (x - 1) * n + y);
            }
            if (y + 1 < n && grid[x][y + 1] == 1) { 
                // If the element is not at the top of the grid.
                union(index, x * n + y + 1);
            }
            if (y > 0 && grid[x][y - 1] == 1) { 
                // If the element is not at the top of the grid.
                union(index, x * n + y - 1);
            }
            list.add(count);
        }
        return list;
    }
    
    // Find the root of the element index and update the parent of non-root elements.
    private int find(Integer index) {
        if (index == parent[index]) {
            return index;
        }
        parent[index] = parent[parent[index]];
        return find(parent[index]);
    }    
    
    // Build a union for two lands.
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
        if (rootA == rootB) {
            return;
        }
        
        int sizeA = size[a];
        int sizeB = size[b];
        
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

/**
 * Question description: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 *		write a function to find the number of connected components in an undirected graph.
 *
 * Example 1: 0          3
 *		      |          |
 *		      1 --- 2    4
 * 		Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], return 2.
 *
 * Example 2: 0           4
 *		      |           |
 *		      1 --- 2 --- 3
 *		Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]], return 1.
 * 
 * Note: You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] 
 *		and thus will not appear together in edges.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Twitter.
 */

/**
 * Progress...
 * Create Date: 07/31/2017
 */

// Solution 1: weighted quick union with path compression.
public class Solution {
    private int[] parent;
    private int[] size;
    
    private int count;
    
    public int countComponents(int n, int[][] edges) {
        // corner case.
        if (edges == null || edges.length == 0) {
            return n;
        }
        
        // Initialization: parent array and size array.
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = n;
        
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            if (find(x) == find(y)) {
                continue;
            }
            union(x, y);
        }
        return count;
    }
    
    private int find(int index) {
        while (index != parent[index]) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    
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

// Solution 2: quick union with path compression.
public class Solution {
    private int[] parent;
    private int count;
    
    public int countComponents(int n, int[][] edges) {
        // corner case.
        if (edges == null || edges.length == 0) {
            return n;
        }
        
        // Initialization.
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        count = n;
        
        // perform union find.
        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            
            // if two vertices happen to be in the same set, then there's a cycle
            if (x == y) {
                continue;
            }
            
            // union. (Not perform weighted quick union)
            parent[x] = y;
            count--;
        }
        return count;
    }
    
    // Perform path compression while finding roots.
    private int find(int index) {
        if (parent[index] == index) {
            return index;
        }
        parent[index] = parent[parent[index]];
        return find(parent[index]);
    }
}

// Solution 3: BFS and DFS.













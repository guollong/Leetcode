/**
 * Question description: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), 
 *		write a function to check whether these edges make up a valid tree.
 *
 * Example: Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.
 *		Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.
 *
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] 
 *		and thus will not appear together in edges.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Facebook, Zenefits.
 */

/**
 * Progress...
 * Create Date: 07/31/2017
 */

// Solution 1: weighted quick union with path compression.
// Graph valid tree: Finally, there should be only one component and while looping over the edges. And there exists a circle if two 
//		elements have same root.
public class Solution {
    private int[] parent;
    private int[] size;
    
    public boolean validTree(int n, int[][] edges) {
        // corner case.
        if (edges.length != n - 1) {
            return false;
        }
        
        // Initialization: parent array and size array.
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        
        for (int i = 0; i < edges.length; i++) {
            int x = edges[i][0];
            int y = edges[i][1];
            
            // There exists circle in the graph, so it is not a tree.
            if (find(x) == find(y)) {
                return false;
            }
            union(x, y);
        }
        return true;
        
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
    }
}

// Solution 2: Union find: quick union with path compression.
public class Solution {
    private int[] parent;
    
    public boolean validTree(int n, int[][] edges) {
        // Corner case.
        if (edges.length != n - 1) {
            return false;
        }
        
        // Initialization.
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        // perform union find.
        for (int i = 0; i < edges.length; i++) {
            int x = find(edges[i][0]);
            int y = find(edges[i][1]);
            
            // if two vertices happen to be in the same set, then there's a cycle
            if (x == y) {
                return false;
            }
            
            // union. (Not perform weighted quick union)
            parent[x] = y;
        }
        return true;
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
















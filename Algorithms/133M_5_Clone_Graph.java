/**
 * Question description: Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 *
 * OJ's undirected graph serialization: Nodes are labeled uniquely.
 * 		We use # as a separator for each node, and , as a separator for node label and each neighbor of the node.
 * 
 * Example: consider the serialized graph {0,1,2#1,2#2,2}.
 * 		The graph has a total of three nodes, and therefore contains three parts as separated by #.
 *		First node is labeled as 0. Connect node 0 to both nodes 1 and 2. Second node is labeled as 1. 
 *		Connect node 1 to node 2. Third node is labeled as 2. Connect node 2 to node 2 (itself), thus forming a 
 *		self-cycle.
 *
 * 	Visually, the graph looks like the following:
 *	       1
 *	      / \
 *	     /   \
 *	    0 --- 2
 *	         / \
 *	         \_/
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket Gems, Google, Uber, Facebook. 
 */

/**
 * Progress...
 * Create Date: 08/02/2017
 */

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */

// Solution 1: DFS.
public class Solution {
	// Store visited nodes.
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // base case.
        if (node == null) {
            return null;
        }
        
        // recursive case.
        if (map.containsKey(node.label)) {
            return map.get(node.label);
        }
        // if node has not been cloned.
        UndirectedGraphNode cloneNode = new UndirectedGraphNode(node.label);
        // Attention: must put into map before add its neighbors, since if we put it to the map after adding 
        //      all its neighbors, it will cause stack overflow.
        map.put(node.label, cloneNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraph(neighbor));
        }
        return cloneNode;
    }
}

// Solution 2: BFS.
public class Solution {
    // Store visited nodes.
    private Map<Integer, UndirectedGraphNode> map = new HashMap<>();
    private Queue<UndirectedGraphNode> queue = new LinkedList<>();
    
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(newNode.label, newNode);
        queue.offer(node);
        
        while (!queue.isEmpty()) {
            UndirectedGraphNode nodeTemp = queue.poll();
            for (UndirectedGraphNode neighbor : nodeTemp.neighbors) {
                if (!map.containsKey(neighbor.label)) {
                    map.put(neighbor.label, new UndirectedGraphNode(neighbor.label));
                    queue.offer(neighbor);
                }
                map.get(nodeTemp.label).neighbors.add(map.get(neighbor.label));
            }
        }
        
        return newNode;
    }
}




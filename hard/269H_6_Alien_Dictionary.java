/**
 * Question description: There is a new alien language which uses the latin alphabet. However, the order 
 *		among letters are unknown to you. You receive a list of non-empty words from the dictionary, where 
 *		words are sorted lexicographically by the rules of this new language. Derive the order of letters 
 *		in this language.
 * 
 * Example 1: Given the following words in dictionary,
 *		[ "wrt",
 *		  "wrf",
 *		  "er",
 *		  "ett",
 *		  "rftt" ]
 * 		The correct order is: "wertf".
 * 
 * Example 2: Given the following words in dictionary,
 *
 *		[ "z",
 *		  "x" ]
 *		The correct order is: "zx".
 * 
 * Example 3: Given the following words in dictionary,
 *		[ "z",
 *		  "x",
 *		  "z" ]
 *		The order is invalid, so return "".
 * 
 * Note: You may assume all letters are in lowercase.
 *		You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 *		If the order is invalid, return an empty string.
 *		There may be multiple valid order of letters, return any one of them is fine.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Airbnb, Facebook, Twitter, Snapchat, Pocket Gems.
 */

/**
 * Progress...
 * Create Date: 08/03/2017
 */

// Solution 1: Topological sorting with BFS and adjacency list.
// Topological sorting only works for directed acyclic graph.
// Using adjacency list: node and its linked-out nodes.
public class Solution {
    public String alienOrder(String[] words) {
        // corner case.
        if (words == null || words.length == 0) {
            return "";
        }
            
        // Used to represent the directed graph.
        Map<Character, Set<Character>> map = new HashMap<>();
        // Used to store the degrees of the nodes in current state.
        Map<Character, Integer> degree = new HashMap<>();
        
        // Initialize the degrees of nodes to be all 0s.
        String result = "";
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                degree.put(c, 0);
            }
        }
        
        // Build the graph and store the degree of the nodes. (入度)
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            Set<Character> tempSet;
            int length = Math.min(s1.length(), s2.length());
            for (int j = 0; j < length; j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if (c1 != c2) {
                    if (map.containsKey(c1)) {
                        tempSet = map.get(c1);
                    } else {
                        tempSet = new HashSet<Character>();
                    }
                    if (!tempSet.contains(c2)) {
                        tempSet.add(c2);
                        map.put(c1, tempSet);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        
        Queue<Character> queue = new LinkedList<>();
        // Initially put all nodes with 0 degree into the queue.
        for (char c : degree.keySet()) {
            if (degree.get(c) == 0) {
                queue.offer(c);
            }
        }
        // Every time remove a node from graph, remove all connections with itself. (substract 1 to the degree of all linked-out nodes)
        while (!queue.isEmpty()) {
            char c = queue.poll();
            result += c;
            if (map.containsKey(c)) {
                for (char c2 : map.get(c)) {
                    degree.put(c2, degree.get(c2) - 1);
                    if (degree.get(c2) == 0) {
                        queue.add(c2);
                    }
                }
            }
        }
        if (result.length() != degree.size()) {
            return "";
        }
        return result;
    }
}

// Solution 2: Topological sorting with DFS and adjacency matrix.
public class Solution {
    
    private final int N = 26;
    
    public String alienOrder(String[] words) {
        
        // Using adjacency matrix to represent a graph.
        boolean[][] adj = new boolean[N][N];
        
        // Used to label whether a node is visited or not while performing DFS. -1: not exist; 0: not visited; 1: visiting; 2: visited.
        int[] visited = new int[N];
        
        // Build a graph based on words in alien dictionary.
        buildGraph(words, adj, visited);
        
        // Perform DFS to the graph.
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            // If the node is not visited.
            if (visited[i] == 0) {
                if (!dfs(adj, visited, result, i)) {
                    return "";
                }
            }
        }
        return result.reverse().toString();
    }
    
    private boolean dfs(boolean[][] adj, int[] visited, StringBuilder sb, int i) {
        visited[i] = 1;
        for (int j = 0; j < N; j++) {
            if (adj[i][j]) {
                if (visited[j] == 1) { // cycle.
                    return false;
                }
                if (visited[j] == 0) {
                    if (!dfs(adj, visited, sb, j)) {
                        return false;
                    }
                }
            }

        }
        visited[i] = 2;
        sb.append((char) (i + 'a'));
        return true;
    }
    
    private void buildGraph(String[] words, boolean[][] adj, int[] visited) {
        Arrays.fill(visited, -1);
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visited[c - 'a'] = 0;
            }
            if (i > 0) {
                String s1 = words[i - 1];
                String s2 = words[i];
                int length = Math.min(s1.length(), s2.length());
                for (int j = 0; j < length; j++) {
                    char c1 = s1.charAt(j);
                    char c2 = s2.charAt(j);
                    if (c1 != c2) {
                        adj[c1- 'a'][c2 - 'a'] = true;
                        break;
                    }
                }
            }
        }
    }
    
}

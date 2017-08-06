/**
 * Question description: Given a 2D board and a list of words from the dictionary, find all words in the board.
 * 		Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those 
 *		horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 * 
 * Example: Given words = ["oath","pea","eat","rain"] and 
 *	board =
 *		[
 *		  ['o','a','a','n'],
 *		  ['e','t','a','e'],
 *	 	  ['i','h','k','r'],
 *		  ['i','f','l','v']
 *		]
 *	Return ["eat","oath"].
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Google, Airbnb. 
 */

/**
 * Progress...
 * Create Date: 08/05/2017
 */

// Overral idea: Build a trie based on the words array and check every possible words from
// 		the board to see if they are in the trie.  

// Solution 2: Improved solution.
public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    // no need to search from the root every time.
    // label visited node to be '#' to save O(n^2) space for visited array.
    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {
            res.add(p.word);
            p.word = null;  // no duplicates.
        }

        board[i][j] = '#';
        dfs(board, i - 1, j ,p, res); 
        dfs(board, i + 1, j ,p, res); 
        dfs(board, i, j + 1 ,p, res); 
        dfs(board, i, j - 1 ,p, res); 
        board[i][j] = c;
    }
    
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (temp.next[i] == null) {
                    temp.next[i] = new TrieNode();
                }
                temp = temp.next[i];
            }
            temp.word = word;
        }
        return root;
    }
    
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }
}


// Solution 1: reuse the code of startsWith and search function in the trie implementation.	
public class Solution {
	// Used for no duplicates.
    Set<String> result = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        
        int row = board.length;
        int column = board[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
            	// use dfs to find words that starts with board[i][j] and also in the trie.
                dfs(board, visited, "", i, j, trie);
            }
        }
        return new ArrayList<String>(result);
    }
    
    private void dfs(char[][] board, boolean[][] visited, String str, int i, int j, Trie trie) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j]) {
            return;
        }
        str += board[i][j];
        // pruning the search while it is not a prefix of the trie.
        if (!trie.startsWith(str)) {
            return;
        }
        if (trie.search(str)) {
            result.add(str);
        }

        visited[i][j] = true;
        dfs(board, visited, str, i - 1, j, trie);
        dfs(board, visited, str, i + 1, j, trie);
        dfs(board, visited, str, i, j - 1, trie);
        dfs(board, visited, str, i, j + 1, trie);
        visited[i][j] = false;
    }
    
    private class Trie {
        private TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode(' ');
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                TrieNode[] child = temp.children;
                char c = word.charAt(i);
                if (child[c - 'a'] == null) {
                    child[c - 'a'] = new TrieNode(c);
                }
                temp = child[c - 'a'];
            }
            temp.isValidWord = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode temp = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (temp.children[c - 'a'] == null) {
                    return false;
                }
                temp = temp.children[c - 'a'];
            }
            return temp.isValidWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                if (temp.children[c - 'a'] == null) {
                    return false;
                }
                temp = temp.children[c - 'a'];
            }
            return true;
        }

        private class TrieNode {
            TrieNode[] children = new TrieNode[26];
            char currC;
            boolean isValidWord;

            public TrieNode(char c) {
                currC = c;
            }
        }
    }
}


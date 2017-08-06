/**
 * Question description: Implement a trie with insert, search, and startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Google, Uber, Facebook, Twitter, Microsoft, Bloomberg.
 */

/**
 * Progress...
 * Create Date: 08/05/2017
 */

// Store character in the trie node.
public class Trie {
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
    
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        char currC;
        boolean isValidWord;
        
        public TrieNode(char c) {
            currC = c;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */



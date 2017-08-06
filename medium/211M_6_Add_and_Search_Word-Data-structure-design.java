/**
 * Question description: Design a data structure that supports the following two operations:
 * 		void addWord(word)
 *		bool search(word)
 *	search(word) can search a literal word or a regular expression string containing only letters a-z or .. 
 *	A . means it can represent any one letter.
 * 
 * Example: addWord("bad")
 *			addWord("dad")
 *			addWord("mad")
 *			search("pad") -> false
 *			search("bad") -> true
 *			search(".ad") -> true
 *			search("b..") -> true
 *
 * Note: You may assume that all words are consist of lowercase letters a-z.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Facebook. 
 */

/**
 * Progress...
 * Create Date: 08/05/2017
 */


public class WordDictionary {

    private TrieNode root;
    private int maxLength;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode(' ');
        maxLength = Integer.MIN_VALUE;
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        maxLength = Math.max(maxLength, word.length());

        TrieNode temp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (temp.children[c - 'a'] == null) {
                temp.children[c - 'a'] = new TrieNode(c);
            }
            temp = temp.children[c - 'a'];
        }
        temp.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if (word.length() > maxLength) {
            return false;
        }
        return match(word, 0, root);
    }
    
    private boolean match(String word, int i, TrieNode root) {
    	// Attention this corner case. When the searching hits the end of the word, check if the node in the 
    	//		tree is a valid word or not.
        if (i == word.length()) {
            return root.isWord;
        }

        char c = word.charAt(i);
        if (c != '.') {
            return root.children[c - 'a'] != null && match(word, i + 1, root.children[c - 'a']);
        } else {
            for (int j = 0; j < 26; j++) {
                if (root.children[j] != null) {
                    if (match(word, i + 1, root.children[j])) {
                        return true;
                    }
                } 
            }
        }
        return false;
    }
    
    private static class TrieNode {
        char c;
        TrieNode[] children;
        boolean isWord;
        
        TrieNode (char c) {
            this.c = c;
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */



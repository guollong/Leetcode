/**
 * Question description: Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 *		transformation sequence from beginWord to endWord, such that:
 *		Only one letter can be changed at a time.
 *		Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * 
 * Example: Given: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 *		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog";
 * 		Return
 *	  	[
 *	    	["hit","hot","dot","dog","cog"],
 *	    	["hit","hot","lot","log","cog"]
 *	  	]
 * 
 * Note: Return 0 if there is no such transformation sequence.
 *		 All words have the same length.
 *		 All words contain only lowercase alphabetic characters.
 *		 You may assume no duplicates in the word list.
 *		 You may assume beginWord and endWord are non-empty and are not the same.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Amazon, Yelp. 
 */

/**
 * Progress...
 * Create Date: 08/21/2017
 */

// Solution 1: 
// 1st step: Use BFS to construct a graph. 
// 2nd step: Use DFS to construct the paths from end to start.
class Solution {
    
    // map: store the parent of each node in its shortest path.
    // Dijikstra algorithm: Find the shortest path from beginning node to every other node in the graph.
    Map<String, List<String>> map = new HashMap<>();
    List<List<String>> result = new ArrayList<>();
    
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // corner case.
        if (wordList.size() == 0 || !wordList.contains(endWord)) {
            return result;
        }
        
        // The minimum number of ladders.
        int min = Integer.MAX_VALUE;
        
        // queue is used to store the visited word.
        Queue<String> queue = new ArrayDeque<>();
        queue.add(beginWord);
        
        // Intialization.
        // Use a map to store the min ladder of each word.
        // ladder map: How many steps are needed to travel to one word.
        Map<String, Integer> ladder = new HashMap<>();
        for (String s : wordList) {
            ladder.put(s, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        
        // BFS: Dijikstra search.
        while (!queue.isEmpty()) {
            String word = queue.poll();
            // "step" indicates how many steps are needed to travel to one word.
            int step = ladder.get(word) + 1;
            
            // Only update when the step is smaller than minimum value.
            if (step > min) {
                break;
            }
            
            // For every possible words that only have one character different from the current word.
            // Update ladder number of the children of the current node.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder sb = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    // If the word is in the dictionary.
                    if (ladder.containsKey(newWord)) {
                        if (step > ladder.get(newWord)) {
                            continue;
                        } else if (step < ladder.get(newWord)) {
                            queue.add(newWord);
                            ladder.put(newWord, step);
                        }
                        
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);
                        } else {
                            List<String> list = new LinkedList<>();
                            list.add(word);
                            map.put(newWord, list);
                        }
                        
                        if (newWord.equals(endWord)) {
                            min = step;
                        }
                    } // End of "ladder.containsKey(newWord)"
                } // End of "for (char ch = 'a'; ch <= 'z'; ch++)"
            } // End of "for (int i = 0; i < word.length(); i++)"
        } // End of "while (!queue.isEmpty())"
        
        backTrace(endWord, beginWord, new LinkedList<String>());
        return result;
    }
    
    // Function: Get the result lists from map using DFS.
    private void backTrace(String word, String start, List<String> list) {
        // Base case.
    	if (word.equals(start)) {
    		list.add(0, start);
    		result.add(new ArrayList<String>(list));
    		list.remove(0);
    		return;
    	}
        
        // recursive case. 
    	list.add(0, word);
    	if (map.get(word) != null) {
    		for (String s : map.get(word)) {
                backTrace(s, start, list);
            }
        }
    	list.remove(0);
    }
}









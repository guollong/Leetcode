/**
 * Question description: Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest 
 *		transformation sequence from beginWord to endWord, such that:
 *		Only one letter can be changed at a time.
 *		Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * 
 * Example: Given: beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","log","cog"]
 *		As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", return its length 5.
 * 
 * Note: Return 0 if there is no such transformation sequence.
 *		 All words have the same length.
 *		 All words contain only lowercase alphabetic characters.
 *		 You may assume no duplicates in the word list.
 *		 You may assume beginWord and endWord are non-empty and are not the same.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Amazon, LinkedIn, Snapchat, Facebook, Yelp. 
 */

/**
 * Progress...
 * Create Date: 08/20/2017
 */

// Solution 1: Typical BFS method. 
// Time complexity and space complexity: O(n * 26^L)
// n is the number of words that the ladder has and L is the length of each word.
public class Solution {
    public int ladderLength(String start, String end, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        
        if (start.equals(end)) {
            return 1;
        }
        
        HashSet<String> visited = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        visited.add(start);
        
        int length = 1;
        while (!queue.isEmpty()) {
            length++;
            // bfs: get the number of nodes in that level.
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                for (String nextWord: getNextWords(word, dict)) {
                    if (visited.contains(nextWord)) {
                        continue;
                    }
                    if (nextWord.equals(end)) {
                        return length;
                    }
                    
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    // Time complexity: O(26 ^ length)
    // Get the next possible word list which only has one character different from the word.
    // given word = 'hot', dict = {'hot', 'hit', 'hog'}, it will return ['hit', 'hog']
    private ArrayList<String> getNextWords(String word, Set<String> dict) {
        ArrayList<String> nextWords = new ArrayList<String>();
        char[] chs = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char old = chs[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (old == c) {
                    continue;
                }
                chs[i] = c;
                String next = String.valueOf(chs);
                if (dict.contains(next)) {
                    nextWords.add(next);
                }
            }
            chs[i] = old;
        }
        return nextWords;
    }
}


// Solution 2: Improved BFS. (Two-end method)
//		Traverse the path from start node and end node, and merge in the middle.
// 
// The intuition is that you are replacing a big search tree in the one-end solution with two smaller trees in the 
//		two-end solution. Both solutions have the same TOTAL depth, yet tree width grows exponentially w.r.t. depths, 
//		and the two-end solutions results in less nodes being visited.

// Time complexity and space complexity: O((less nodes) * 26^L)
// n is the number of words that the ladder has and L is the length of each word.
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> dict = new HashSet<>(wordList);
        beginSet.add(beginWord);
        endSet.add(endWord);
        
        int minLen = 1;
        Set<String> visited = new HashSet<>();
        visited.add(endWord);
        
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // Keep two set balance.
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            
            Set<String> temp = new HashSet<String>();
            // Get every possible word that only has one different character with the word in the begin set.
            // Put all possible words that could come next to the temparary set, and set it to the beginSet in the end.
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        // String.valueOf() example:
                        // char[] arr = {'a', 'b', 'c', 'd', 'e', 'f','g' };
                        // String.valueOf(arr);  // abcdefg
                        String target = String.valueOf(chs);
                        if (endSet.contains(target)) {
                            return minLen + 1;
                        }
                        
                        // If the target is not visited and the target is in the dictionary, put it into the temp set
                        // and set it to be visited. 
                        if (!visited.contains(target) && dict.contains(target)) {
                            temp.add(target);
                            visited.add(target);
                        }
                        chs[i] = old;
                    }
                }
            }
            
            beginSet = temp;
            minLen++;
        }
        
        return 0;
    }
}



// Solution 3: Dijkstra algorithm: find the shortest distance from the start node to every other nodes in the graph.
// Need to two sets: visited and unvisited.

// Time complexity and space complexity: O(n * 26^L)
// n is the number of words that the ladder has and L is the length of each word.
public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordDict) {
        if (!wordDict.contains(endWord)) {
            return 0;
        }
        
        // reached is the set that has been visited.
        Set<String> reached = new HashSet<String>();
        // dict contains nodes that haven't been visited.
        Set<String> dict = new HashSet<>(wordDict);
        reached.add(beginWord);
        
        int distance = 1;
        while (!reached.contains(endWord)) {
            Set<String> toAdd = new HashSet<String>();
            for (String each : reached) {
                for (int i = 0; i < each.length(); i++) {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        chars[i] = ch;
                        String word = new String(chars);
                        if (dict.contains(word)) {
                            toAdd.add(word);
                            dict.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) {
                return 0;
            }
            reached = toAdd;
        }
        return distance;
    }
}






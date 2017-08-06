/**
 * Question description: Given a 2D board and a word, find if the word exists in the grid. The word can be 
 *		constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally 
 *		or vertically neighboring. The same letter cell may not be used more than once.
 * 
 * Example,
 *	Given board =
 *		[
 *		  ['A','B','C','E'],
 *		  ['S','F','C','S'],
 *		  ['A','D','E','E']
 *		]
 *	word = "ABCCED", -> returns true,
 *	word = "SEE", -> returns true,
 *	word = "ABCB", -> returns false.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Microsoft, Bloomberg, Facebook, Pocket Gems. 
 */

/**
 * Progress...
 * Create Date: 08/04/2017
 */

// DFS.
// Idea: Search all possible paths in the board starting with the first character of the word. Use DFS to search
//		four directions of the cell recursively.
public class Solution {
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
    	// Corner case.
        if (board == null || board.length == 0) {
            return false;
        }
        int row = board.length;
        int column = board[0].length;
        if (row * column < word.length()) {
            return false;
        }
        
        // Search all possible path starting with the first character of the word.
        visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == word.charAt(0) && searchSuccess(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    // Return true if there is a path from board[i][j] that constains word starting from index "start".
    private boolean searchSuccess(char[][] board, int i, int j, String word, int start) {
    	// if i or j is out of range, or the cell has been visited, or two characters are not the same, return false.
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || 
            visited[i][j] || board[i][j] != word.charAt(start)) {
            return false;
        }

        // if two characters are the same, label it to visited.
        visited[i][j] = true;
        if (start == word.length() - 1) {
            return true;
        }
        
        // search 4 directions.
        if (searchSuccess(board, i, j - 1, word, start + 1) || searchSuccess(board, i, j + 1, word, start + 1)
            || searchSuccess(board, i - 1, j, word, start + 1) || searchSuccess(board, i + 1, j, word, start + 1)) {
            return true;
        }

        // Attention please: If there is no path could be found, label the cell to be unvisited again.
        visited[i][j] = false;
        return false;
        
    }
}



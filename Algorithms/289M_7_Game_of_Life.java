/**
 * Question description: Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 *		Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules 
 *		(taken from the above Wikipedia article):
 * 
 *		1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 *		2. Any live cell with two or three live neighbors lives on to the next generation.
 *		3. Any live cell with more than three live neighbors dies, as if by over-population..
 *		4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * 
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 *	Could you solve it in-place? Remember that the board needs to be updated at the same time.
 *	In this question, we represent the board using a 2D array. In principle, the board is infinite, which would 
 *		cause problems when the active area encroaches the border of the array. How would you address these problems?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Dropbox, Google, Two Sigma, Snapchat.
 */

/**
 * Progress...
 * Create Date: 09/02/2017
 */

// Solution 1: Follow up: in-place update. The default next is 0, we only care about the states that will remain or 
//		change to live in the next state (case2 and case 4).
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int neighbor = neighborAlive(board, i, j);
                if (board[i][j] == 1 && (neighbor == 2 || neighbor == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && neighbor == 3) {
                    board[i][j] = 2;
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    
    private int neighborAlive(int[][] board, int indexI, int indexJ) {
        int aliveNeighbor = 0;
        for (int i = indexI - 1; i <= indexI + 1; i++) {
            for (int j = indexJ - 1; j <= indexJ + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    if (!(i == indexI && j == indexJ) && (board[i][j] & 1) == 1) {
                        aliveNeighbor++;
                    }
                }
            }
        }
        return aliveNeighbor;
    }
}


// Solution 2: My original solution: Use extra array to store the updated values. 
class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int column = board[0].length;
        int[][] boardTemp = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int neighbor = neighborAlive(board, i, j);
                if (board[i][j] == 1 && (neighbor < 2 || neighbor > 3)) {
                    boardTemp[i][j] = 0;
                } else if (board[i][j] == 0 && neighbor == 3) {
                    boardTemp[i][j] = 1;
                } else {
                    boardTemp[i][j] = board[i][j];
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = boardTemp[i][j];
            }
        }
    }
    
    private int neighborAlive(int[][] board, int indexI, int indexJ) {
        int aliveNeighbor = 0;
        for (int i = indexI - 1; i <= indexI + 1; i++) {
            for (int j = indexJ - 1; j <= indexJ + 1; j++) {
                if (i >= 0 && i < board.length && j >= 0 && j < board[0].length) {
                    if (!(i == indexI && j == indexJ) && board[i][j] == 1) {
                        aliveNeighbor++;
                    }
                }
            }
        }
        return aliveNeighbor;
    }
}

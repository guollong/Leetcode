/**
 * Question description: Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
 * 		A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * Example: X X X X
 *			X O O X
 *			X X O X
 *			X O X X
 * After running your function, the board should be:
 *			X X X X
 *			X X X X
 *			X X X X
 *			X O X X
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Pocket gems.
 */

/**
 * Progress...
 * Create Date: 07/31/2017
 */

// Solution 1: DFS.
public class Solution {
    public void solve(char[][] board) {
        // corner case.
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        
        int row = board.length;
        int column = board[0].length;
        
        // We only care about the Os on the edges.
        // Check the Os on the first and last row.
        for (int j = 0; j < column; j++) {
            if (board[0][j] == 'O') {
                boundaryDFS(board, 0, j);
            }
            if (board[row - 1][j] == 'O') {
                boundaryDFS(board, row - 1, j);
            }
        }
        
        // Check the Os on the first and last column.
        for (int i = 0; i < row; i++) {
            if (board[i][0] == 'O') {
                boundaryDFS(board, i, 0);
            }
            if (board[i][column - 1] == 'O') {
                boundaryDFS(board, i, column - 1);
            }
        }
        
        // post process: change all Os to X, and change all *s to O.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '*') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    // Change all Os connects to the board[i][j] to * including board[i][j] itself.
    private void boundaryDFS(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length) {
            return;
        }
        if (board[i][j] == 'O') {
            board[i][j] = '*';
        }
        if (i > 1 && board[i - 1][j] == 'O') {
            boundaryDFS(board, i - 1, j);
        }
        if (j > 1 && board[i][j - 1] == 'O') {
            boundaryDFS(board, i, j - 1);
        }
        if (i < board.length - 2 && board[i + 1][j] == 'O') {
            boundaryDFS(board, i + 1, j);
        }
        if (j < board[0].length - 2 && board[i][j + 1] == 'O') {
            boundaryDFS(board, i, j + 1);
        }
    }
}

// Solution 2: Union find. 
public class Solution {
    
    private int[] parent;
    private int[] size;
    private int count;
    
    public void solve(char[][] board) {
        // corner case.
        if (board.length <= 2 || board[0].length <= 2) {
            return;
        }
        
        // Initialization.
        int row = board.length;
        int column = board[0].length;
        parent = new int[row * column + 1];
        size = new int[row * column + 1]; 
        for (int i = 0; i < row * column + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }
        count = row * column;
        
        // Perform union operations.
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int index = i * column + j;
                if ((i == 0 || j == 0 || i == row - 1 || j == column - 1) && board[i][j] == 'O') {
                    union(index, row * column);
                } else if (board[i][j] == 'O') {
                    if (board[i - 1][j] == 'O') {
                        union(index, (i - 1) * column + j);
                    }
                    if (board[i + 1][j] == 'O') {
                        union(index, (i + 1) * column + j);
                    }
                    if (board[i][j - 1] == 'O') {
                        union(index, i * column + j - 1);
                    }
                    if (board[i][j + 1] == 'O') {
                        union(index, i * column + j + 1);
                    }
                }
            }
        }
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int index = i * column + j;
                if (!connected(index, row * column)) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private int find(int index) {
        while (index != parent[index]) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    
    private void union(int index1, int index2) {
        int rootA = find(index1);
        int rootB = find(index2);
        
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
        count--;
    }
    
    private boolean connected(int index1, int index2) {
        int rootA = find(index1);
        int rootB = find(index2);
        
        if (rootA == rootB) {
            return true;
        }
        return false;
    }
}






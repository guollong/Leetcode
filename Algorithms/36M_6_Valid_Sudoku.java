/**
 * Question description: Determine if a Sudoku is valid.
 * 
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Snapchat, Uber, Apple.
 */

/**
 * Progress...
 * Create Date: 08/22/2017
 * Update Date: 10/22/2017
 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            Set<Character> rows = new HashSet<>();
            Set<Character> columns = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            // The starting point of the cube.
            int rowIndex = 3 * (i / 3);
            int columnIndex = 3 * (i % 3);
            
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !rows.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !columns.add(board[j][i])) {
                    return false;
                }
                if (board[rowIndex + j / 3][columnIndex + j % 3] != '.' && 
                    !cube.add(board[rowIndex + j / 3][columnIndex + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }
}

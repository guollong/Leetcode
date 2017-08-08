/**
 * Question description: You are given a map in form of a two-dimensional integer grid 
 *		where 1 represents land and 0 represents water. Grid cells are connected 
 *		horizontally/vertically (not diagonally). The grid is completely surrounded by 
 *		water, and there is exactly one island. The island doesn't have "lakes" (water 
 *		inside that isn't connected to the water around the island). One cell is a square 
 *		with side length 1. The grid is rectangular, width and height don't exceed 100. 
 *		Determine the perimeter of the island.
 *
 * Example: 
 * [[0,1,0,0],
 *	[1,1,1,0],
 *	[0,1,0,0],
 *	[1,1,0,0]]
 *	Answer: 16
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google.
 */

/**
 * Progress...
 * Create Date: 06/01/2017
 */

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int row = grid.length;
        int column = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    // If the left of the grid is 1, substract 2 to the result.
                    // If the up of the grid is 1, substract 2 to the result.
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }
}

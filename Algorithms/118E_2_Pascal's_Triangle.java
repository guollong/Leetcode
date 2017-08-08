/**
 * Question description: Given numRows, generate the first numRows of Pascal's triangle.
 *
 * Example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Apple, Tiwtter.
 */

/**
 * Progress...
 * Create Date: 06/06/2017
 */

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        for (int i = 1; i <= numRows; i++) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(1);
            for (int j = 1; j < i; j++) {
                if (j == i - 1) {
                    sublist.add(1);
                } else {
                    List<Integer> temp = result.get(i - 2);
                    sublist.add(temp.get(j) + temp.get(j - 1));
                }
            }
            result.add(sublist);
        }
        return result;
    }
}



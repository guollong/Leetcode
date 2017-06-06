/**
 * Question description: Given an index k, return the kth row of the Pascal's triangle.
 * 
 * Example, given k = 3, Return [1,3,3,1].
 * 
 * Note: Could you optimize your algorithm to use only O(k) extra space?
 *
 * Given numRows = 5,
 * The Pascal's triangle looks like this....
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
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/06/2017
 */

// Use only O(k) extra space. Get the next row by replacing the previous row.
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        int i = 0;
        result.add(1);
        while (i++ < rowIndex) {
            for (int j = result.size() - 1; j > 0; j--) {
                result.set(j, result.get(j) + result.get(j - 1));
            }
            result.add(1);
        }
        return result;
    }
}

// Similiar method with question 118. Get the Pascal's triangle firstly and then return the last row.
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> list = new ArrayList<>();
        int i = 0;
        for (; i <= rowIndex; i++) {
            List<Integer> sublist = new ArrayList<>();
            sublist.add(1);
            for (int j = 1; j < i + 1; j++) {
                if (j == i) {
                    sublist.add(1);
                } else {
                    List<Integer> temp = list.get(i - 1);
                    sublist.add(temp.get(j) + temp.get(j - 1));
                }
            }
            list.add(sublist);
        }
        return list.get(i - 1);
    }
}






















}


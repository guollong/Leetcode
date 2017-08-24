/**
 * Question description: The set [1,2,3,…,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 *	"123"
 *	"132"
 *	"213"
 *	"231"
 *	"312"
 *	"321"
 * Given n and k, return the kth permutation sequence.
 * 
 * Note: Given n will be between 1 and 9 inclusive.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Twitter.
 */

/**
 * Progress...
 * Create Date: 08/23/2017
 */

public class Solution {
    public String getPermutation(int n, int k) {
        int pos = 0;
        k = k - 1;      // The corresponding index of the kth permutation.
        StringBuilder sb = new StringBuilder();

        // Create an array of factorial lookup: factorial[] = {1, 1, 2, 6, 24, ... n!}
        int[] factorial = new int[n + 1];
        int sum = 1;
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            sum *= i;
            factorial[i] = sum;
        }

        // Create a list of numbers to get indices: factorial[] = {1, 2, 3, 4, ... }
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        
        for (int i = 1; i <= n; i++) {
            int index = k / factorial[n - i];
            sb.append(numbers.get(index) + "");
            numbers.remove(index);
            k -= index * factorial[n - i];
        }

        return sb.toString();
    }
}



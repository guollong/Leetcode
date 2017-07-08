/**
 * Question description: Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 * 
 * Example: Given n = 3, there are a total of 5 unique BST's.
 *	   1         3     3      2      1
 *	    \       /     /      / \      \
 *	     3     2     1      1   3      2
 *	    /     /       \                 \
 *	   2     1         2                 3
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Snapchat.
 */

/**
 * Progress...
 * Create Date: 07/07/2017
 */

// Dynamic programming: Sequence DP.

/** 
 * Idea.
 * Two functions: 
 *      G(n): the number of unique BST for a sequence of length n.
 *      F(i, n), 1 <= i <= n: the number of unique BST, where the number i is the root of BST, 
 *           and the sequence ranges from 1 to n.
 *      G(n) = F(1, n) + F(2, n) + ... + F(n, n). 
 * Initialization: there is only one combination to construct a BST out of a sequence of length 1 
 *      (only a root) or 0 (empty tree). G(0) = 1, G(1) = 1. 
 * Function: F(i, n) = G(i-1) * G(n-i), 1 <= i <= n.
 *           G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0);
 * 
 */

public class Solution {
    public int numTrees(int n) {
        // State: the number of ways to construct unique BST for a sequence of length n.
        int [] G = new int[n + 1];
        
        // Initialization. For empty tree or tree which only has one root, there is only one way.
        G[0] = 1;
        G[1] = 1;

        // Function.
        // "i" represents for the total length;
        // "j" represents for the root of the BST.
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }

        return G[n];
    }
}



/**
 * Question description: There are N students in a class. Some of them are friends, while some are not. 
 *		Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a 
 *		direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group 
 *		of students who are direct or indirect friends.
 * 
 *	Given a N*N matrix M representing the friend relationship between students in the class. 
 *		If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. 
 *		And you have to output the total number of friend circles among all the students.
 * 
 * Example 1: Input: [[1,1,0],
 *				      [1,1,0],
 *					  [0,0,1]], Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a friend circle. The 2nd student 
 *		himself is in a friend circle. So return 2.
 * 
 * Note: N is in range [1,200]. M[i][i] = 1 for all students. If M[i][j] = 1, then M[j][i] = 1.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Two sigma.
 */

/**
 * Progress...
 * Create Date: 07/31/2017
 */

// Solution 1: weighted quick union and path compression.
// Be careful of the initialization of count and the way to perform union operations.
// n个人最多形成n个朋友圈，所以count初始化为n。
public class Solution {
    
    // The index of the parent of each element.
    private int[] parent;
    private int[] size;
    
    // The number of friend circles. Be careful of the initialization of count and the way to perform union operations.
    private int count = 0;
    
    public int findCircleNum(int[][] M) {
        // Corner case.
        if (M == null || M.length == 0) {
            return count;
        }
        
        // Initialization: parent array and size array.
        int length = M.length;
        parent = new int[length * length];
        size = new int[length * length];
        for (int i = 0; i < length * length; i++) {
            parent[i] = i;
        }
        count = length;
        
        // Because the friendship matrix is a symmetric matrix, we only need to perform union operations on half of the matrix.
        for (int i = 0; i < length - 1; i++) {
            for (int j = i + 1; j < length; j++) {
                if (M[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        return count;
    }
    
    private int find(int index) {
        while (index != parent[index]) {
            parent[index] = parent[parent[index]];
            index = parent[index];
        }
        return index;
    }
    
    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        
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
}


// Solution 2: DFS.







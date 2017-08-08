/**
 * Question description: Given a binary tree containing digits from 0-9 only, each root-to-leaf 
 *		path could represent a number. Find the total sum of all root-to-leaf numbers.
 * 
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * 
 * Example: 
 *	    1
 *	   / \
 *	  2   3
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: 暂时无.
 */

/**
 * Progress...
 * Create Date: 07/01/2017
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution 1: Depth-first method. Attention the primitive data type could be used to 参数传递。
public class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersHelper(root, 0);
    }
    
    private int sumNumbersHelper(TreeNode node, int element) {
        // base case.
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return element *  10 + node.val;
        }
        
        // recursive case.
        return sumNumbersHelper(node.left, element * 10 + node.val) + 
        			sumNumbersHelper(node.right, element * 10 + node.val);
    }
}

// Solution 2: Depth-first method. (My original method.) 用list存储每条路径代表的数值，以帮助思考。。
public class Solution {
    public int sumNumbers(TreeNode root) {
        List<Integer> resultlist = new ArrayList<>();
        sumNumbersHelper(root, 0, resultlist);
        int sum = 0;
        for (int element : resultlist) {
            sum += element;
        }
        return sum;
    }
    
    private void sumNumbersHelper(TreeNode node, int elementTemp, List<Integer> resultlist) {
        // base case.
        if (node == null) {
            return;
        }
        int element = elementTemp * 10 + node.val;
        if (node.left == null && node.right == null) {
            resultlist.add(element);
        }
        
        // recursive case.
        sumNumbersHelper(node.left, element, resultlist);
        sumNumbersHelper(node.right, element, resultlist);
    }
}



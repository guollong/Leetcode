/**
 * Question description: You need to construct a string consists of parenthesis and 
 *		integers from a binary tree with the preorder traversing way.
 * 
 * 		The null node needs to be represented by empty parenthesis pair "()". And you
 *		need to omit all the empty parenthesis pairs that don't affect the one-to-one 
 *		mapping relationship between the string and the original binary tree.
 * 
 * Example 1: Input: Binary tree: [1,2,3,4]
 *		       1
 *		     /   \
 *		    2     3
 *		   /    
 *		  4     
 * Output: "1(2(4))(3)"
 *
 * Example 2: Input: Binary tree: [1,2,3,null,4]
 *		       1
 *		     /   \
 *		    2     3
 *		     \  
 *		      4 
 * Output: "1(2()(4))(3)"
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Amazon.
 */

/**
 * Progress...
 * Create Date: 06/14/2017
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

// Original method.
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return t.val + "";
        } else if (t.left == null){
            return t.val + "" + "()" + "(" + tree2str(t.right) + ")";
        } else if (t.right == null) {
            return t.val + "" + "(" + tree2str(t.left) + ")";
        }
        return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
    }
}

// Improved method and use stringbuilder.
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        result.append(t.val);
        if (t.left != null || t.right != null) {
            result.append("(");
            result.append(tree2str(t.left));
            result.append(")");
            if (t.right != null) {
                result.append("(");
                result.append(tree2str(t.right));
                result.append(")");
            }
        }
        return result.toString();
    }
}

// Most effective method. Use helper function. 
public class Solution {
    public String tree2str(TreeNode t) {
        StringBuilder sb = new StringBuilder();
        helper(sb,t);
        return sb.toString();
    }
    
    public void helper(StringBuilder sb,TreeNode t){
        if (t != null) {
            sb.append(t.val);
            if (t.left != null || t.right != null) {
                sb.append("(");
                helper(sb, t.left);
                sb.append(")");
                if(t.right != null){
                    sb.append("(");
                    helper(sb, t.right);
                    sb.append(")");
                }
            }
        }
    }
}



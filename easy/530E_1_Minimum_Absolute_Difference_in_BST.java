/**
 * Question description: Given a binary search tree with non-negative values, find the 
 *      minimum absolute difference between values of any two nodes.
 *
 * Example: Input:
 * 1
 *  \
 *   3
 *  /
 * 2
 * Output: 1
 *
 * Note: This is a binary search tree, meaning that it is ordered.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 */

/**
 * Progress...
 * Create Date: 06/01/2017
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

// Approach 1: Recursive method. (most effective method)
// 人家的方法：对于每个node，求Math.min(min,它自己与前一个元素的距离),要得到prev，必须使用中序遍历。
public class Solution {
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) {
            return min;
        }
        getMinimumDifference(root.left);
        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;
        getMinimumDifference(root.right);
        return min;
    }
    
}

// Approach 2: Go over the whole tree and store the values of nodes in a list, take the smallest distance.
//      Since it is a binary search tree, so it is sorted while performing in-order traversal.
public class Solution {
    private List<Integer> list = new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        getElement(root);
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) - list.get(i - 1) < minDistance) {
                minDistance = list.get(i) - list.get(i - 1);
            }
        }
        return minDistance;
    }
    
    private void getElement(TreeNode root) {
        if (root == null) {
            return;
        }
        getElement(root.left);
        list.add(root.val);
        getElement(root.right);
    }
}

// Approach 3: (More general method) 如果该树不是二叉搜索树，即没有顺序，可以用TreeSet来取得比node小的最大node，和比node大的最小node。
public class Solution {
    TreeSet<Integer> set = new TreeSet<>();
    int min = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        
        if (!set.isEmpty()) {
            if (set.floor(root.val) != null) {
                min = Math.min(min, root.val - set.floor(root.val));
            }
            if (set.ceiling(root.val) != null) {
                min = Math.min(min, set.ceiling(root.val) - root.val);
            }
        }
        
        set.add(root.val);
        getMinimumDifference(root.left);
        getMinimumDifference(root.right);
        
        return min;
    }
}












/**
 * Question description: Given the root of a tree, you are asked to find the most frequent subtree sum. 
 * 		The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted 
 * 		at that node (including the node itself). So what is the most frequent subtree sum value? 
 * 		If there is a tie, return all the values with the highest frequency in any order.
 * Examples: 
 * Input:
 *    5
 *  /  \
 * 2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 03/10/2017
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

// 思路：将所有子数的和以及它们出现的频率放在map里。
// map中的getOrDefault函数很巧妙，不用去判断先check key是否存在。
// 计算子数和的时候，采用一层递归即可达到目的。每调用一次递归函数，即是求一个子树的和，对应更新map里的元素。
public class Solution {
    Map<Integer, Integer> sumToCount;
    int maxCount = Integer.MIN_VALUE;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        sumToCount = new HashMap<Integer, Integer>();
        
        postOrder(root);
        
        List<Integer> res = new ArrayList<>();
        for (int key : sumToCount.keySet()) {
            if (sumToCount.get(key) == maxCount) {
                res.add(key);
            }
        }
        
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
    
    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = postOrder(root.left);
        int right = postOrder(root.right);
        
        int sum = left + right + root.val;
        int count = sumToCount.getOrDefault(sum, 0) + 1;
        sumToCount.put(sum, count);
        maxCount = Math.max(maxCount, count);
        
        return sum;
    }
}


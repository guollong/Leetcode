/**
 * Question description: Serialization is the process of converting a data structure or object into a sequence of bits 
 *		so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be 
 *		reconstructed later in the same or another computer environment.
 * 
 * 		Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your 
 *		serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized
 *		to a string and this string can be deserialized to the original tree structure.
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Hard; 
 * Company: Google, Facebook, Microsoft, Amazon, Bloomberg, Uber, LinkedIn, Yahoo.
 */

/**
 * Progress...
 * Create Date: 09/23/2017
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
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "X,";
        }
        
        return root.val + "," + serialize(root.left) + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return buildTree(nodes);
    }
    
    private TreeNode buildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals("X")) {
            return null;
        } else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));




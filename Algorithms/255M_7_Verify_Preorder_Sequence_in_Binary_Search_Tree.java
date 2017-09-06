/**
 * Question description: Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary 
 *		search tree.You may assume each number in the sequence is unique.
 *
 * Follow up: Could you do it using only constant space complexity?
 *
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Medium; 
 * Company: Zenefits.
 */

/**
 * Progress...
 * Create Date: 09/05/2017
 */

// Solution 1: Recursion (divide and conquer).
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length <= 1) {
            return true;
        }
        return verifyPreorderHelper(preorder, 0, preorder.length);
    }
    
    private boolean verifyPreorderHelper(int[] preorder, int start, int end) {
        if (end - start <= 1) {
            return true;
        }
        
        int leftEnd = start + 1;
        // All elements in left subtree are smaller than root.
        while (leftEnd < end && preorder[leftEnd] <= preorder[start]) {
            leftEnd++;
        }
        
        // Check if all elements in right subtree are greater than root.
        int rightStart = leftEnd;
        while (rightStart < end) {
            if (preorder[rightStart] <= preorder[start]) {
                return false;
            }
            rightStart++;
        }
    
        // Check whether the left subtree and right subtree are valid preorder sequence.
        return verifyPreorderHelper(preorder, start + 1, leftEnd) && 
            verifyPreorderHelper(preorder, leftEnd, end);
    }
}

// Solution 2: Using stack. Running time complexity: O(n). Space complexity: O(n)
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // low is the root of the subtree.
        int low = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < preorder.length; i++) {
            // if any elements in the right subtree is smaller than the root, return false.
            if (preorder[i] < low) {
                return false;
            }
            // get the root of the subtree.
            while (!stack.isEmpty() && stack.peek() < preorder[i]) {
                low = stack.pop();
            }
            stack.push(preorder[i]);
        }
        return true;
    }
}

// Solution 3: Using constant space. The same idea with the solution 2.
class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // low is the root of the subtree.
        int low = Integer.MIN_VALUE;
        int i = -1;
        
        for (int element : preorder) {
            // if any elements in the right subtree is smaller than the root, return false.
            if (element < low) {
                return false;
            }
            // get the root of the subtree.
            while (i >= 0 && preorder[i] < element) {
                low = preorder[i--];
            }
            preorder[++i] = element;
        }
        return true;
    }
}







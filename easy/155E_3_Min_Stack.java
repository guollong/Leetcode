/**
 * Question description: Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *		push(x) -- Push element x onto stack.
 *		pop() -- Removes the element on top of the stack.
 *		top() -- Get the top element.
 *		getMin() -- Retrieve the minimum element in the stack.
 * Example: 
 *		MinStack minStack = new MinStack();
 *		minStack.push(-2);
 * 		minStack.push(0);
 *		minStack.push(-3);
 *		minStack.getMin();   --> Returns -3.
 *		minStack.pop();
 *		minStack.top();      --> Returns 0.
 *		minStack.getMin();   --> Returns -2.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Google, Uber, Zenefits, Amazon, Snapchat, Bloomberg.
 */

/**
 * Progress...
 * Create Date: 06/09/2017
 */

// Solution 1: Use stack. store the previous minimum value before the current minimum value.
public class MinStack {
    private int min = Integer.MAX_VALUE;
    private Stack<Integer> minStack;
    /** initialize your data structure here. */
    public MinStack() {
        minStack = new Stack<>();
    }
    
    public void push(int x) {
        if (x <= min) {
            // store the previous minimum value before the current minimum value.
            // So that if the minimum value is poped out, update the min value and pop the new min from stack.
            minStack.push(min);
            min = x;
        }
        minStack.push(x);
    }
    
    public void pop() {
        int temp = minStack.pop();
        // if the value poped is the minimum value, get new minimum value.
        if (temp == min) {
            min = minStack.pop();
        }
    }
    
    public int top() {
        return minStack.peek();
    }
    
    public int getMin() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */


// Solution 2: use User-defined node, store the minimum value in the head's node.
public class MinStack {

    private Node head;

    /** initialize your data structure here. */
    public MinStack() {
        head = null;
    }
    
    public void push(int x) {
        if (head == null) {
            head = new Node(x, x, head);
        } else {
            head = new Node(x, Math.min(x, head.min), head);
        }
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
    
    private class Node {
        int val;
        int min;
        Node next;
        
        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}


/**
 * Question description: Implement the following operations of a queue using stacks.
 * 
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 *
 * Notes: You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
 * 	Depending on your language, stack may not be supported natively. 
 * 	You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
 * 	You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue). 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: .
 * Create Date: 04/05/2017
 * Update date: 06/05/2017
 */


public class MyQueue {
    
    Stack<Integer> queue;

    /** Initialize your data structure here. */
    public MyQueue() {
        queue = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> temp = new Stack<>();
        while (!queue.empty()) {
            temp.push(queue.pop());
        }
        int result = temp.pop();
        while (!temp.empty()) {
            queue.push(temp.pop());
        }
        return result;
    }
    
    /** Get the front element. */
    public int peek() {
        Stack<Integer> temp = new Stack<>();
        while (!queue.empty()) {
            temp.push(queue.pop());
        }
        int result = temp.peek();
        while (!temp.empty()) {
            queue.push(temp.pop());
        }
        return result;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

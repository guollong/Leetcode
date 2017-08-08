/**
 * Question description: Implement the following operations of a stack using queues.
 * 		push(x) -- Push element x onto stack.
 *		pop() -- Removes the element on top of the stack.
 *		top() -- Get the top element.
 *		empty() -- Return whether the stack is empty.
 * 
 * Notes: You must use only standard operations of a queue -- which means only push to back, 
 *		peek/pop from front, size, and is empty operations are valid.
 * 
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; 
 * Company: Bloomberg.
 */

/**
 * Progress...
 * Create Date: 06/15/2017
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

// Solution 1: Only use one queue. Insufficient push method.
public class MyStack {
    private Queue<Integer> myStack;
    
    /** Initialize your data structure here. */
    public MyStack() {
        myStack = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        myStack.offer(x);
        for (int i = 0; i < myStack.size() - 1; i++) {
            myStack.offer(myStack.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return myStack.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return myStack.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myStack.isEmpty();
    }
}

// Solution 2: Use two queues. Insufficient pop and top method.
public class MyStack {
    private Queue<Integer> myStack;
    
    /** Initialize your data structure here. */
    public MyStack() {
        myStack = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        myStack.offer(x);
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        Queue<Integer> temp = new LinkedList<>();
        Integer pre = null;
        Integer curr = myStack.poll();
        while (curr != null) {
            if (pre != null) {
                temp.offer(pre);
            }
            pre = curr;
            curr = myStack.poll();
        }
        while (temp.peek() != null) {
            myStack.add(temp.poll());
        }
        return pre;
    }
    
    /** Get the top element. */
    public int top() {
        Queue<Integer> temp = new LinkedList<>();
        Integer pre = null;
        Integer curr = myStack.poll();
        while (curr != null) {
            temp.offer(curr);
            pre = curr;
            curr = myStack.poll();
        }
        while (temp.peek() != null) {
            myStack.add(temp.poll());
        }
        return pre;
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return myStack.peek() == null;
    }
}





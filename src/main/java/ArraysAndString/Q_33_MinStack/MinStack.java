package ArraysAndString.Q_33_MinStack;

import java.util.Stack;

/**
 Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

 push(x) -- Push element x onto stack.
 pop() -- Removes the element on top of the stack.
 top() -- Get the top element.
 getMin() -- Retrieve the minimum element in the stack.

 Example:
 MinStack minStack = new MinStack();
 minStack.push(-2);
 minStack.push(0);
 minStack.push(-3);
 minStack.getMin();   --> Returns -3.
 minStack.pop();
 minStack.top();      --> Returns 0.
 minStack.getMin();   --> Returns -2.

 Test cases:
 ["MinStack","push","push","push","getMin","top","pop","getMin"]
 [[],[-2],[0],[-1],[],[],[],[]]
 ["MinStack","push","push","push","getMin","pop","getMin"]
 [[],[0],[1],[0],[],[],[]]
 ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
 [[],[2],[0],[3],[0],[],[],[],[],[],[],[]]

 */
public class MinStack {

    Stack<Integer> stack ;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int x) {
        stack.push(x);

        // we need to keep track of min for each element
        // for each element we push to min stack the min element
        // imagine push(0, 1, 0) call getMin
        if(minStack.isEmpty()) {
            minStack.push(x);
        } else if(x < minStack.peek()) {
            minStack.push(x);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

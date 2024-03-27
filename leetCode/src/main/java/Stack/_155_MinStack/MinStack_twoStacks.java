package Stack._155_MinStack;

import java.util.Stack;

class MinStack_twoStacks {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack_twoStacks() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        // when value <= current min value in stack,
        // need to push the value to minstack
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (minStack.peek().equals(stack.peek())) {
            minStack.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

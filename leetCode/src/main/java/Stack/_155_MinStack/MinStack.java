package Stack._155_MinStack;

import java.util.Stack;

class MinStack {
    Stack<Integer> stk;
    Stack<Integer> minStk;

    public MinStack() {
        stk = new Stack<>();
        minStk = new Stack<>();
    }

    public void push(int val) {
        stk.push(val);
        if (!minStk.isEmpty()) {
            val = Math.min(val, minStk.peek());
        }
        minStk.push(val);
    }

    public void pop() {
        stk.pop();
        minStk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return minStk.peek();
    }
}

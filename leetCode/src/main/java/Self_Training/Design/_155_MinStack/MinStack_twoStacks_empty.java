package Self_Training.Design._155_MinStack;

import java.util.Stack;

class MinStack_twoStacks_empty {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack_twoStacks_empty() {

    }

    public void push(int val) {

        // when value <= current min value in stack,
        // need to push the value to minStack

    }

    public void pop() {

    }

    public int top() {
        return -1;
    }

    public int getMin() {
        return -1;
    }
}

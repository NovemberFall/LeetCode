package Design;

import java.util.Stack;

class _232_ImplementQueueUsingStacks {
    Stack<Integer> input;
    Stack<Integer> output;

    public _232_ImplementQueueUsingStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    public void push(int x) {
        input.push(x);
    }

    public int pop() {
        // if out stacks is empty,
        // need to move the elements from in stack to out stack.
        move();
        return output.pop();
    }

    // when output stack is empty, move the elements from input stack to output stack
    private void move() {
        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }
    }

    public int peek() {
        move();
        return output.peek();
    }

    public boolean empty() {
        return input.isEmpty() && output.empty();
    }

    public static void main(String[] args) {
        _232_ImplementQueueUsingStacks myQueue = new _232_ImplementQueueUsingStacks();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(5);
        myQueue.push(16);
        System.out.println(myQueue.peek());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.empty());
    }
}

/**
 * stk1 [ 4, 5
 * stk2 [ 3, 2,
 * queue [ 2, 3,
 */
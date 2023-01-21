package Self_Training.Design._232_ImplementQueueUsingStacks;

import java.util.Stack;

class ImplementQueueUsingStacks_EmptyVersion {
    Stack<Integer> input;
    Stack<Integer> output;

    public ImplementQueueUsingStacks_EmptyVersion() {

    }

    public void push(int x) {

    }

    public int pop() {
        return 0;
    }

    // when output stack is empty, move the elements from input stack to output stack
    private void move() {

    }

    public int peek() {
        return 0;
    }

    public boolean empty() {
        return false;
    }

    public static void main(String[] args) {
        ImplementQueueUsingStacks_EmptyVersion myQueue = new ImplementQueueUsingStacks_EmptyVersion();
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
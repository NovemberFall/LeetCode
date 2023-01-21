package Self_Training.Design._225_ImplementStackUsingQueues;

import java.util.Queue;

/*
Implement a last-in-first-out (LIFO) stack using only two queues. The implemented stack should support
all the functions of a normal stack (push, top, pop, and empty).

Implement the MyStack class:

    - void push(int x) Pushes element x to the top of the stack.
    - int pop() Removes the element on the top of the stack and returns it.
    - int top() Returns the element on the top of the stack.
    - boolean empty() Returns true if the stack is empty, false otherwise.

Notes:
    - You must use only standard operations of a queue, which means that only push to back,
        peek/pop from front, size and is empty operations are valid.
    - Depending on your language, the queue may not be supported natively.
        You may simulate a queue using a list or deque (double-ended queue)
        as long as you use only a queue's standard operations.



Example 1:

    Input
    ["MyStack", "push", "push", "top", "pop", "empty"]
    [[], [1], [2], [], [], []]
    Output
    [null, null, null, 2, 2, false]

    Explanation
    MyStack myStack = new MyStack();
    myStack.push(1);
    myStack.push(2);
    myStack.top(); // return 2
    myStack.pop(); // return 2
    myStack.empty(); // return False
 */
class MyStack_OneQueue_EmptyVersion {
    Queue<Integer> queue;

    public MyStack_OneQueue_EmptyVersion() {

    }

    public void push(int x) {

    }

    public int pop() {

        return 0;
    }

    public int top() {

        return 0;
    }

    public boolean empty() {
        return false;
    }

    public static void main(String[] args) {
        MyStack_OneQueue_EmptyVersion myStack_oneQueue = new MyStack_OneQueue_EmptyVersion();
        myStack_oneQueue.push(1);
        myStack_oneQueue.push(2);
        myStack_oneQueue.push(3);
        myStack_oneQueue.push(4);
        System.out.println(myStack_oneQueue.top());
        System.out.println(myStack_oneQueue.pop());
    }
}

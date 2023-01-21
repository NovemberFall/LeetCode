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
class MyStack_TwoQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack_TwoQueues() {

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
        MyStack_TwoQueues myStack_twoQueues = new MyStack_TwoQueues();
        myStack_twoQueues.push(1);
        myStack_twoQueues.push(2);
        myStack_twoQueues.push(3);
        myStack_twoQueues.push(4);
        System.out.println(myStack_twoQueues.top());
        System.out.println(myStack_twoQueues.pop());
    }
}
/*
    q1 [ 1, 2, 3
    q2 [
 stack [ 1, 2, 3


    q1 [ 3
    q2 [ 1, 2
 stack [ 1, 2, 3
 */
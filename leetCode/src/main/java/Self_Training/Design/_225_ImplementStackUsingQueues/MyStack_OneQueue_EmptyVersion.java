package Self_Training.Design._225_ImplementStackUsingQueues;

import java.util.Queue;

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

package Self_Training.Design._225_ImplementStackUsingQueues;

import java.util.Queue;

class MyStack_TwoQueues_EmptyVersion {
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack_TwoQueues_EmptyVersion() {

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
        MyStack_TwoQueues_EmptyVersion myStack_twoQueues = new MyStack_TwoQueues_EmptyVersion();
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
package ObjectOrientedDesign._225_ImplementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack_TwoQueues {
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack_TwoQueues() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        Integer prev = q1.poll();
        Integer cur = q1.poll();
        while (cur != null) {
            q2.offer(prev);
            prev = cur;
            cur = q1.poll();
        }
        Queue<Integer> tmp = q1;
        q1 = q2;
        q2 = tmp;
        return prev;
    }

    public int top() {
        Integer ret = pop();
        if (ret != null) {
            q1.offer(ret);
        }
        return ret;
    }

    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
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
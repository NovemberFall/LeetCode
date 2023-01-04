package Design._225_ImplementStackUsingQueues;

import java.util.ArrayDeque;
import java.util.Queue;

class MyStack_OneQueue {
    Queue<Integer> queue;
    public MyStack_OneQueue() {
        queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size = queue.size();
        for (int i = size - 1; i >= 1; i--) {
            Integer cur = queue.poll();
            queue.offer(cur);
        }
        return queue.poll();
    }

    public int top() {
        int ret = pop();
        queue.offer(ret);
        return ret;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack_OneQueue myStack_oneQueue = new MyStack_OneQueue();
        myStack_oneQueue.push(1);
        myStack_oneQueue.push(2);
        myStack_oneQueue.push(3);
        myStack_oneQueue.push(4);
        System.out.println(myStack_oneQueue.top());
        System.out.println(myStack_oneQueue.pop());
    }
}

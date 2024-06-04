package Design._716_MaxStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class MaxStack_maxHeap {

    Deque<Integer> dqStack;
    PriorityQueue<Integer> maxHeap;

    /**
     * initialize your data structure here.
     */
    public MaxStack_maxHeap() {
        dqStack = new ArrayDeque<>();

        // Max Heap
        maxHeap = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void push(int x) {
        dqStack.addLast(x);
        maxHeap.offer(x);
    }

    public int pop() {
        int deleteE = dqStack.removeLast();
        maxHeap.remove(deleteE);
        return deleteE;
    }

    public int top() {
        return dqStack.getLast();
    }

    public int peekMax() {
        return maxHeap.peek();
    }

    public int popMax() {
        int deleteE = maxHeap.poll();
        dqStack.removeLastOccurrence(deleteE);
        System.out.println(dqStack);
        return deleteE;
    }

    public static void main(String[] args) {
        MaxStack_maxHeap ms = new MaxStack_maxHeap();
        ms.push(5);
        ms.push(1);
        ms.push(5);
        ms.push(3);
        ms.push(5);
        ms.push(1);
        System.out.println(ms.dqStack);

        ms.popMax();
    }
}

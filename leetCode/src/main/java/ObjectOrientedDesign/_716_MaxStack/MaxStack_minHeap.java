package ObjectOrientedDesign._716_MaxStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

class MaxStack_minHeap {

    Deque<Integer> dqStack;
    PriorityQueue<Integer> pqMax;

    /**
     * initialize your data structure here.
     */
    public MaxStack_minHeap() {
        dqStack = new ArrayDeque<>();

        // Max Heap
        pqMax = new PriorityQueue<>((a, b) -> (b - a));
    }

    public void push(int x) {
        dqStack.addLast(x);
        pqMax.offer(x);
    }

    public int pop() {
        int deleteE = dqStack.removeLast();
        pqMax.remove(deleteE);
        return deleteE;
    }

    public int top() {
        return dqStack.getLast();
    }

    public int peekMax() {
        return pqMax.peek();
    }

    public int popMax() {
        int deleteE = pqMax.poll();
        dqStack.removeLastOccurrence(deleteE);
        System.out.println(dqStack);
        return deleteE;
    }

    public static void main(String[] args) {
        MaxStack_minHeap ms = new MaxStack_minHeap();
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

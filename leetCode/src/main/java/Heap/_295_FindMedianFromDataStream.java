package Heap;

import java.util.PriorityQueue;

class _295_FindMedianFromDataStream {
    private PriorityQueue<Integer> larger;
    private PriorityQueue<Integer> smaller;
    private boolean even = true;

    public _295_FindMedianFromDataStream() {
        larger = new PriorityQueue<>((a, b) -> b - a);
        smaller = new PriorityQueue<>((a, b) -> a - b);
    }

    public void addNum(int num) {
        if (even) {
            larger.offer(num);
            smaller.offer(larger.poll());
        } else {
            smaller.offer(num);
            larger.offer(smaller.poll());
        }
        even = !even;
    }

    public double findMedian() {
        if (even) {
            return (smaller.peek() + larger.peek()) / 2.0;
        } else {
            return smaller.peek();
        }
    }
}

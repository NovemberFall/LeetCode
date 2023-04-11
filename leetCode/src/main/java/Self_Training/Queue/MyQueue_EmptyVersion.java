package Self_Training.Queue;

import Self_Training.ListNode;
import org.junit.jupiter.api.Test;

/*
    Implementation of Queue By LinkedList
    因为queue 是一头进，一头出，所以需要 head, tail
 */
class MyQueue_EmptyVersion {
    ListNode head;
    ListNode tail;

    public MyQueue_EmptyVersion() {

    }

    public Integer poll() {

        return 0;
    }

    public Integer peek() {
        return null;
    }

    public void offer(Integer e) {

    }

    @Test
    void testOffer() {
        MyQueue_EmptyVersion queue = new MyQueue_EmptyVersion();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        queue.offer(9);
        System.out.println(queue.peek());// 1
    }

    @Test
    void testPoll() {
        MyQueue_EmptyVersion queue = new MyQueue_EmptyVersion();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        queue.offer(9);
        int poll = queue.poll();
        System.out.println(poll);// 1
    }
}

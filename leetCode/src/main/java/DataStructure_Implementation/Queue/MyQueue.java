package DataStructure_Implementation.Queue;

import org.junit.jupiter.api.Test;

/*
    因为queue 是一头进，一头出，所以需要 head, tail
 */
class MyQueue {
    ListNode head;
    ListNode tail;

    public MyQueue() {
        head = tail = null;
    }

    public Integer poll() {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        node.next = null;
        return node.val;
    }

    public Integer peek() {
        if (head == null) {
            return null;
        }
        return  head.val;
    }

    public void offer(Integer e) {
        if (head == null) {
            head = new ListNode(e);
            tail = head;
        } else {
            tail.next = new ListNode(e);
            tail = tail.next;
        }
    }

    @Test
    void testOffer() {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        queue.offer(9);
        System.out.println(queue.peek());// 1
    }

    @Test
    void testPoll() {
        MyQueue queue = new MyQueue();
        queue.offer(1);
        queue.offer(3);
        queue.offer(5);
        queue.offer(7);
        queue.offer(9);
        int poll = queue.poll();
        System.out.println(poll);// 1
    }
}

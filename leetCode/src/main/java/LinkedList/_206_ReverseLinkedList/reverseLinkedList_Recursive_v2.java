package LinkedList._206_ReverseLinkedList;

class reverseLinkedList_Recursive_v2 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        ListNode newHead = reverseList(head.next);
        ListNode tail = newHead;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;
        head.next = null;
        return newHead;
    }
}

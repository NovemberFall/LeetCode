package LinkedList._876_MiddleOfLinkedList;

class MiddleOfLinkedList_BruteForce {
    public ListNode middleNode(ListNode head) {
        if (head == null) {
            return head;
        }
        int len = 0;
        ListNode count = head;
        while (count != null) {
            len++;
            count = count.next;
        }

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        if (len % 2 == 0) {
            return slow.next;
        } else {
            return slow;
        }
        // return (len % 2 == 0) ? slow.next : slow;
    }
}

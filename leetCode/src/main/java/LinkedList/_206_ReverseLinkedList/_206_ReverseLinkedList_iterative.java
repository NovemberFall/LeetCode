package LinkedList._206_ReverseLinkedList;

class _206_ReverseLinkedList_iterative {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode next = null;
        ListNode cur = head;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        _206_ReverseLinkedList_iterative test = new _206_ReverseLinkedList_iterative();
        ListNode L1 = new ListNode(3);
        ListNode L2 = new ListNode(5);
        ListNode L3 = new ListNode(7);
        L1.next = L2;
        L2.next = L3;
        ListNode dummy = L1;
        while (dummy != null) {
            System.out.print(dummy.val + " ");
            dummy = dummy.next;
        }

        System.out.println("\n==========Reverse==========");

        ListNode head = test.reverseList(L1);
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}

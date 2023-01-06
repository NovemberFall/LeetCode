package LinkedList;

class _2_AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int count = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                count += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                count += l2.val;
                l2 = l2.next;
            }
            cur.next = new ListNode(count % 10);
            count /= 10;
            cur = cur.next;
        }
        if (count != 0) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}

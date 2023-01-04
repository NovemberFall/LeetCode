package LinkedList;

class _143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode midNode = findMidNode(head);
        ListNode secondHead = midNode.next;
        midNode.next = null;

        ListNode reversedSecond = reverse(secondHead);
        head = merge(head, reversedSecond);
    }

    private ListNode merge(ListNode one, ListNode two) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (one != null && two != null) {
            cur.next = one;
            one = one.next;
            cur.next.next = two;
            two = two.next;
            cur = cur.next.next;
        }

        if (one != null) {
            cur.next = one;
        } else {
            cur.next = two;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode secondHead) {
        ListNode cur = secondHead;
        ListNode prev = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    private ListNode findMidNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

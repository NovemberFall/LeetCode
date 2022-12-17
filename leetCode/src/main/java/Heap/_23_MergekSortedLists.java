package Heap;

import java.util.PriorityQueue;

class _23_MergekSortedLists {
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
                (a, b) -> (a.val - b.val));
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            cur.next = min;
            cur = cur.next;
            if (min.next != null) {
                minHeap.offer(min.next);
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[3];
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);

        ListNode head3 = new ListNode(2);
        head3.next = new ListNode(6);

        lists[0] = head1;
        lists[1] = head2;
        lists[2] = head3;

        _23_MergekSortedLists mergekSortedLists = new _23_MergekSortedLists();
        ListNode dummy = mergekSortedLists.mergeKLists(lists);
        while (dummy != null) {
            System.out.print(dummy.val + " -> ");
            dummy = dummy.next;
        }
    }
}

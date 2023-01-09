package LinkedList;

public class _92_ReverseLinkedList_II {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(9527);
        dummy.next = head;
        ListNode cur = head;
        int count = 1;
        while (count < left) {
            cur = cur.next;
            count++;
        }
        head.next = null;

    }
}

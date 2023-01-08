package LinkedList;

class _86_PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode smaller = new ListNode(9527);
        ListNode larger = new ListNode(9528);
        ListNode curSmaller = smaller;
        ListNode curLarger = larger;
        while (head != null) {
            if (head.val < x) {
                curSmaller.next = head;
                curSmaller = curSmaller.next;
            } else {
                curLarger.next = head;
                curLarger = curLarger.next;
            }
            head = head.next;
        }
        curSmaller.next = larger.next;
        curLarger.next = null;
        return smaller.next;
    }
}

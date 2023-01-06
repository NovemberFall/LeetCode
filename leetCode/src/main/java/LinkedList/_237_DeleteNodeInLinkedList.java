package LinkedList;

class _237_DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        ListNode oldNext = node;
        node.val = node.next.val;
        node.next = node.next.next;
        oldNext = null;
    }
}

package TwoPointers;

class _21_MergeTwoSortedLists {
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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = new ListNode(list1.val);
                list1 = list1.next;
                cur = cur.next;
            } else {
                cur.next = new ListNode(list2.val);
                list2 = list2.next;
                cur = cur.next;
            }
        }
        //link the remaining possible nodes
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        _21_MergeTwoSortedLists mergeTwoSortedLists = new _21_MergeTwoSortedLists();
        ListNode res = mergeTwoSortedLists.mergeTwoLists(list1, list2);

        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}

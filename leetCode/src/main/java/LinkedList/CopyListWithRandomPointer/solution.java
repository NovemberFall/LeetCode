package LinkedList.CopyListWithRandomPointer;

import java.util.HashMap;
import java.util.Map;

class solution {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node dummy = new Node(9527);
        Node cur = dummy;
        Map<Node, Node> map = new HashMap<>();
        while(head != null){
            //fist, copy Node
            if(head != null){
                if(!map.containsKey(head)){
                    map.put(head, new Node(head.val));
                }
                cur.next = map.get(head);
            }
            //second, copy Node.random
            if(head.random != null){
                if(!map.containsKey(head.random)){
                    map.put(head.random, new Node(head.random.val));
                }
                cur.next.random = map.get(head.random);
            }
            head = head.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}

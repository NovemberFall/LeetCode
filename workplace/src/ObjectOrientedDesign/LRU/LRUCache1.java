package ObjectOrientedDesign.LRU;

import java.util.HashMap;

public class LRUCache1 {
    static class Node {
        Node next;
        Node previous;
        int key;
        int value;

        //current node hold key and val
        Node(int key, int val) {
            this.key = key;
            this.value = val;
        }

        // update my node's value
        void update(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    //HashMap contain such every a element that contains:
    //<key, Node>, Node => <Node.key, value>
    protected HashMap<Integer, Node> map;

    // maintain all the time that the head and tail of
    //current doubly LinkedList
    private Node head;
    private Node tail;

    public LRUCache1(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        //Even though we just read from linkedList,
        //but we still need to move node to the head
        remove(node);
        appendToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = null;
        //1. if the key already in the cache,
        //we need to update its value
        //and move it to head (most recently used position)
        if (map.containsKey(key)) {
            node = map.get(key);
            node.value = value;
            remove(node);
            appendToHead(node);
        } else if (map.size() < capacity) {
            //2. if the key is not in the cache,
            //assume we have enough space
            // we just need to add new node into the head
            node = new Node(key, value);
            appendToHead(node);
        } else {
            //3. if the key is not in the cache,
            // even we don't have enough space
            // we need to evict the tail
            // move the new node<Node.key, value> into the head
            node = tail;
            //node references to tail reference to
            remove(tail);
            //after remove node, node.prev = null && node.next = null
            node.update(key, value);
            appendToHead(node);
        }
    }

    private void appendToHead(Node node) {
        map.put(node.key, node);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.previous = node;
            head = node;
        }
    }

    /**
     * there are 4 cases for doubly linkedList
     * to maintain its order
     * @param node the current node that
     *  we need to remove from double LinkedList
     */
    private void remove(Node node) {
        map.remove(node.key);
        if (node.previous != null) {
            node.previous.next = node.next;
        }
        if (node.next != null) {
            node.next.previous = node.previous;
        }
        if (node == head) {
            head = head.next;
        }
        if (node == tail) {
            tail = tail.previous;
        }
        node.previous = null;
        node.next = null;
    }

    public static void main(String[] args) {
        LRUCache1 lRUCache = new LRUCache1(5);
        lRUCache.put(1, 1);
        lRUCache.put(2, 2);
        int temp = lRUCache.get(1);
        System.out.println("Should return 1 => " + temp);
        // return 1
        lRUCache.put(3, 3);
        lRUCache.put(4, 4);
        lRUCache.put(5, 5);
        lRUCache.put(6, 6);
        // evicts key 2, cache is {1=1, 3=3, 4=4, 5=5, 6=6}

        lRUCache.map.forEach(
                (key, node) -> System.out.println(key + " => " + node.value)
        );

        temp = lRUCache.get(2);
        System.out.println("Should return -1 => " + temp);

        lRUCache.put(7, 7);
        // evicts key 1, cache is {3=3, 4=4, 5=5, 6=6, 7=7}
        lRUCache.map.forEach(
                (key, node) -> System.out.println(key + " => " + node.value)
        );

        temp = lRUCache.get(3);
        System.out.println("Should return 3 => " + temp);  // return 3
        temp = lRUCache.get(4);
        System.out.println("Should return 4 => " + temp);  // return 4
    }
}

package Self_Training.Design._146_LRU;

import java.util.HashMap;

class LRUCache_EmptyVersion {
    static class Node {

    }

    private final int capacity;
    //HashMap contain such every a element that contains:
    //<key, Node>, Node => <Node.key, value>
    protected HashMap<Integer, Node> map;

    // maintain all the time that the head and tail of
    //current doubly LinkedList
    private Node head;
    private Node tail;

    public LRUCache_EmptyVersion(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {

        return 0;
    }

    public void put(int key, int value) {

    }

    private void appendToHead(Node node) {

    }

    /**
     * there are 4 cases for doubly linkedList
     * to maintain its order
     * @param node the current node that
     *  we need to remove from double LinkedList
     */
    private void remove(Node node) {

    }

    public static void main(String[] args) {
//        LRUCache_EmptyVersion lRUCache = new LRUCache_EmptyVersion(5);
//        lRUCache.put(1, 1);
//        lRUCache.put(2, 2);
//        int temp = lRUCache.get(1);
//        System.out.println("Should return 1 => " + temp);
//        // return 1
//        lRUCache.put(3, 3);
//        lRUCache.put(4, 4);
//        lRUCache.put(5, 5);
//        lRUCache.put(6, 6);
//        // evicts key 2, cache is {1=1, 3=3, 4=4, 5=5, 6=6}
//
//        lRUCache.map.forEach(
//                (key, node) -> System.out.println(key + " => " + node.value)
//        );
//
//        temp = lRUCache.get(2);
//        System.out.println("Should return -1 => " + temp);
//
//        lRUCache.put(7, 7);
//        // evicts key 1, cache is {3=3, 4=4, 5=5, 6=6, 7=7}
//        lRUCache.map.forEach(
//                (key, node) -> System.out.println(key + " => " + node.value)
//        );
//
//        temp = lRUCache.get(3);
//        System.out.println("Should return 3 => " + temp);  // return 3
//        temp = lRUCache.get(4);
//        System.out.println("Should return 4 => " + temp);  // return 4
    }
}

package Self_Training.Design._146_LRU;

import java.util.HashMap;

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

- LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
- int get(int key) Return the value of the key if the key exists, otherwise return -1.
- void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache.
  If the number of keys exceeds the capacity from this operation, evict the least recently used key.

The functions get and put must each run in O(1) average time complexity.



Example 1:

    Input
    ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
    [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
    Output
    [null, null, null, 1, null, -1, null, -1, 3, 4]

    Explanation
    LRUCache lRUCache = new LRUCache(2);
    lRUCache.put(1, 1); // cache is {1=1}
    lRUCache.put(2, 2); // cache is {1=1, 2=2}
    lRUCache.get(1);    // return 1
    lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
    lRUCache.get(2);    // returns -1 (not found)
    lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
    lRUCache.get(1);    // return -1 (not found)
    lRUCache.get(3);    // return 3
    lRUCache.get(4);    // return 4
 */
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
        map = new HashMap<>();
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

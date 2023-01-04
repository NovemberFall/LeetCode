package Design._146_LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class LRUCache_TreeSet {
    private static class Element implements Comparable<Element> {
        int id;
        int key;
        int value;

        public Element(int id, int key, int value) {
            this.id = id;
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Element e) {
            return Integer.compare(this.id, e.id);
        }

        @Override
        public String toString() {
            return "\nElement: " + "id: " + this.id + " " + "key: " + this.key + " " + "val: " + this.value;
        }
    }

    private final int CAPACITY;
    private Map<Integer, Element> map;
    private TreeSet<Element> treeSet;
    private int id;

    public LRUCache_TreeSet(int capacity) {
        // if (capacity <= 0) throw IllegalArgumentException
        this.CAPACITY = capacity;
        map = new HashMap<>();
        treeSet = new TreeSet<>();
        id = 0; // Integer.MIN_VALUE for a greater range of id's
    }

    public int get(int key) {
        Element currentElement = map.get(key);
        if (currentElement == null) {
            return -1;
        }
        treeSet.remove(currentElement);
        currentElement.id = id++;
        treeSet.add(currentElement);
        return currentElement.value;
    }

    public void put(int key, int value) {
        Element oldElement = map.get(key);
        if (oldElement != null) {
            map.remove(key);
            treeSet.remove(oldElement);
        }
        Element currentElement = new Element(id++, key, value);
        map.put(key, currentElement);
        treeSet.add(currentElement);
        if (treeSet.size() > CAPACITY) {
            oldElement = treeSet.first();
            treeSet.remove(oldElement);
            map.remove(oldElement.key);
        }
    }

    public static void main(String[] args) {
        LRUCache_TreeSet lRUCache = new LRUCache_TreeSet(2);
        lRUCache.put(1, 1); // cache is {1=1}
        System.out.println(lRUCache.treeSet + "\n");


        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.treeSet + "\n");

        System.out.println(lRUCache.get(1) + "\n");
        ;    // return 1

        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.treeSet + "\n");

        System.out.println(lRUCache.get(2) + "\n");    // returns -1 (not found)


        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.treeSet + "\n");

        System.out.println(lRUCache.get(1) + "\n");     // return -1 (not found)

        System.out.println(lRUCache.get(3));    // return 3

        System.out.println(lRUCache.get(4));    // return 4
    }
}



























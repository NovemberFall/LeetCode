package DataStructure_Implementation.HashMap.ConcurrencyHashMap;

import java.util.Arrays;

class SynchronizedHashMay<K, V> {
    //Node is a static class of MyHashMap, since it is:
    //very closely bonded to MyHashMap class.
    //We probably need to access this class outside from MyHashMap class.
    public static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    //static final variable are global constants
    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size; //how many key-value pairs are actually stored
    //in the HashMap.
    private float loadFactor; //determine when to rehash.


    public SynchronizedHashMay() {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public SynchronizedHashMay(int cap, float loadFactor) {
        if (cap <= 0) {
            throw new IllegalArgumentException("Capacity can not be <= 0");
        }
        this.array = (Node<K, V>[]) (new Node[cap]);
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public synchronized int size() {
        return size;
    }

    public synchronized boolean isEmpty() {
        return size == 0;
    }

    public synchronized void clear() {
        Arrays.fill(this.array, null);
        size = 0;
    }

    //private method, and put() will invoke this method, don't need sync
    private int hash(K key) {//non-negative
        //1. null key
        if (key == null) {
            return 0;
        }
        //int code = key.hashCode();
        //return code >= 0 ? code : -code;
        //int range = [-2^31, 2^31-1]
        // -Integer.MIN_VALUE = Integer.MIN_VALUE;  -> overflow
        return key.hashCode() & 0X7FFFFFFF;  //guarantee non-negative
        //01111111 11111111 11111111 11111111
        //Reason: Java's % return remainder rather than modulus.
        //The remainder can be integer
    }


    private int getIndex(K key) {
        return hash(key) % array.length;
    }

    private boolean equalsValue(V v1, V v2) {
        //v1, v2 all possibly to be null
        if (v1 == null && v2 == null) {
            return true;
        }
        if (v1 == null || v2 == null) {
            return false;
        }
        return v1.equals(v2);
    }

    //O(n), traverse the whole array, and traverse each of
    //the linked list in the array.
    public boolean containsValue(V value) {
        //special case.
        if (isEmpty()) {
            return false;
        }
        for (Node<K, V> node : array) {
            while (node != null) {
                //check if the value equals()
                //value, node.getValue() all possible to be null
                if (equalsValue(node.value, value)) {
                    return true;
                }
                node = node.next;
            }
        }
        return false;
    }


    private boolean equalsKey(K k1, K k2) {
        //k1, k2 all possibly to be null
        if (k1 == null && k2 == null) {
            return true;
        }
        if (k1 == null || k2 == null) {
            return false;
        }
        return k1.equals(k2);
    }

    //Generally O(1), but if we're using a bad hashCode function,
    // we need to add multiple elements to one bucket so it can be O(n)
    // in worst case.
    public synchronized boolean containsKey(K key) {
        //get the index of the key
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            //check if the key equals()
            //key, node.key() all possible to be null
            if (equalsKey(node.key, key)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    //if key doesn't exist in the HashMap, return null
    public synchronized V get(K key) {
        int index = getIndex(key);
        Node<K, V> node = array[index];
        while (node != null) {
            //check if the key equals()
            //key, node.key() all possible to be null
            if (equalsKey(node.key, key)) {
                return node.value;
            }
            node = node.next;
        }
        return null;
    }

    //inset/update
    //if the key already exists, return the old corresponding value.
    //if the key not exists, return null
    public synchronized V put(K key, V value) {
        int index = getIndex(key);
        Node<K, V> head = array[index];
        Node<K, V> node = head;
        while (node != null) {
            //check if the key equals()
            //key, node.key() all possible to be null
            if (equalsKey(node.key, key)) {
                V result = node.value;
                node.value = value;
                return result;
            }
            node = node.next;
        }
        //append the new node before the head and update the new head
        //insert operation
        Node<K, V> newNode = new Node<>(key, value);
        newNode.next = head;
        array[index] = newNode; //new head is here.
        size++;
        if (needRehashing()) {
            rehashing();
        }
        return null;
    }

    private boolean needRehashing() {
        //float loadFactor;
        float ratio = (size + 0.0f) / array.length;
        return ratio >= loadFactor;
    }


    private void rehashing() {
        //new double sized array.
        //for each node in the old array,
        //put (add to head of linked list) to the new larger array.
        Node<K, V>[] oldArray = array;
        array = (Node<K, V>[]) (new Node[array.length * 2]);
        for (Node<K, V> curr : oldArray) {
            while (curr != null) {
                Node<K, V> next = curr.next;
                int newIndex = getIndex(curr.key);
                curr.next = array[newIndex];
                array[newIndex] = curr;
                curr = next;
            }
        }
    }

    public synchronized V remove(K key) {
        //get index
        //delete operation on the linked list
        //size--
        int index = getIndex(key);
        Node<K, V> node = array[index];
        Node<K, V> pre = null;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                if (pre != null) {
                    pre.next = node.next;
                } else {
                    array[index] = node.next;
                }
                size--;
                return node.value;
            }
            pre = node;
            node = node.next;
        }
        return null;
    }
}


package Self_Training.HashMap;

class MyHashMap<K, V> {

    // Node is a static class of MyHashMap, since it is: very closely bonded to MyHashMap class.
    // we probably need to access this class outside from MyHashMap class.
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

    // static final variable are global constants
    private static final int DEFAULT_CAPACITY = 16;
    /*
       The default load factor of HashMap used in java, for instance, is 0.75f (75% of the map size).
       That means if we have a HashTable with an array size of 100, then whenever we have 75 elements stored,
       we will increase the size of the array to double of its previous size i.e. to 200 now, in this case.
    */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    private Node<K, V>[] array;
    private int size; // how many key-value pairs are actually stored int the HashMap
    private float loadFactor; // determine when to rehash
    private final int SCALE_FACTOR = 2;

    public MyHashMap() {

    }

    public MyHashMap(int capacity, float loadFactor) {

        // 为什么这里要cast? 因为java 默认无法 new 一个 generic array, 所以必须要 cast

    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public void clear() {

    }

    // non-negative
    private int hash(K key) {
        // 1. null key


        return 0; // guarantee non-negative
        // 01111111 11111111 11111111 11111111
        // Reason: Java's % return remainder rather than modulus. The remainder can be negative
        /*
        * @link https://stackoverflow.com/questions/49592995/i-dont-understand-what-is-0x7fffffff-mean-is-there-any-other-way-to-code-gethas
}       */

        // OR:
        // return key.hashCode() >>> 1 ;   // however this is slower.
    }

    private int getIndex(K key) {
        return 0;
    }

    private boolean equalsValue(V v1, V v2) {
        return false;
    }

    // O(n), traverse the whole array, and traverse each of the linked list in the array
    public boolean containsValue(V value) {
        // special case


        return false;
    }

    private boolean equalsKey(K k1, K k2) {
        return false;
    }

    public boolean containsKey(K key) {

        return false;
    }

    // if key does not exist in the HashMap, return null
    public V get(K key) {

        return null;
    }

    // insert/update
    // if the key already exists, return the old corresponding value.
    // if the key not exists, return null
    public V put(K key, V value) {

        return null;
    }

    private boolean needRehashing() {
        // float loadFactor;
        return false;
    }


    // 如果这段不能理解的话：
    // @link https://learning.laioffer.com/app/discussion/932
    private void rehashing() {
        // new double sized array
        // for each node in the old array,
        // put (add to head of linked list) to the new larger array


        /*  要rehash old list.
            拿出当前node，保存他的next。
            获得当前node的new index
            把当前node插到new index那边的第一位。
            用之前保存的next，继续rehash。
        */
    }

    /*
        N1 -> N2 -> N3         # assume delete N2
        N1 -> N3
    */
    public V remove(K key) {
        // get index
        // delete operation on the linked list.
        // size--


        return null;
    }

    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("google", 1);
        map.put("yahoo", 2);
        map.put("apple", 3);
        map.put("IBM", 15);
        map.put("Amazon", 22);
        map.put("Meta", 16);
        System.out.println(map.get("google")); // 1
        System.out.println(map.containsKey("google")); // true
        System.out.println(map.containsValue(15)); // true
        System.out.println(map.containsValue(17)); // false
        System.out.println(map.get("IBM")); // 15
        System.out.println(map.equalsKey("IBM", "IBM")); // true
        System.out.println(map.size()); // 6
        System.out.println(map.remove("google")); // 1
        System.out.println(map.size()); // 5
    }
}

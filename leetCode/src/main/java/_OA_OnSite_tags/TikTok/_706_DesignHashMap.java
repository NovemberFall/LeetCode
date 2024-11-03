package _OA_OnSite_tags.TikTok;

class _706_DesignHashMap {
    class Node {
        int key;
        int val;
        Node next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
    private Node[] array;

    public _706_DesignHashMap() {
        this.array = new Node[10_000];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        Node head = array[index];
        Node node = head;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        // append the new node before the head and update the new head && insert operation
        Node newNode = new Node(key, value);
        newNode.next = array[index];
        array[index] = newNode;
    }

    private boolean equalsKey(int k1, int k2) {
        return k1 == k2;
    }

    private int getIndex(int key) {
        return Integer.hashCode(key) % array.length;
    }

    public int get(int key) {
        int index = getIndex(key);
        Node node = array[index];
        while (node != null) {
            if (equalsKey(node.key, key)) {
                return node.val;
            }
            node = node.next;
        }
        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        Node node = array[index];
        Node prev = null;
        while (node != null) {
            if (equalsKey(node.key, key)) {
                if (prev == null) {
                    // If Head is the removed node, prev is Still null
                    array[index] = node.next;
                }
                if (prev != null) {
                    // if Head is not the removed node delete current node, and connect prev to next node.
                    prev.next = node.next;
                }
            }
            prev = node;
            node = node.next;
        }
    }

    public static void main(String[] args) {
        _706_DesignHashMap myHashMap = new _706_DesignHashMap();
        myHashMap.put(1, 1);
        myHashMap.put(2, 2);
        System.out.println(myHashMap.get(1));
        System.out.println(myHashMap.get(3));
        myHashMap.put(2, 1);
        System.out.println(myHashMap.get(2));
        myHashMap.remove(2);
        System.out.println(myHashMap.get(2));
    }
}




























package DataStructure_Implementation.Set;

import java.util.HashMap;

class MyHashSet<T>  {
    private HashMap<T, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public boolean add(T element) {
        return map.put(element, PRESENT) == null;
    }

    public boolean contains(T element) {
        return map.containsKey(element);
    }

    public boolean remove(T element) {
        return map.remove(element) == PRESENT;
    }

    public void clear() {
        map.clear();
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}

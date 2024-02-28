package DataStructure_Implementation.Set;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;


public class MyHashSet<T> {
    private static final int INITIAL_CAPACITY = 16;
    private List<T>[] buckets;
    private int size;

    public MyHashSet() {
        buckets = new ArrayList[INITIAL_CAPACITY];
        for (int i = 0; i < INITIAL_CAPACITY; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public boolean add(T element) {
        int index = Math.abs(element.hashCode()) % INITIAL_CAPACITY;
        if (!buckets[index].contains(element)) {
            buckets[index].add(element);
            size++;
            return true;
        }
        return false;
    }

    public boolean remove(T element) {
        int index = Math.abs(element.hashCode()) % INITIAL_CAPACITY;
        if (buckets[index].remove(element)) {
            size--;
            return true;
        }
        return false;
    }

    public boolean contains(T element) {
        int index = Math.abs(element.hashCode()) % INITIAL_CAPACITY;
        return buckets[index].contains(element);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}

class TestMyHashSet {
    @Test
    public void testAdd() {
        MyHashSet<Integer> set = new MyHashSet<>();
        assertTrue(set.add(5));
        assertTrue(set.add(10));
        assertFalse(set.add(5)); // Adding duplicate element should return false
    }

    @Test
    public void testRemove() {
        MyHashSet<Character> set = new MyHashSet<>();
        set.add('a');
        set.add('b');
        assertTrue(set.remove('a'));
        assertFalse(set.remove('a')); // Removing non-existing element should return false
    }

    @Test
    public void testContains() {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("apple");
        set.add("banana");
        assertTrue(set.contains("apple"));
        assertFalse(set.contains("orange"));
    }

    @Test
    public void testSize() {
        MyHashSet<Integer> set = new MyHashSet<>();
        assertEquals(0, set.size());
        set.add(1);
        set.add(2);
        assertEquals(2, set.size());
    }

    @Test
    public void testIsEmpty() {
        MyHashSet<Double> set = new MyHashSet<>();
        assertTrue(set.isEmpty());
        set.add(3.14);
        assertFalse(set.isEmpty());
    }
}


package DataStructure_Implementation.Set;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MyHashSet {
    private static class MySet<E> {
        private final List<E> list;

        private MySet() {
            this.list = new ArrayList<>();
        }

        public void add(E element) {
            list.add(element);
        }

        public boolean remove(E element) {
            return list.remove(element);
        }

        public int size() {
            return list.size();
        }

        public boolean contains(E element) {
            return list.contains(element);
        }
    }

    @Test
    void testAdd() {
        MySet<String> set = new MySet<>();
        set.add("foo");
        set.add("bar");
        set.add("hello");
        assertEquals(3, set.size());
        assertTrue(set.contains("foo"));
        assertTrue(set.contains("bar"));
        assertTrue(set.contains("hello"));
    }

    @Test
    void testRemove() {
        MySet<Integer> set = new MySet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        assertTrue(set.remove(10));
        assertFalse(set.remove(12));
        assertEquals(2, set.size());
        assertFalse(set.contains(30));
        assertTrue(set.contains(20));
        assertTrue(set.contains(10));
    }

    @Test
    void testContians() {
        MySet<Character> set = new MySet<>();
        set.add('a');
        set.add('b');
        set.add('c');
        assertTrue(set.contains('a'));
        assertTrue(set.contains('b'));
        assertFalse(set.contains('h'));
    }
}


















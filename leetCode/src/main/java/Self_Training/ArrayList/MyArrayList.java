package Self_Training.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class MyArrayList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int Load_Factor = 2;
    private Object elements[];

    public MyArrayList() {

    }

    public void add(E e) {

    }

    private void ensureCapacity() {

    }


    @SuppressWarnings("unchecked")
    public E get(int i) {
        return null;
    }









    @Test
    public void testMyList() {
        MyArrayList<Integer> list = new MyArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        list.add(4);
        assertTrue(4 == list.get(4));
        assertTrue(2 == list.get(1));
        assertTrue(3 == list.get(2));

//        list.get(6);
    }
}

package phone_OA_OnSite.google.Merge_K_Sorted_Iterators;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

class MergingIterator implements Iterator<Integer> {
    private final PriorityQueue<PeekingIterator> priorityQueue;

    public MergingIterator(List<Iterator<Integer>> iterators) {
        priorityQueue = new PriorityQueue<>(iterators.size(),
                (e1, e2) -> (e1.peek() - e2.peek()));

        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                priorityQueue.offer(new PeekingIterator(iterator));
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !priorityQueue.isEmpty();
    }

    @Override
    public Integer next() {
        PeekingIterator nextIter = priorityQueue.poll();
        Integer next = nextIter.next();
        if (nextIter.hasNext()) {
            priorityQueue.offer(nextIter);
        }
        return next;
    }

    public static void main(String[] args) {
        Iterator<Integer> it1 = Arrays.asList(2, 5, 9).iterator();
        Iterator<Integer> it2 = Collections.emptyIterator();
        Iterator<Integer> it3 = Arrays.asList(4, 10).iterator();
        MergingIterator mergingIterator = new MergingIterator(Arrays.asList(it1, it2, it3));

//        while (mergingIterator.hasNext()) {
//            System.out.println(mergingIterator.next());
//        }
        System.out.println(mergingIterator.hasNext());
        System.out.println(mergingIterator.next());
        System.out.println(mergingIterator.next());
        System.out.println(mergingIterator.next());
        System.out.println(mergingIterator.next());
        System.out.println(mergingIterator.next());
        System.out.println(mergingIterator.hasNext());
        System.out.println(mergingIterator.next());

    }
}

// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    Iterator<Integer> iterator;
    boolean hasPeeked;
    Integer peekedElement;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if (!hasPeeked) {
            peekedElement = iterator.next();
        }
        hasPeeked = true;
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        if (!hasPeeked) {
            return iterator.next();
        }
        Integer res = peekedElement;
        hasPeeked = false;
        peekedElement = null;
        return res;
    }

    @Override
    public boolean hasNext() {
        return hasPeeked || iterator.hasNext();
    }
}
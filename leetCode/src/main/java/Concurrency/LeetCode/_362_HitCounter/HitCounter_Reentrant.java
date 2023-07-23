package Concurrency.LeetCode._362_HitCounter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * https://leetcode.com/problems/design-hit-counter/discuss/83483/Super-easy-design-O(1)-hit()-O(s)-getHits()-no-fancy-data-structure-is-needed!#:~:text=I%20think%20AtomicIntegerArray%20won%27t%20solve%20the%20issue%20as%20other%20points%20out%2C%20here%20is%20a%20ReentrantReadWriteLock%20solution.%20The%20advantage%20of%20ReentrantReadWriteLock%20over%20Synchonized%20keyword%20is%20multiple%20getHits(t)%20(read%20operation)%20won%27t%20block%20each%20other%2C%20hence%20increase%20the%20performance.
 */
class HitCounter_Reentrant {
    private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private final Lock r = rwl.readLock();
    private final Lock w = rwl.writeLock();

    // store each last get hit timestamp with that bucket
    int[] times;
    // store the number of hit for that bucket
    int[] hits;

    /**
     * Initialize your data structure here.
     */
    public HitCounter_Reentrant() {
        hits = new int[300];
        times = new int[300];
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        w.lock();
        try {
            int idx = timestamp % 300;
            if (times[idx] != timestamp) {
                // not in the same 5 minute window
                times[idx] = timestamp;
                hits[idx] = 1;
            } else {
                hits[idx]++;
            }

        } finally {
            w.unlock();
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int sum = 0;
        r.lock();
        try {
            for (int i = 0; i < 300; i++) {
                if (timestamp - times[i] < 300) sum += hits[i];
            }
        } finally {
            r.unlock();
        }
        return sum;
    }
}

/*
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */

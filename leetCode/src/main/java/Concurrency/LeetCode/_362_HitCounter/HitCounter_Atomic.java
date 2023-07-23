package Concurrency.LeetCode._362_HitCounter;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * https://leetcode.com/problems/design-hit-counter/discuss/83483/Super-easy-design-O(1)-hit()-O(s)-getHits()-no-fancy-data-structure-is-needed!#:~:text=Hi%20%40xuyirui%20%2C%20thanks,the%20wrong%20direction.
 *
 */
class HitCounter_Atomic {
    private AtomicIntegerArray time;
    private AtomicIntegerArray hit;

    /**
     * Initialize your data structure here.
     */
    public HitCounter_Atomic() {
        time = new AtomicIntegerArray(300);
        hit = new AtomicIntegerArray(300);
    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (time.get(index) != timestamp) {
            time.set(index, timestamp);
            hit.set(index, 1);
        } else {
            hit.incrementAndGet(index);//add one
        }

    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - time.get(i) < 300) {
                total += hit.get(i);
            }
        }
        return total;
    }
}

package Greedy;

import java.util.PriorityQueue;

class _1642_FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Create a priority queue with a comparator that makes it behave as a max-heap.
        PriorityQueue<Integer> brickAllocations = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 1; i < heights.length; i++) {
            int climb = heights[i] - heights[i - 1];
            // If this is actually a "jump down", skip it.
            if (climb < 0) {
                continue;
            }
            // Otherwise, allocate a ladder for this climb.
            brickAllocations.offer(climb);
            bricks -= climb;

            // If we've used all the bricks, and have no ladders remaining, then
            // we can't go any further.
            if (bricks < 0 && ladders == 0) {
                return i;
            }
            // Otherwise, if we've run out of bricks, we should replace the largest
            // brick allocation with a ladder.
            if (bricks < 0) {
                bricks += brickAllocations.poll();
                ladders--;
            }
        }

        // If we got to here, this means we had enough materials to cover every climb.
        return heights.length - 1;
    }
}

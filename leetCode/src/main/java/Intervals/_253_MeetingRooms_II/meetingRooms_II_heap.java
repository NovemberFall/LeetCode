package Intervals._253_MeetingRooms_II;

import java.util.Arrays;
import java.util.PriorityQueue;

class meetingRooms_II_heap {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (a - b));
        for (int i = 0; i < intervals.length; i++) {
            if (!minHeap.isEmpty() && minHeap.peek() <= intervals[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(intervals[i][1]);
        }
        return minHeap.size();
    }
}

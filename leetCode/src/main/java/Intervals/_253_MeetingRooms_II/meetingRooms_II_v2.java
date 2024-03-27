package Intervals._253_MeetingRooms_II;

import java.util.Arrays;

class meetingRooms_II_v2 {
    public int minMeetingRooms(int[][] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int rooms = 0, endIdx = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (start[i] < end[endIdx]) {
                rooms++;// all rooms occupied, need to allocate new room
            } else {
                endIdx++;// just re-use the room that ends previous endIdx
            }
        }

        return rooms;
    }
}

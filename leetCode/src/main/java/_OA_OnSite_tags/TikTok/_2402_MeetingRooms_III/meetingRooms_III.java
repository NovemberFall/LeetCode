package _OA_OnSite_tags.TikTok._2402_MeetingRooms_III;

import java.util.Arrays;
import java.util.PriorityQueue;

class meetingRooms_III {
    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> available = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<int[]> used = new PriorityQueue<>(
                (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        ); // (end_time, room_number)

        for (int i = 0; i < n; i++) {
            available.offer(i);
        }
        int[] count = new int[n];

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];

            // Finish meetings
            while (!used.isEmpty() && used.peek()[0] <= start) {
                int room = used.poll()[1];
                available.offer(room);
            }

            // If no room is available, extend the meeting in the earliest finishing room
            if (available.isEmpty()) {
                int[] cur = used.poll();
                int endTime = cur[0], room = cur[1];
                end = endTime + (end - start); // (end - start) represents duration
                available.offer(room);
            }

            // Assign the meeting to an available room
            if (!available.isEmpty()) {
                int room = available.poll();
                used.offer(new int[]{end, room});
                count[room]++;
            }
        }

        // Find the room with the maximum number of meetings
        int maxRoom = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxRoom]) {
                maxRoom = i;
            }
        }
        return maxRoom;
    }
}




















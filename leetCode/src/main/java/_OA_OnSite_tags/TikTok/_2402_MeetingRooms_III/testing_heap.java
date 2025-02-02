package _OA_OnSite_tags.TikTok._2402_MeetingRooms_III;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
            [3 4]
       [1         5]
          [2          7]
    [0                        10]
 */
class testing_heap {
    public static void main(String[] args) {
        PriorityQueue<int[]> engaged = new PriorityQueue<>(
                (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);

        int[][] meetings = new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}};
        for (int[] meeting : meetings) {
            engaged.offer(meeting);
        }
        System.out.println(Arrays.deepToString(engaged.toArray()));
        // [[3, 4], [1, 5], [2, 7], [0, 10]]
    }
}

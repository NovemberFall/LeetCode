package Graph._787_CheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class cheapestFlightsWithinKStops_Dijkstra {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        Map<Integer, List<int[]>> fmap = new HashMap<>();
        for (int[] flight : flights) { // flights[i] = [from, to, price]
            fmap.putIfAbsent(flight[0], new ArrayList<>());
            fmap.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        // [0]: price, [1]: curNode, [3]: stops
        minHeap.offer(new int[]{0, src, K + 1});
        Map<Integer, Integer> visited = new HashMap<>();

        while (!minHeap.isEmpty()) {
            int[] e = minHeap.poll();
            int price = e[0], cur = e[1], stops = e[2];
            if (visited.containsKey(cur) && visited.get(cur) >= stops) {
                continue;
            }
            visited.put(cur, stops);

            if (cur == dst) {
                return e[0];
            }
            if (stops > 0) {
                List<int[]> list = fmap.get(cur);
                if (list == null || list.isEmpty()) {
                    continue;
                }
                for (int[] f : list) {
                    minHeap.offer(new int[]{price + f[1], f[0], stops - 1});
                }
            }
        }
        return -1;
    }
}

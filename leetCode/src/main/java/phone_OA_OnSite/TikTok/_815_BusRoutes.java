package phone_OA_OnSite.TikTok;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class _815_BusRoutes {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int busId = 0; busId < routes.length; busId++) {
            for (int j = 0; j < routes[busId].length; j++) {
                map.putIfAbsent(routes[busId][j], new ArrayList<>());
                map.get(routes[busId][j]).add(busId);
            }
        }

        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        int res = 0;
        while (!queue.isEmpty()) {
            res++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                List<Integer> buses = map.get(stop);
                if (buses == null) {
                    continue;
                }
                for (int bus : buses) {
                    if (visitedBuses.contains(bus)) {
                        continue;
                    }// 车已经走过一次了
                    visitedBuses.add(bus);
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) {
                            return res;
                        }
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }
        return -1;
    }
}

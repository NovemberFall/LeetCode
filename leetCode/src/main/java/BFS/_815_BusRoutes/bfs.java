package BFS._815_BusRoutes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class bfs {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }

        // Build a mapping from each bus stop to the list of bus routes (bus IDs) that pass through it
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();

        for (int busId = 0; busId < routes.length; busId++) {
            for (int stop : routes[busId]) {
                // If the stop is not already in the map, initialize its list
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());

                // Add the current bus route (busId) to the list of routes serving this stop
                stopToRoutes.get(stop).add(busId);
            }
        }

        // If the source stop is not served by any route, it's impossible to proceed
        if (!stopToRoutes.containsKey(source)) {
            return -1;
        }

        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(source);

        int busCount = 0;
        while (!queue.isEmpty()) {
            busCount++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int stop = queue.poll();
                List<Integer> buses = stopToRoutes.get(stop);
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
                            return busCount;
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

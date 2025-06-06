package BFS._815_BusRoutes;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class two_end_bfs {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map from stop -> list of bus IDs that stop there
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int busId = 0; busId < routes.length; busId++) {
            for (int stop : routes[busId]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(busId);
            }
        }

        // Early exit if either source or target is not reachable by any bus
        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) return -1;

        Set<Integer> visitedBuses = new HashSet<>();
        Set<Integer> visitedFromSrc = new HashSet<>();
        Set<Integer> visitedFromDst = new HashSet<>();

        Queue<Integer> srcQueue = new ArrayDeque<>();
        Queue<Integer> dstQueue = new ArrayDeque<>();

        srcQueue.offer(source);
        dstQueue.offer(target);
        visitedFromSrc.add(source);
        visitedFromDst.add(target);

        int level = 0;

        while (!srcQueue.isEmpty() && !dstQueue.isEmpty()) {
            // Always expand the smaller frontier
            if (srcQueue.size() > dstQueue.size()) {
                Queue<Integer> tempQueue = srcQueue;
                srcQueue = dstQueue;
                dstQueue = tempQueue;

                Set<Integer> tempVisited = visitedFromSrc;
                visitedFromSrc = visitedFromDst;
                visitedFromDst = tempVisited;
            }

            int size = srcQueue.size();
            for (int i = 0; i < size; i++) {
                int stop = srcQueue.poll();

                List<Integer> busList = stopToRoutes.getOrDefault(stop, new ArrayList<>());
                for (int busId : busList) {
                    if (visitedBuses.contains(busId)) continue;
                    visitedBuses.add(busId);

                    for (int nextStop : routes[busId]) {
                        if (visitedFromDst.contains(nextStop)) {
                            return level + 1;
                        }

                        if (visitedFromSrc.add(nextStop)) {
                            srcQueue.offer(nextStop);
                        }
                    }
                }
            }

            level++;
        }

        return -1;
    }
}

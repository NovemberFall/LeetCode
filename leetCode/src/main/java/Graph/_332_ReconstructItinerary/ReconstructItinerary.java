package Graph._332_ReconstructItinerary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class ReconstructItinerary {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> res = new LinkedList<>();
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        buildGraph(tickets, map);
        dfs(res, map, "JFK");
        return res;
    }

    private void buildGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> map) {
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            map.putIfAbsent(from, new PriorityQueue<>());
            map.get(from).offer(to);
        }
    }

    private void dfs(LinkedList<String> res, Map<String, PriorityQueue<String>> map, String from) {
        PriorityQueue<String> arrivals = map.get(from);
        while (arrivals != null && !arrivals.isEmpty()) {
            String to = arrivals.poll();
            dfs(res, map, to);
        }

        res.addFirst(from);
    }
}

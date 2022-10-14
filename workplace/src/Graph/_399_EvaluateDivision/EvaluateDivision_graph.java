package Graph._399_EvaluateDivision;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
*/

public class EvaluateDivision_graph {
    static class Edge {
        double weight;
        String to;

        public Edge(String t, double w) {
            to = t;
            weight = w;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> map = new HashMap<>();
        int i = 0;
        for (List<String> e : equations) {
            List<Edge> edges0 = map.getOrDefault(e.get(0), new ArrayList<>());
            List<Edge> edges1 = map.getOrDefault(e.get(1), new ArrayList<>());
            Edge e0 = new Edge(e.get(1), values[i]);
            Edge e1 = new Edge(e.get(0), 1 / values[i]);
            edges0.add(e0);
            edges1.add(e1);
            map.put(e.get(0), edges0);
            map.put(e.get(1), edges1);
            i++;
        }

        double[] res = new double[queries.size()];
        for (i = 0; i < queries.size(); i++) {
            String begin = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            visited.add(begin);
            res[i] = helper(map, visited, begin, end, 1.0);
        }
        return res;
    }

    private double helper(Map<String, List<Edge>> map, Set<String> visited, String begin, String end, double distance) {
        if (!map.containsKey(begin)) {
            return -1.0;
        }
        if (begin.equals(end)) {
            return distance;
        }
        List<Edge> edges = map.get(begin);
        for (Edge e : edges) {
            if (!visited.contains(e.to)) {
                visited.add(e.to);
                double res = helper(map, visited, e.to, end, distance * e.weight);
                if (res != -1.0) {
                    return res;
                }
            }
        }
        return -1.0;
    }

}

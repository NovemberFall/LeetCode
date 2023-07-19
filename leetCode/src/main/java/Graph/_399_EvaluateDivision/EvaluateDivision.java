package Graph._399_EvaluateDivision;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/*
Example 1:

Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0],
queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]

Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0`
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]

*/
class EvaluateDivision {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        // Step 1). build the graph from the equations
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);


        // Step 2). Evaluate each query via bactracking (DFS)
        // by verifying if there exists a path from dividend to divisor
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String dividend = query.get(0);
            String divisor = query.get(1);

            if (!graph.containsKey(dividend) || !graph.containsKey(divisor)) {
                result[i] = -1.0;
            } else if (dividend.equals(divisor)) {
                result[i] = 1.0;
            } else {
                result[i] = dfs(graph, dividend, divisor, new HashSet<>());
            }
        }

        return result;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String start, String end, HashSet<String> visited) {
        // actually no need to check quitting condition, because if one can enter this dfs, one must iterate all children
        if (!graph.containsKey(start)) {
            return -1;
        }

        if (graph.get(start).containsKey(end)) {
            return graph.get(start).get(end);
        }

        // mark visited
        visited.add(start);
        for (String next : graph.get(start).keySet()) {
            if (visited.contains(next)) {
                continue;
            }
            double res = dfs(graph, next, end, visited);
            if (res == -1.0) {
                continue;
            }
            return res * graph.get(start).get(next);
        }

        return -1.0;
    }


    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(b).put(a, 1.0 / values[i]);
        }
        return graph;
    }

}

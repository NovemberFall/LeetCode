package Graph._399_EvaluateDivision;

import java.util.ArrayList;
import java.util.Arrays;
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

class EvaluateDivision_graph {
    class Node {
        String key;
        double val;

        public Node(String key, double val) {
            this.key = key;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> graph = buildGraph(equations, values);

        double[] res = new double[queries.size()];
        Arrays.fill(res, -1.0);
        for (int i = 0; i < queries.size(); i++) {
            res[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), graph);
        }
        return res;
    }

    private double dfs(String src, String des, HashSet<String> visited, Map<String, List<Node>> graph) {
        if (!(graph.containsKey(src) && graph.containsKey(des))) {
            return -1.0;
        }
        if (src.equals(des)) {
            return 1.0;
        }
        visited.add(src);
        for (Node node : graph.get(src)) {
            String next = node.key;
            if (visited.contains(next)) {
                continue;
            }
            double ans = dfs(next, des, visited, graph);
            if (ans == -1.0) {
                continue;
            }

            return ans * node.val;
        }
        return -1.0;
    }

    private Map<String, List<Node>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> graph = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String des = equations.get(i).get(1);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(des, new ArrayList<>());
            graph.get(src).add(new Node(des, values[i]));
            graph.get(des).add(new Node(src, 1 / values[i]));
        }
        return graph;
    }

    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(
                Arrays.asList("a", "b"),
                Arrays.asList("b", "c")
        );

        List<List<String>> queries = Arrays.asList(
                Arrays.asList("a", "c"),
                Arrays.asList("b", "a"),
                Arrays.asList("a", "e"),
                Arrays.asList("a", "a"),
                Arrays.asList("x", "x")
        );
        double[] values = new double[]{2.0, 3.0};

        EvaluateDivision_graph ed = new EvaluateDivision_graph();
        double[] ans = ed.calcEquation(equations, values, queries);
        System.out.println(Arrays.toString(ans));
    }
}

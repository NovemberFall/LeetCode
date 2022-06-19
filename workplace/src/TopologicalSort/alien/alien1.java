package TopologicalSort.alien;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class alien1 {
    public static String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words, indegree);
        return bfs(graph, indegree);
    }

    private static void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] indegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }
        for (int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            for (int j = 0; j < len; j++) {
                if (first.charAt(j) != second.charAt(j)) { // ett, rftt
                    char out = first.charAt(j);
                    char in = second.charAt(j);
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                }
            }
        }
    }

    private static String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();
        int totalChars = graph.size();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                sb.append(c);
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char out = queue.poll();
            for (char in : graph.get(out)) {
                indegree[in - 'a']--;
                if (indegree[in - 'a'] == 0) {
                    queue.offer(in);
                    sb.append(in);
                }
            }
        }
        return sb.length() == totalChars ? sb.toString() : "";
    }
}

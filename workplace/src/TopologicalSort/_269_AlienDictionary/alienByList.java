package TopologicalSort._269_AlienDictionary;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class alienByList {
    public static String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, List<Character>> graph = new HashMap<>();
        buildGraph(graph, words, indegree);
        return bfs(graph, indegree);
    }

    private static void buildGraph(Map<Character, List<Character>> graph, String[] words, int[] indegree) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new ArrayList<>());
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

    private static String bfs(Map<Character, List<Character>> graph, int[] indegree) {
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
        System.out.println(sb.toString());
        System.out.println(totalChars);
        return sb.length() == totalChars ? sb.toString() : "";
    }

    /*
        ac
        ab
        zc
        zb
    */
    public static void main(String[] args) {
        String [] words = {"ac","ab","zc","zb"};
        String res = alienOrder(words);
        System.out.println(res);
    }
}

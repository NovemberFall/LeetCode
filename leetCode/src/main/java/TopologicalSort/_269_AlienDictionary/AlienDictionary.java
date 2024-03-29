package TopologicalSort._269_AlienDictionary;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class AlienDictionary {
    public String alienOrder(String[] words) {
        int[] indegree = new int[26];
        Map<Character, Set<Character>> graph = new HashMap<>();
        buildGraph(graph, words, indegree);
        return bfs(graph, indegree);
    }

    private void buildGraph(Map<Character, Set<Character>> graph, String[] words, int[] indegree) {
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
                // ett, rftt
                char out = first.charAt(j);
                char in = second.charAt(j);
                if (out != in) {
                    if (!graph.get(out).contains(in)) {
                        graph.get(out).add(in);
                        indegree[in - 'a']++;
                    }
                    break; // ett, rftt 只有在出现第一个不相同的字符 e, r 才做比较，剩下就不再比较所以 break
                }
                // test case: ["abc","ab"], Expected: ""
                // since it is claimed that the strings in words are sorted lexicographically by the rules of this new language.
                if (j + 1 == len && first.length() > second.length()) {
                    graph.clear();
                    return;
                }
                /*  Why do we need `j + 1 == len`, look at this test case:
                ["qb","qts","qs","qa","s"]
                without `j + 1 == len`, qts.len() > qs.len(), it will return "", but "qts" come before "qs", that is correct!
                */
            }
        }
    }

    private String bfs(Map<Character, Set<Character>> graph, int[] indegree) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new ArrayDeque<>();
        int totalChars = graph.size();
        for (char c : graph.keySet()) {
            if (indegree[c - 'a'] == 0) {
                queue.offer(c);
            }
        }

        while (!queue.isEmpty()) {
            char out = queue.poll();
            sb.append(out);
            for (char in : graph.get(out)) {
                indegree[in - 'a']--;
                if (indegree[in - 'a'] == 0) {
                    queue.offer(in);
                }
            }
        }
        return sb.length() == totalChars ? sb.toString() : "";
        // 看这个例子： ["z","x","a","zb","zx"]， 很明显这里有 环 出现了，所以无法用 Topological Sort
    }
    public static void main(String[] args) {
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"abc", "ab"};
        String str = alienDictionary.alienOrder(words);
        System.out.println(str);
    }
}

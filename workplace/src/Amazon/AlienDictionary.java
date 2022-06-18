//package Amazon;
//
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.Map;
//import java.util.Set;
//
//public class AlienDictionary {
//    public String alienOrder(String[] words) {
//        if (words == null || words.length == 0) return "";
//
//        Map<Character, Set<Character>> graph = new HashMap<>();
//        int[] inDegree = new int[26];
//        buildGraph(graph, inDegree, words);
//        return bfs(graph, inDegree);
//    }
//
//    private void buildGraph(Map<Character, Set<Character>> graph, int[] inDegree, String[] words) {
//        for (String s : words) {
//            for (String word : words) {
//                for (char c : word.toCharArray()) {
//                    graph.putIfAbsent(c, new HashSet<>());
//                }
//            }
//
//            for (int i = 1; i < words.length; i++) {
//                //取出前后两个String做比较，比如 first-wrt, second-wrff
//                String first = words[i - 1];
//                String second = words[i];
//                int len = Math.min(first.length(), second.length());
//                for (int j = 0; j < len; j++) {
//                    //取出相同index的char
//                    char out = first.charAt(j);
//                    char in = second.charAt(j);
//                    if (out != in) {
//                        if (!graph.get(out).contains(in)) {
//                            graph.get(out).add(in);
//                            inDegree[in - 'a']++;
//                        }
//
//                        break;
//                    }
//
//                    if (j + 1 == len && first.length() > second.length()) {
//                        graph.clear();
//                        return;
//                    }
//                }
//            }
//        }
//    }
//}

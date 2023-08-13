package TopologicalSort;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class _207_CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];
        buildGraph(graph, prerequisites, indegree);
        return bfs(graph, indegree, numCourses);
    }

    private void buildGraph(Map<Integer, List<Integer>> graph, int[][] prerequisites, int[] indegree) {
        for (int i = 0; i < prerequisites.length; i++) {
            graph.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }
    }

    private boolean bfs(Map<Integer, List<Integer>> graph, int[] indegree, int numCourses) {
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> list = graph.get(course);
            if (list != null) {
                int n = list.size();
                for (int i = 0; i < n; i++) {
                    int pointer = graph.get(course).get(i);
                    indegree[pointer]--;
                    if (indegree[pointer] == 0) {
                        queue.offer(pointer);
                    }
                }
            }
            count++;
        }
        return count == numCourses;
    }
}

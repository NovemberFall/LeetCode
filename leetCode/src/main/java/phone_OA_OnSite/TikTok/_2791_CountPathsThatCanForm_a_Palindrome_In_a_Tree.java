package phone_OA_OnSite.TikTok;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class _2791_CountPathsThatCanForm_a_Palindrome_In_a_Tree {
    List<int[]>[] graph;
    int[] nodeVals;
    Map<Integer, Integer> map;
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();

        graph = new List[n];
        nodeVals = new int[n];
        map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            // node, bitMaskVal
            graph[parent.get(i)].add(new int[]{i, s.charAt(i) - 'a'});
            // 这一行，可以对照树形看一下，就能理解，因为 root node's parent is -1, 所以从 i = 1 开始
        }
        dfs(0, 0);

        long total = 0;
        long val = 0;
        int current = 0, nCurrent = 0;
        
        for (int i = 0; i < n; i++) {
            current = nodeVals[i];
            val = map.get(current) - 1;

            for (int j = 0; j <= 26; j++) {
                nCurrent = current ^ (1 << j);
                val += map.getOrDefault(nCurrent, 0);
            }
            total += val;
        }
        return total / 2;
    }

    private void dfs(int node, int val) {
        nodeVals[node] = val;
        int nextNode, nextBit;
        map.put(val, map.getOrDefault(val, 0) + 1);
        for (int[] next : graph[node]) {
            nextNode = next[0];
            nextBit = next[1];
            dfs(nextNode, val ^ (1 << nextBit));
        }
    }

    public static void main(String[] args) {
        _2791_CountPathsThatCanForm_a_Palindrome_In_a_Tree countPathsThatCanFormAPalindromeInATree = new _2791_CountPathsThatCanForm_a_Palindrome_In_a_Tree();
        List<Integer> parent = Arrays.asList(-1, 0, 0, 1, 1, 2);
        String s = "acaabc";
        long res = countPathsThatCanFormAPalindromeInATree.countPalindromePaths(parent, s);
        System.out.println(res);
    }
}

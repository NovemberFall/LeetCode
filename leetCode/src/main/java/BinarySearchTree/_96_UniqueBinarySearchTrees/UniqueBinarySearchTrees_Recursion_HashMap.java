package BinarySearchTree._96_UniqueBinarySearchTrees;

import java.util.HashMap;
import java.util.Map;

class UniqueBinarySearchTrees_Recursion_HashMap {
    Map<Integer, Integer> map = new HashMap<>();
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(i - 1)) {
                int leftSubtree = numTrees(i - 1);
                map.put(i - 1, leftSubtree);
            }
            if (!map.containsKey(n - i)) {
                int rightSubtree = numTrees(n - i);
                map.put(n - i, rightSubtree);
            }
            sum += map.get(i - 1) * map.get(n - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTrees_Recursion_HashMap ubstrh = new UniqueBinarySearchTrees_Recursion_HashMap();
        int res = ubstrh.numTrees(3);
        System.out.println(res); // 5
    }
}

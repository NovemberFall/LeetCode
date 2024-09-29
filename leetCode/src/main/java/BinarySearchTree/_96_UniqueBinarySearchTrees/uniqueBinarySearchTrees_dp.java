package BinarySearchTree._96_UniqueBinarySearchTrees;

import java.util.Arrays;

class uniqueBinarySearchTrees_dp {
    public int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }

        int[] numTree = new int[n + 1];
        Arrays.fill(numTree, 1);
        numTree[0] = 1;
        numTree[1] = 1;

        for (int nodes = 2; nodes < n + 1; nodes++) {
            int total = 0;
            for (int root = 1; root < nodes + 1; root++) {
                int left = root - 1;
                int right = nodes - root;
                total += numTree[left] * numTrees(right);
            }
            numTree[nodes] = total;
        }
        return numTree[n];
    }
}

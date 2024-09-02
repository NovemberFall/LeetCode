package phone_OA_OnSite.TikTok;

import java.util.ArrayList;
import java.util.List;

class _305_Number_of_Islands_II {
    int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    class UnionFind {
        private int[] parent;
        private int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1; // The initial "rank" of each vertex is 1, because each of them is a standalone vertex with no connection to other vertices.
            }
        }

        // The find function here is the same as that in the disjoint set with path compression.
        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        // The union function with union by rank
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
        }

        public boolean connected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> res = new ArrayList<>();
        UnionFind uf = new UnionFind(m * n);
        boolean[][] grid = new boolean[m][n];
        int count = 0;

        for (int[] pos : positions) {
            int row = pos[0], col = pos[1];

            // if the land is already added, skip it
            if (grid[row][col]) {
                res.add(count);
                continue;
            }

            grid[row][col] = true;
            count++;

            int index = row * n + col;
            //index is used to convert a 2D grid coordinate (row, col) into a 1D index.
            // This conversion is necessary because the Union-Find data structure is typically implemented using a 1D array. By converting 2D coordinates into a 1D index, we can efficiently store and manipulate the grid within the Union-Find structure.
            for (int[] dir : directions) {
                int curRow = row + dir[0];
                int curCol = col + dir[1];
                if (curRow < 0 || curRow >= m || curCol < 0 || curCol >= n || !grid[curRow][curCol]) {
                    continue;
                }
                int newIndex = curRow * n + curCol;
                if (!uf.connected(index, newIndex)) {
                    uf.union(index, newIndex);
                    count--;
                }
            }
            res.add(count);
        }
        return res;
    }
}





























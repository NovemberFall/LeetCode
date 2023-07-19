package Graph;

class _261_GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                return false;
            }
            uf.union(edge[0], edge[1]);
        }
        return true;
    }

    class UnionFind{
        int[] parent;
        int[] rank;

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return;

            if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else {
                parent[rootY] = rootX;
                rank[rootX] += 1;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };
        _261_GraphValidTree graphValidTree = new _261_GraphValidTree();
        boolean res = graphValidTree.validTree(5, edges);
        System.out.println(res); // true
    }
}

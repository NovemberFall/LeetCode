package Graph._323_NumberOfConnectedComponentsInA_UndirectedGraph;

class numberOfConnectedComponents_byRank {
    public int countComponents(int n, int[][] edges) {
        int numOfComponents = n;
        int unionNum = 0;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.isConnected(edge[0], edge[1])) {
                continue;
            }
            uf.union(edge[0], edge[1]);
            System.out.println("edge: " + edge[0] + " edge: " +  +  edge[1]);
            unionNum++;
            System.out.println("Union Num: " + unionNum);
        }
        return numOfComponents - unionNum;
    }

    class UnionFind{
        private int[] parent;
        private int[] rank;

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
        numberOfConnectedComponents_byRank ncci = new numberOfConnectedComponents_byRank();
        int[][] edges = new int[][]{{0, 1}, {1, 2}, {3, 4}};
        int res = ncci.countComponents(5, edges);
        System.out.println();
        System.out.println();
        System.out.println(res);
    }
}

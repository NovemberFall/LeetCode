package Graph._1584_MinCostToConnectAllPoints;

import java.util.PriorityQueue;

class MinCostToConnectAllPoints {
    // Kruskal's Algorithm
    public int minCostConnectPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }
        int size = points.length;
        PriorityQueue<Edge> minHeap = new PriorityQueue<>((x, y) -> (
                x.cost - y.cost));
        UnionFind uf = new UnionFind(size);

        for (int i = 0; i < size; i++) {
            int[] coordinate1 = points[i];
            for (int j = i + 1; j < size; j++) {
                int[] coordinate2 = points[j];
                // Calculate the distance between two coordinates.
                int cost = Math.abs(coordinate1[0] - coordinate2[0]) +
                        Math.abs(coordinate1[1] - coordinate2[1]);
                //The variable i represents the index of the first point in the points array.
                //The variable j represents the index of the second point in the points array.
                Edge edge = new Edge(i, j, cost);
                minHeap.offer(edge);
                System.out.println(edge);
            }
        }

        System.out.println("===============================================");
        System.out.println("===============================================");
        int res = 0;
        int count = 0;
        while (!minHeap.isEmpty() && count < size - 1) {
            Edge edge = minHeap.poll();
            if (!uf.isConnect(edge.point1, edge.point2)) {
                System.out.println(edge);
                uf.union(edge.point1, edge.point2);
                res += edge.cost;
                count++;
            }
        }
        return res;
    }

    class Edge {
        int point1;
        int point2;
        int cost;

        public Edge(int point1, int point2, int cost) {
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "index: " + point1 + " index: " + point2 + " cost: " + cost;
        }
    }

    class UnionFind {
        int parent[];
        int rank[];

        public UnionFind(int size) {
            parent = new int[size];
            rank = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }

        public int find(int x) {
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

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

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {2, 2}, {3, 10}, {5, 2}, {7, 0}};
        MinCostToConnectAllPoints mst = new MinCostToConnectAllPoints();
        System.out.print("Minimum Cost to Connect Points = ");
        System.out.println(mst.minCostConnectPoints(points));
    }
}

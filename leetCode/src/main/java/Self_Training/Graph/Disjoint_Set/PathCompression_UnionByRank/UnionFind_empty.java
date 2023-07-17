package Self_Training.Graph.Disjoint_Set.PathCompression_UnionByRank;

class UnionFind_empty {
    private int[] parent;
    // Use a rank array to record the height of each vertex, i.e., the "rank" of each vertex.
    private int[] rank;

    public UnionFind_empty(int size) {

    }

    // The find function here is the same as that in the disjoint set with path compression.
    public int find(int x) {
        return -1;
    }

    // The union function with union by rank
    public void union(int x, int y) {

    }

    public boolean connected(int x, int y) {
        return false;
    }

    public static void main(String[] args) {
//        UnionFind_empty uf = new UnionFind_empty(10);
//        // 1-2-5-6-7 3-8-9 4
//        uf.union(1, 2);
//        uf.union(2, 5);
//        uf.union(5, 6);
//        uf.union(6, 7);
//        uf.union(3, 8);
//        uf.union(8, 9);
//        System.out.println(uf.connected(1, 5)); // true
//        System.out.println(uf.connected(5, 7)); // true
//        System.out.println(uf.connected(4, 9)); // false
//        // 1-2-5-6-7 3-8-9-4
//        uf.union(9, 4);
//        System.out.println(uf.connected(4, 9)); // true
    }
}


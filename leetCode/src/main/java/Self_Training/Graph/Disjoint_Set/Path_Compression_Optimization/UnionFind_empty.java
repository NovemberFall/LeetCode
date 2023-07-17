package Self_Training.Graph.Disjoint_Set.Path_Compression_Optimization;

class UnionFind_empty {
    private int[] root;

    public UnionFind_empty(int size) {

    }

    public int find(int x) {
        return -1;
    }

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

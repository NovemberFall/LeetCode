package BinarySearchTree._96_UniqueBinarySearchTrees;

class UniqueBinarySearchTrees_Recursion {
    public static int numTrees(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = numTrees(3);
        System.out.println(res); // 5
    }
}

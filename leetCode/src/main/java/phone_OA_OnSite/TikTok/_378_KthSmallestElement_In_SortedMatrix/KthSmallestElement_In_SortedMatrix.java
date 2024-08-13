package phone_OA_OnSite.TikTok._378_KthSmallestElement_In_SortedMatrix;

import java.util.PriorityQueue;

class KthSmallestElement_In_SortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //Best First Search, need a minHeap on the value of each cells.
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, (o1, o2) -> o1.val - o2.val);

        //all the generated cells will be marked true to avoid being generated more than once.
        boolean[][] visited = new boolean[rows][cols];
        minHeap.offer(new Cell(0, 0, matrix[0][0]));
        visited[0][0] = true;
        //iterate k-1 rounds, and Best First Search the smallest k-1 cells
        for (int i = 0; i < k - 1; i++) {
            Cell cur = minHeap.poll();
            //the neighbor cell will be inserted back to the minheap only if
            //1. it is not out of boundary
            //2. it has not been generated before
            //Because for each cell it could be generated twice.
            if (cur.row + 1 < rows && !visited[cur.row + 1][cur.column]) {
                minHeap.offer(new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column]));
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < cols && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1]));
                visited[cur.row][cur.column + 1] = true;
            }
        }
        return minHeap.peek().val;
    }

    class Cell {
        int row;
        int column;
        int val;

        Cell(int row, int column, int val) {
            this.row = row;
            this.column = column;
            this.val = val;
        }
    }
}

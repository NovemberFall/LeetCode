package BFS.KthNum;

import java.util.Comparator;
import java.util.PriorityQueue;

public class kthSmallestNumMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        // Write your solution here
        int rows = matrix.length;
        int columns = matrix[0].length;
        //Best First Search, need a minHeap on the value of each cells.
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.val == c2.val) {
                    return 0;
                }
                return c1.val < c2.val ? -1 : 1;
            }
        });

        //all the generated cells will be marked true,
        //to avoid being generated more than once.
        boolean[][] visited = new boolean[rows][columns];
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
                minHeap.offer(
                        new Cell(cur.row + 1, cur.column, matrix[cur.row + 1][cur.column])
                );
                System.out.println(matrix[cur.row + 1][cur.column]);
                visited[cur.row + 1][cur.column] = true;
            }
            if (cur.column + 1 < columns && !visited[cur.row][cur.column + 1]) {
                minHeap.offer(
                        new Cell(cur.row, cur.column + 1, matrix[cur.row][cur.column + 1])
                );
                System.out.println(matrix[cur.row][cur.column + 1]);
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

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 5, 6},
                {2, 3, 4, 6, 8},
                {3, 4, 5, 7, 9},
                {4, 6, 9, 10, 11}};
        kthSmallestNumMatrix bfs2 = new kthSmallestNumMatrix();
        int res = bfs2.kthSmallest(matrix, 7);
        System.out.println("================= Result =================");
        System.out.println(res);
    }
}

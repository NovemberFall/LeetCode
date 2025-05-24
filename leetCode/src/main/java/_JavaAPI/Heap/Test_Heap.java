package _JavaAPI.Heap;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

class Test_Heap {
    @Test
    void test_min_heap() {
        int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        int k = 5;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                minHeap.offer(matrix[i][j]);
            }
        }
        System.out.println(minHeap.toString());
        System.out.println("************************************************");

        for (int i = 0; i < k - 1; i++) {
            minHeap.poll();
        }

        System.out.println(minHeap.size());
        System.out.println(minHeap.toString());
        System.out.println(minHeap.peek());
    }
}

package DataStructure_Implementation.Heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*
    An Data implementation of capacity limited min heap containing only int values
    with the capacity to do update and poll at a specific index.

    This is for demonstration of `percolateUp` / `percolateDown` methods and
    how to utilize these methods to do basic heap operations

    size()
    isEmpty()
    isFull()
    peek()
    poll()
    offer()
    update(int index, int value) - update the element at index to a given new value

  - left child of index: i = 2 * i + 1
  - right child of index: i = 2 * i + 2
  - parent of index: i = (i - 1) / 2
 */
class MinHeap {  // LF class 9
    private int[] array;
    private int size;

    public MinHeap(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty.");
        }
        this.array = array;
        size = array.length;
        heapify();
    }

    public MinHeap(int cap) {
        if (cap <= 0) {
            throw new IllegalArgumentException("capacity cannot be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void heapify() {
        for (int i = size / 2 - 1; i >= 0; i--) {
            percolateDown(i);
        }
    }

    // (size - 1)  =>  最后的一个node
    // (size - 1 - 1) / 2  =>  (size - 1)的parent
    // (size - 2) / 2  = size / 2 - 1
    private void percolateDown(int index) {
        // index <= size / 2 - 1    =>   刚好是落在从第一个不是leaf node的节点
        while (index <= size / 2 - 1) {
            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;
            int swapCandidate = leftChildIndex; // smallest one among leftChild and rightChild.
            // update swapCandidate if rightChild exists, and it is smaller than leftChild
            if (rightChildIndex <= size - 1 && array[leftChildIndex] >= array[rightChildIndex]) {
                swapCandidate = rightChildIndex;
            }
            // swap if necessary.
            if (array[index] > array[swapCandidate]) {
                swap(array, index, swapCandidate);
            }
        }
    }

    private void swap(int[] array, int index, int swapCandidate) {
        int tmp = array[index];
        array[index] = array[swapCandidate];
        array[swapCandidate] = tmp;
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return array[0];
    }

    public int poll() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--;
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (size == array.length) {
            array = Arrays.copyOf(array, (int) (array.length * 1.5));
        }
        array[size] = ele;
        size++;
        percolateUp(size - 1);
    }

    private void percolateUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (array[parentIndex] > array[index]) {
                swap(array, parentIndex, index);
            } else {
                break;
            }
            index = parentIndex;
        }
    }

    // return the original value.
    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("invalid index range");
        }
        int result = array[index];
        array[index] = ele;
        if (result > ele) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(9);
        minHeap.offer(1);
        minHeap.offer(9);
        minHeap.offer(11);
        minHeap.offer(33);
        minHeap.offer(78);
        minHeap.offer(90);
        minHeap.offer(20);
        minHeap.offer(8);
        minHeap.offer(19);
        System.out.println(minHeap.peek());
    }
}

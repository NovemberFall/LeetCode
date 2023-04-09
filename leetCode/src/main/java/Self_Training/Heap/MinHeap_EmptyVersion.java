package Self_Training.Heap;

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
class MinHeap_EmptyVersion {
    private int[] array;
    private int size;

    public MinHeap_EmptyVersion(int[] array) {

    }

    public MinHeap_EmptyVersion(int cap) {

    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean isFull() {
        return false;
    }

    private void heapify() {

    }


    // (size - 1)  =>  最后的一个node
    // (size - 1 - 1) / 2  =>  (size - 1)的parent
    // (size - 2) / 2  = size / 2 - 1
    private void percolateDown(int index) {

    }

    private void swap(int[] array, int index, int swapCandidate) {
        int tmp = array[index];
        array[index] = array[swapCandidate];
        array[swapCandidate] = tmp;
    }

    public int peek() {
        return 0;
    }

    public int poll() {
        return 0;
    }

    public void offer(int ele) {

    }

    private void percolateUp(int index) {

    }

    // return the original value.
    public int update(int index, int ele) {
        return 0;
    }
}

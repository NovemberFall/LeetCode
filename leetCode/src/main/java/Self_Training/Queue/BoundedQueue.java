package Self_Training.Queue;

/*
    想象一个表盘，
        Circular Array - we can connect the start and end of the array, so that it is a cycle
        index of array.length <=> index of 0

        Quick tip:
        head = head + 1 == array.length ? 0 : head + 1;
        // head = (head + 1) % array.length;
        VS.
        head++;
        array[head % array.length]
        On modulo, watch out for overflow! Wrong!  第二种不推荐，因为一直`head++`操作, 有可能超出Integer范围

        Second, we need to know when empty, when full:

        head == tail -> empty
        head == tail -> full


        two solutions:
            1. record size, size = 0 (empty), size == array.length (full)

            2.(Practice 6, video 1:50:23)
                (head + 1) % array.length == tail -> empty, head == tail -> full,
                capacity = array.length - 1 (next of head points to the head of the queue)

    单单掌握第一种办法可以吗? 很遗憾！ 不行啊！
        因为第二种办法 circular array 的思想, producer, consumer 的时候会经常使用到这种思想
        在并发，并行的系统里，非常难以维护一个size, 并发的系统里，整个系统都在操作这个size, 你不可能维护一个size,
        此时就必须用到第二个方法, 所以必须要掌握这种方法

 */ // Solution 1: record size, size = 0 (empty), size == array.length (full)
class BoundedQueue {
    int head;
    int tail;
    int size;
    Integer[] array;

    public BoundedQueue(int cap) {

    }

    public boolean offer(Integer ele) {

        return true;
    }

    public Integer peek() {

        return null;
    }

    public Integer poll() {
        return null;
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


    public static void main(String[] args) {
        BoundedQueue queue = new BoundedQueue(7);
        queue.offer(1);
        queue.offer(2);
        queue.offer(5);
        queue.offer(6);
        queue.offer(7);
        System.out.println(queue.peek()); // 1

        int poll = queue.poll();
        System.out.println(poll);// 1
        poll = queue.poll();
        System.out.println(poll);// 2
        poll = queue.poll();
        System.out.println(poll);// 5
    }
}

/*
offer:

    [ 1  ][    ][    ][    ][    ][    ]
     head
           tail

    [ 1  ][  2 ][    ][    ][    ][    ]
     head
                 tail

    [ 1  ][  2 ][  5 ][    ][    ][    ]
     head
                       tail

    [ 1  ][  2 ][  5 ][  6 ][    ][    ]
     head
                             tail

    [ 1  ][  2 ][  5 ][  6 ][  7 ][    ]
     head
                                   tail

    [ 1  ][  2 ][  5 ][  6 ][  7 ][  9 ]
     head
     tail



poll:
    [    ][  2 ][  5 ][  6 ][  7 ][  9 ]  # poll => 1
           head
     tail

    [    ][    ][  5 ][  6 ][  7 ][  9 ]  # poll => 2
                 head
     tail

    [    ][    ][    ][  6 ][  7 ][  9 ]  # poll => 5
                       head
     tail

    [    ][    ][    ][    ][  7 ][  9 ]  # poll => 6
                             head
     tail

    [    ][    ][    ][    ][    ][  9 ]  # poll => 7
                                   head
     tail

    [    ][    ][    ][    ][    ][    ]  # poll => 9
     head
     tail
 */

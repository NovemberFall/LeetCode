package DataStructure_Implementation.Queue.BoundedQueue_via_Array;

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

 */
class BoundedQueue_V2 {


}





























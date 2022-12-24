package JavaAPI.Deque;

import java.util.ArrayDeque;
import java.util.Deque;


/*
            [1, 3, -1, -3, 5, 3, 6, 7]
Insert  ==>                             <== Insert
Remove  <==                             ==> Remove
            head                   End
 */
class Test_Deque_Api {
    public static void main(String[] args) {
        //Declare Deque object
        Deque<String> deque = new ArrayDeque<>();
        // add elements to the queue using various methods
        deque.add("One");              //at the tail of this deque
        deque.addFirst("Two");
        deque.addLast("Three");
        deque.push("Four");         //at the head of this deque
        deque.offer("Five");        //at the tail of this deque
        deque.offerFirst("Six");
        deque.offerLast("Seven");
        System.out.println("Initial Deque:");
        System.out.print(deque + " ");

        // Peek () method // Returns: the head of the queue represented by this deque
        System.out.println("\n\nDeque Peek:" + deque.peek());

        // Pop () method //Returns: the element at the head of this deque
        System.out.println("\nDeque Pop:" + deque.pop());

        // Returns: the head of this deque, or null if this deque is empty
        deque.pollFirst();

        // Returns: the tail of this deque, or null if this deque is empty
        deque.pollLast();
        System.out.println("\nDeque, after removing " + "first and last elements: " + deque);
    }
}

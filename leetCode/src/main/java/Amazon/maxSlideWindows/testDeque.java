package Amazon.maxSlideWindows;

import java.util.ArrayDeque;
import java.util.Deque;
import org.junit.jupiter.api.Test;

public class testDeque {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(5);
        dq.offerLast(3);
        dq.offerLast(10);
        dq.offerLast(2);
        dq.offerLast(1);
        dq.offerLast(8);
        dq.offerLast(7);
        System.out.println(dq);

        dq.pollLast();
        System.out.println(dq);

        System.out.println(dq.peekLast());
        System.out.println(dq.peekFirst());
        System.out.println(dq.pollFirst());
    }
}

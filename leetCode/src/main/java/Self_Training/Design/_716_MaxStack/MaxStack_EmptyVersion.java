package Self_Training.Design._716_MaxStack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack_EmptyVersion {
    static class Node {
        Node prev;
        Node next;
        int val;

        public Node(int x) {
            this.val = x;
            this.prev = null;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private TreeMap<Integer, List<Node>> treeMap;

    public MaxStack_EmptyVersion() {

    }

    public void push(int x) {

    }

    public int pop() {
        return 0;
    }

    public int top() {
        return 0;
    }

    public int peekMax() {
        return 0;
    }

    public int popMax() {

        return 0;
    }

    private void remove(Node node) {

    }

    private void updateMap(Node node) {

    }

    private void append(Node node) {

    }
}

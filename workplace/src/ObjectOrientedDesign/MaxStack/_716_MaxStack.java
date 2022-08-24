package ObjectOrientedDesign.MaxStack;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class _716_MaxStack {
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

    Node head;
    Node tail;
    TreeMap<Integer, List<Node>> map;

    public _716_MaxStack() {
        head = new Node(0);
        tail = new Node(0);
        head.next = tail;
        tail.prev = head;
        map = new TreeMap<>();
    }

    public void push(int x) {
        Node newNode = new Node(x);
        newNode.prev = tail.prev;
        newNode.next = tail;
        tail.prev.next = newNode;
        tail.prev = newNode;
        map.putIfAbsent(x, new ArrayList<>());
        map.get(x).add(newNode);
    }

    public int pop() {
        int removed = tail.prev.val;
        removeNode(tail.prev);
        int listSize = map.get(removed).size();
        map.get(removed).remove(listSize - 1);
        if (listSize == 1) {
            map.remove(removed);
        }
        return removed;
    }

    public int top() {
        return tail.prev.val;
    }

    public int peekMax() {
        return map.lastKey();
    }

    public int popMax() {
        int removedMaxVal = map.lastKey();
        int listSize = map.get(removedMaxVal).size();
        Node node = map.get(removedMaxVal).remove(listSize - 1);
        removeNode(node);
        if (listSize == 1) {
            map.remove(removedMaxVal);
        }
        return removedMaxVal;
    }

    private void removeNode(Node n) {
        Node prevNode = n.prev;
        Node nextNode = n.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public static void main(String[] args) {
        _716_MaxStack maxStack = new _716_MaxStack();
        maxStack.push(1);
        maxStack.push(5);
        maxStack.push(3);
        maxStack.push(15);
        maxStack.push(5);
        maxStack.push(5);
        int para_1 = maxStack.pop();
        System.out.println(para_1);
        int para_2 = maxStack.pop();
        System.out.println(para_2);
        int para_3 = maxStack.peekMax();
        System.out.println(para_3);
        int para_4 = maxStack.popMax();
        System.out.println(para_4);
    }
}

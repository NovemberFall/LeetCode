package BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class _133_CloneGraph {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        @Override
        public String toString() {
            return "Node's value: " + this.val;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node oldNode = queue.poll();
            for (Node oldNeiNode : oldNode.neighbors) {
                if (!map.containsKey(oldNeiNode)) {
                    map.put(oldNeiNode, new Node(oldNeiNode.val));
                    queue.offer(oldNeiNode);
                }
                map.get(oldNode).neighbors.add(map.get(oldNeiNode));
            }
        }
        return newNode;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        _133_CloneGraph cloneGraph = new _133_CloneGraph();
        Node cloneNode1 = cloneGraph.cloneGraph(node1);
        System.out.println(cloneNode1.neighbors); // [Node's value: 2, Node's value: 4]
        System.out.println(cloneNode1.neighbors.get(0).neighbors); // [Node's value: 1, Node's value: 3]
        System.out.println(cloneNode1.neighbors.get(1).neighbors); // [Node's value: 1, Node's value: 3]
    }
}

















